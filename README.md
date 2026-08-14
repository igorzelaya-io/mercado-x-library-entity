# MercadoX Library - Entity

## Overview

`mercado-x-library-entity` is the domain model at the center of the MercadoX ecosystem — JPA entities, DTOs, request/response contracts, Kafka event payloads, and the incoming-port interfaces services implement. Every other module (`mercado-x-library-jpa`, `mercado-x-context`, `mercado-x-redis`) and every microservice depends on this one; it depends on nothing internal to the ecosystem.

It is a pure domain module: no repositories, no service logic, no Spring Boot application context of its own.

---

## What This Module Does NOT Do

- No JPA configuration (`mercado-x-library-jpa` owns `EntityManagerFactory`/`DataSource` setup)
- No repositories
- No service logic
- No Spring Boot autoconfiguration

---

## Domain Model

| Package | Contents |
|---|---|
| `model.auth` | `User`, `Organization`, `Branch`, `Role`, `Permission`, `RefreshTokens`, `UserNotificationPreference`, `AuditLog` |
| `model.core` | `Order`, `OrderItem`, `Item`, `Inventory`, `Category`, `Location`, `Shipment`, `Lead`, `NotificationTemplate`, `Appointment`, `Service`/`ServiceCategory` |
| `model.invoicing` | `Invoice`, `InvoiceRange`, `Payment` |
| `model.enums` | `OrderStatus`, `LeadStatus`, `PaymentStatus`/`PaymentType`, `ShippingStatus`, `TemplateChannel`, `RoleName`, `UserTypeName`, `EntityStatus`, `LanguageKey`, `NotificationTemplateName` |

### Multi-tenancy: `TenantBaseEntity`

Every tenant-scoped entity extends `TenantBaseEntity`, which declares the Hibernate `@FilterDef(name = "orgIdFilter")` that `mercado-x-library-jpa`'s `HibernateFilterAspect` enables on every repository call. The `org_id` column is deliberately `insertable = false, updatable = false` — it's populated by the database relationship (`@ManyToOne Organization`), not written directly through this field, so there's no path where application code can set an entity's tenant to something other than what its actual organization association says.

### Human-readable order IDs

`Order.generateId()` produces IDs like `ORD-20260814-4F2A1` (date + random suffix) rather than a raw UUID — deliberately readable in logs, emails, and support conversations, while still being globally unique enough for this scale.

### Order state machine

`OrderStatus` isn't just a status label — it owns its own allowed-transition graph and a `transitionTo()` guard (see `mercado-x-core`'s README for the full lifecycle diagram and why this exists).

---

## Ports (Incoming Use Cases)

`ports.incoming` defines the interfaces each microservice's `@Service` classes implement — `OrderUseCase`, `ItemUseCase`, `CartUseCase`, `CategoryUseCase`, `ClientLeadUseCase`, `LocationUseCase`, `OrderQueryUseCase`, `OrganizationUseCase`, `RegistrationUseCase`. Controllers depend on these interfaces rather than concrete service classes, keeping the boundary between "what the API can do" and "how it's implemented" explicit.

There are currently no `ports.outgoing` interfaces — repository and external-client dependencies are injected directly into services rather than abstracted behind an outbound port. This module implements the incoming-port half of a hexagonal-style architecture, not the full pattern.

---

## Request / Response Contracts

- **Requests**: `PlaceOrderRequest`, `DispatchOrderRequest`, `ClientLeadRequest`, `RegisterRequestDto`, `AuthRequestDto`, `OrgCreationRequest`. `IdempotentRequest` is a marker interface (`getIdempotencyKey()`) that `mercado-x-context`'s `IdempotencyAspect` scans a method's arguments for — implement it on a request DTO and `@IdempotentOperation` picks it up automatically.
- **Responses**: `Response<T>` / `BaseResponseDto<T>` is the standard envelope every controller across every service returns (`{ message, data }`, built via `buildResponseEntity(HttpStatus, message, payload)`), plus `PaginatedResponse` for list endpoints.
- **DTOs**: `OrderDto`, `ItemDto`, `CartDto`, `UserDto`, `OrganizationDto`, `LocationDto` — the read-model shapes returned across service boundaries, decoupled from the JPA entities so persistence changes don't automatically become API contract changes.

---

## Kafka Event Contracts

`model.enums.kafka.event.DomainEvent` is the base type for everything published to Kafka (`eventId`, `eventType`, `orgId`, `occurredAt`) — `eventId` is what `@KafkaIdempotent` dedupes on, `orgId` is a fallback/verification alongside the `x-org-id` header `KafkaProducerRecordFactory` stamps separately. `LeadCreatedEvent` extends it today; `EmailEventDto<T>` wraps a payload + recipients + template name for the email-delivery events (`ORDER_PLACING`, `ORDER_CONFIRMED`, `ORDER_CANCELLED`, `USER_REGISTRATION`).

`KafkaTopic` is the single source of truth for topic name strings, shared by every producer and consumer so a typo in a topic name is a compile error, not a silent runtime mismatch.

**Avro schemas** (`src/main/avro/*.avsc` — `OrderPayload`, `OrderEmailEvent`, `UserRegistrationEmailEvent`, `EmailRecipient`, `NotificationTemplateName`) are compiled to generated classes under `target/generated-sources/avro` and registered against the Confluent Schema Registry (`BACKWARD` compatibility, per `docker-compose.yaml`) for schema evolution tracking. No producer or consumer in the ecosystem currently serializes through the generated Avro classes, though — `mercado-x-context`'s `KafkaPubSubConfig` serializes all Kafka payloads as JSON via `JsonSerializer`/`JsonDeserializer`. The `.avsc` definitions currently document intended event shapes and enforce compatibility rules in the registry; wiring actual Avro (de)serialization through them is unfinished work, not a decision that's been made against it.

---

## Why This Exists

- Prevents entity/DTO duplication across services that all model the same `Order`, `Item`, `User`, etc.
- Guarantees consistent multi-tenant modeling (`TenantBaseEntity`) everywhere at once
- Keeps the incoming-port interfaces (`*UseCase`) as the one place the API surface of a domain concept is defined, independent of any one service's implementation

---

## Used By

- `mercado-x-library-jpa`
- `mercado-x-context`
- `mercado-x-redis`
- `mercado-x-oauth`
- `mercado-x-core`
- `mercado-x-email`

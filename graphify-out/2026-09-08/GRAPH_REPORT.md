# Graph Report - mercado-x-library-entity  (2026-09-03)

## Corpus Check
- 103 files · ~7,964 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 669 nodes · 1118 edges · 53 communities (37 shown, 16 thin omitted)
- Extraction: 99% EXTRACTED · 1% INFERRED · 0% AMBIGUOUS · INFERRED: 12 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `93f3464b`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- User
- Order
- Item
- Organization
- Branch
- NotificationTemplate
- TenantBaseEntity
- Conversation
- UserType
- Lead
- Category
- PlaceOrderRequest
- OrderItem
- Role
- PaginatedResponse
- UserDetailsImpl
- ConversationMessage
- Response
- Payment
- JsonIgnoreProperties
- OrgCreationRequest
- OrganizationWhatsAppConfig
- AuditLog
- ClientLeadRequest
- NotificationTemplateName
- ShippingStatus
- NotificationRequest.java
- RoleName
- AppTest
- OrderEmailEvent
- LanguageKey
- EntityStatus
- AiReplyGeneratedEvent
- LeadCreatedEvent
- DomainEvent.java
- WhatsAppEventPublisher.java
- SendMode
- AuthRequestDto.java
- KafkaTopic.java
- VerificationTokenDto.java
- App
- PaymentType.java
- OrganizationDto.java
- UserDto.java
- mercado-x-library-entity
- $org.example:$mercado-x-library
- OrganizationPersona
- PlatformPersona
- GoogleCalendarAuthorizationPurpose
- AiUsageLimitExceededEvent
- MasterKeyOperationException
- CLAUDE.md
- StartGoogleCalendarConnectionRequest.java

## God Nodes (most connected - your core abstractions)
1. `Organization` - 46 edges
2. `User` - 35 edges
3. `TenantBaseEntity` - 34 edges
4. `Order` - 23 edges
5. `OrderStatus` - 22 edges
6. `Item` - 21 edges
7. `Shipment` - 19 edges
8. `Branch` - 18 edges
9. `Category` - 18 edges
10. `Inventory` - 15 edges

## Surprising Connections (you probably didn't know these)
- `Conversation` --inherits--> `TenantBaseEntity`  [EXTRACTED]
  src/main/java/hn/shadowcore/mercadox/library/entity/model/ai/Conversation.java → src/main/java/hn/shadowcore/mercadox/library/entity/model/TenantBaseEntity.java
- `Branch` --inherits--> `TenantBaseEntity`  [EXTRACTED]
  src/main/java/hn/shadowcore/mercadox/library/entity/model/auth/Branch.java → src/main/java/hn/shadowcore/mercadox/library/entity/model/TenantBaseEntity.java
- `Role` --inherits--> `TenantBaseEntity`  [EXTRACTED]
  src/main/java/hn/shadowcore/mercadox/library/entity/model/auth/Role.java → src/main/java/hn/shadowcore/mercadox/library/entity/model/TenantBaseEntity.java
- `User` --inherits--> `TenantBaseEntity`  [EXTRACTED]
  src/main/java/hn/shadowcore/mercadox/library/entity/model/auth/User.java → src/main/java/hn/shadowcore/mercadox/library/entity/model/TenantBaseEntity.java
- `Category` --inherits--> `TenantBaseEntity`  [EXTRACTED]
  src/main/java/hn/shadowcore/mercadox/library/entity/model/core/Category.java → src/main/java/hn/shadowcore/mercadox/library/entity/model/TenantBaseEntity.java

## Import Cycles
- None detected.

## Communities (53 total, 16 thin omitted)

### Community 0 - "User"
Cohesion: 0.18
Nodes (13): AllArgsConstructor, Data, Entity, NoArgsConstructor, Table, Location, LocationUseCase, AllArgsConstructor (+5 more)

### Community 1 - "Order"
Cohesion: 0.07
Nodes (22): Getter, RequiredArgsConstructor, OrderStatus, CANCELLED, CLOSED, DELAYED, DELIVERED, IN_PROGRESS (+14 more)

### Community 2 - "Item"
Cohesion: 0.08
Nodes (35): Branch, AllArgsConstructor, Data, Entity, NoArgsConstructor, Table, Inventory, AllArgsConstructor (+27 more)

### Community 3 - "Organization"
Cohesion: 0.06
Nodes (48): AllArgsConstructor, Builder, Entity, Filter, Getter, NoArgsConstructor, Setter, Table (+40 more)

### Community 4 - "Branch"
Cohesion: 0.14
Nodes (11): AttributeConverter, Component, SecretKey, SecureRandom, EncryptedStringConverter, Override, MasterKeyService, EncryptedStringConverterTest (+3 more)

### Community 5 - "NotificationTemplate"
Cohesion: 0.16
Nodes (18): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, UserNotificationPreference, AllArgsConstructor (+10 more)

### Community 6 - "TenantBaseEntity"
Cohesion: 0.09
Nodes (32): MappedSuperclass, GoogleCalendarConnection, AttributeOverride, Entity, Table, AllArgsConstructor, Builder, Data (+24 more)

### Community 7 - "Conversation"
Cohesion: 0.16
Nodes (15): Conversation, AllArgsConstructor, AttributeOverride, Builder, Data, Entity, EqualsAndHashCode, NoArgsConstructor (+7 more)

### Community 8 - "UserType"
Cohesion: 0.16
Nodes (16): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, UserType, AllArgsConstructor (+8 more)

### Community 9 - "Lead"
Cohesion: 0.16
Nodes (16): AllArgsConstructor, Builder, Data, Entity, EqualsAndHashCode, NoArgsConstructor, Table, Lead (+8 more)

### Community 10 - "Category"
Cohesion: 0.20
Nodes (10): Category, AllArgsConstructor, Builder, Data, Entity, EqualsAndHashCode, Filter, NoArgsConstructor (+2 more)

### Community 11 - "PlaceOrderRequest"
Cohesion: 0.12
Nodes (15): BeforeEach, ObjectMapper, ApiError, HttpStatus, JsonIgnoreProperties, JsonInclude, ApiErrorCode, FORBIDDEN (+7 more)

### Community 12 - "OrderItem"
Cohesion: 0.23
Nodes (14): Embeddable, AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, OrderItem (+6 more)

### Community 13 - "Role"
Cohesion: 0.23
Nodes (14): AllArgsConstructor, Data, Entity, NoArgsConstructor, Table, Permission, AllArgsConstructor, Builder (+6 more)

### Community 14 - "PaginatedResponse"
Cohesion: 0.27
Nodes (5): HttpStatus, JsonSerialize, Override, ResponseEntity, PaginatedResponse

### Community 15 - "UserDetailsImpl"
Cohesion: 0.26
Nodes (5): GrantedAuthority, Getter, Override, UserDetailsImpl, UserDetails

### Community 16 - "ConversationMessage"
Cohesion: 0.23
Nodes (11): ConversationMessage, AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, MessageRole (+3 more)

### Community 17 - "Response"
Cohesion: 0.11
Nodes (13): JsonFormat, ApiResponse, HttpStatus, JsonIgnoreProperties, JsonInclude, Override, BaseResponseDto, Override (+5 more)

### Community 18 - "Payment"
Cohesion: 0.24
Nodes (11): RequiredArgsConstructor, PaymentStatus, ACCEPTED, DECLINED, IN_PROGRESS, AllArgsConstructor, Data, Entity (+3 more)

### Community 19 - "JsonIgnoreProperties"
Cohesion: 0.51
Nodes (9): Change, Entry, JsonIgnoreProperties, Message, Metadata, Status, Text, Value (+1 more)

### Community 20 - "OrgCreationRequest"
Cohesion: 0.33
Nodes (7): OrganizationUseCase, AllArgsConstructor, Builder, Getter, JsonSerialize, NoArgsConstructor, OrgCreationRequest

### Community 21 - "OrganizationWhatsAppConfig"
Cohesion: 0.22
Nodes (11): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, OrganizationWhatsAppConfig, SubscriptionPlan (+3 more)

### Community 22 - "AuditLog"
Cohesion: 0.42
Nodes (8): AuditLog, AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, Timestamp

### Community 23 - "ClientLeadRequest"
Cohesion: 0.36
Nodes (6): ClientLeadUseCase, ClientLeadRequest, AllArgsConstructor, Getter, JsonSerialize, NoArgsConstructor

### Community 24 - "NotificationTemplateName"
Cohesion: 0.15
Nodes (12): Domain Model, Human-readable order IDs, Kafka Event Contracts, MercadoX Library - Entity, Multi-tenancy: `TenantBaseEntity`, Order state machine, Overview, Ports (Incoming Use Cases) (+4 more)

### Community 25 - "ShippingStatus"
Cohesion: 0.29
Nodes (7): RequiredArgsConstructor, ShippingStatus, CANCELED, DELIVERED, IN_PROGRESS, PLACED, UNDER_REVIEW

### Community 26 - "NotificationRequest.java"
Cohesion: 0.46
Nodes (7): AllArgsConstructor, Builder, Getter, JsonSerialize, NoArgsConstructor, Setter, NotificationRequest

### Community 27 - "RoleName"
Cohesion: 0.38
Nodes (6): Getter, RequiredArgsConstructor, RoleName, ADMIN, ORG_ADMIN, USER

### Community 28 - "AppTest"
Cohesion: 0.38
Nodes (3): AppTest, Test, TestCase

### Community 30 - "LanguageKey"
Cohesion: 0.47
Nodes (5): Getter, RequiredArgsConstructor, LanguageKey, ENGLISH, SPANISH_MEX

### Community 31 - "EntityStatus"
Cohesion: 0.50
Nodes (4): EntityStatus, ACTIVE, INACTIVE, RequiredArgsConstructor

### Community 34 - "DomainEvent.java"
Cohesion: 0.83
Nodes (3): DomainEvent, Data, JsonSerialize

### Community 36 - "SendMode"
Cohesion: 0.50
Nodes (3): SendMode, FREEFORM, TEMPLATE

### Community 37 - "AuthRequestDto.java"
Cohesion: 0.83
Nodes (3): AuthRequestDto, AllArgsConstructor, Getter

### Community 46 - "OrganizationPersona"
Cohesion: 0.39
Nodes (7): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, OrganizationPersona

### Community 47 - "PlatformPersona"
Cohesion: 0.39
Nodes (7): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, PlatformPersona

### Community 48 - "GoogleCalendarAuthorizationPurpose"
Cohesion: 0.31
Nodes (6): GoogleOAuthAuthorizationTransaction, GoogleCalendarAuthorizationPurpose, CONNECT, REAUTHORIZE, GoogleCalendarAuthorizationStart, URI

## Knowledge Gaps
- **74 isolated node(s):** `mercado-x-library-entity`, `EMAIL`, `WHATSAPP`, `ACTIVE`, `CLOSED` (+69 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **16 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `TenantBaseEntity` connect `TenantBaseEntity` to `Item`, `Organization`, `NotificationTemplate`, `Conversation`, `Lead`, `Category`, `Role`?**
  _High betweenness centrality (0.115) - this node is a cross-community bridge._
- **Why does `Organization` connect `Organization` to `Item`, `NotificationTemplate`, `TenantBaseEntity`, `Lead`, `Category`, `Role`, `Payment`, `OrgCreationRequest`, `AuditLog`?**
  _High betweenness centrality (0.100) - this node is a cross-community bridge._
- **Why does `User` connect `Organization` to `User`, `TenantBaseEntity`, `UserType`, `Role`, `UserDetailsImpl`, `Payment`, `AuditLog`?**
  _High betweenness centrality (0.082) - this node is a cross-community bridge._
- **What connects `mercado-x-library-entity`, `EMAIL`, `WHATSAPP` to the rest of the system?**
  _74 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Order` be split into smaller, more focused modules?**
  _Cohesion score 0.07422402159244265 - nodes in this community are weakly interconnected._
- **Should `Item` be split into smaller, more focused modules?**
  _Cohesion score 0.07801418439716312 - nodes in this community are weakly interconnected._
- **Should `Organization` be split into smaller, more focused modules?**
  _Cohesion score 0.05879692446856626 - nodes in this community are weakly interconnected._
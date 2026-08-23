# Graph Report - .  (2026-08-21)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 549 nodes · 947 edges · 46 communities (34 shown, 12 thin omitted)
- Extraction: 100% EXTRACTED · 0% INFERRED · 0% AMBIGUOUS
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `937e6d89`
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

## God Nodes (most connected - your core abstractions)
1. `Organization` - 46 edges
2. `User` - 37 edges
3. `TenantBaseEntity` - 32 edges
4. `Order` - 23 edges
5. `OrderStatus` - 22 edges
6. `Item` - 21 edges
7. `Branch` - 20 edges
8. `Shipment` - 19 edges
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

## Communities (46 total, 12 thin omitted)

### Community 0 - "User"
Cohesion: 0.09
Nodes (26): AllArgsConstructor, Builder, Entity, EqualsAndHashCode, Filter, FilterDef, Getter, NoArgsConstructor (+18 more)

### Community 1 - "Order"
Cohesion: 0.09
Nodes (24): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, Timestamp, Order (+16 more)

### Community 2 - "Item"
Cohesion: 0.11
Nodes (22): Inventory, AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, Item (+14 more)

### Community 3 - "Organization"
Cohesion: 0.12
Nodes (26): AllArgsConstructor, Builder, Entity, Filter, Getter, NoArgsConstructor, Setter, Table (+18 more)

### Community 4 - "Branch"
Cohesion: 0.13
Nodes (25): Branch, AllArgsConstructor, Data, Entity, NoArgsConstructor, Table, Appointment, AllArgsConstructor (+17 more)

### Community 5 - "NotificationTemplate"
Cohesion: 0.16
Nodes (18): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, UserNotificationPreference, AllArgsConstructor (+10 more)

### Community 6 - "TenantBaseEntity"
Cohesion: 0.18
Nodes (18): MappedSuperclass, AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, Timestamp (+10 more)

### Community 7 - "Conversation"
Cohesion: 0.16
Nodes (14): Conversation, AllArgsConstructor, Builder, Data, Entity, EqualsAndHashCode, NoArgsConstructor, Table (+6 more)

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
Cohesion: 0.16
Nodes (7): CartUseCase, IdempotentRequest, Data, JsonSerialize, Override, PlaceOrderRequest, CartDto

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
Cohesion: 0.21
Nodes (7): BaseResponseDto, Override, Getter, HttpStatus, ResponseEntity, Setter, Response

### Community 18 - "Payment"
Cohesion: 0.24
Nodes (11): RequiredArgsConstructor, PaymentStatus, ACCEPTED, DECLINED, IN_PROGRESS, AllArgsConstructor, Data, Entity (+3 more)

### Community 19 - "JsonIgnoreProperties"
Cohesion: 0.51
Nodes (9): JsonIgnoreProperties, Change, Entry, Message, Metadata, Status, Text, Value (+1 more)

### Community 20 - "OrgCreationRequest"
Cohesion: 0.33
Nodes (7): OrganizationUseCase, AllArgsConstructor, Builder, Getter, JsonSerialize, NoArgsConstructor, OrgCreationRequest

### Community 21 - "OrganizationWhatsAppConfig"
Cohesion: 0.39
Nodes (7): AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, OrganizationWhatsAppConfig

### Community 22 - "AuditLog"
Cohesion: 0.42
Nodes (8): AuditLog, AllArgsConstructor, Builder, Data, Entity, NoArgsConstructor, Table, Timestamp

### Community 23 - "ClientLeadRequest"
Cohesion: 0.36
Nodes (6): ClientLeadUseCase, ClientLeadRequest, AllArgsConstructor, Getter, JsonSerialize, NoArgsConstructor

### Community 24 - "NotificationTemplateName"
Cohesion: 0.29
Nodes (7): Getter, NotificationTemplateName, LEAD_CREATION_TEMPLATE, ORDER_CANCELLATION_TEMPLATE, ORDER_CONFIRMATION_TEMPLATE, ORDER_REQUEST_TEMPLATE, USER_VALIDATION_TEMPLATE

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

## Knowledge Gaps
- **54 isolated node(s):** `mercado-x-library-entity`, `EMAIL`, `WHATSAPP`, `ACTIVE`, `CLOSED` (+49 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **12 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Organization` connect `Organization` to `User`, `Order`, `Item`, `Branch`, `NotificationTemplate`, `TenantBaseEntity`, `Lead`, `Category`, `Role`, `Payment`, `OrgCreationRequest`, `AuditLog`?**
  _High betweenness centrality (0.149) - this node is a cross-community bridge._
- **Why does `TenantBaseEntity` connect `TenantBaseEntity` to `User`, `Order`, `Item`, `Organization`, `Branch`, `NotificationTemplate`, `Conversation`, `Lead`, `Category`, `Role`?**
  _High betweenness centrality (0.142) - this node is a cross-community bridge._
- **Why does `User` connect `User` to `Order`, `Organization`, `Branch`, `TenantBaseEntity`, `UserType`, `Role`, `UserDetailsImpl`, `Payment`, `AuditLog`?**
  _High betweenness centrality (0.128) - this node is a cross-community bridge._
- **What connects `mercado-x-library-entity`, `EMAIL`, `WHATSAPP` to the rest of the system?**
  _54 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `User` be split into smaller, more focused modules?**
  _Cohesion score 0.08771929824561403 - nodes in this community are weakly interconnected._
- **Should `Order` be split into smaller, more focused modules?**
  _Cohesion score 0.08534850640113797 - nodes in this community are weakly interconnected._
- **Should `Item` be split into smaller, more focused modules?**
  _Cohesion score 0.10606060606060606 - nodes in this community are weakly interconnected._
# MercadoX Library - Entity

## Overview

`mercado-x-library-entity` contains the **domain entities and shared DTOs** used across the MercadoX ecosystem.

It acts as the central data model definition module.

---

## Responsibilities

- Hibernate/JPA Entities
- Base Entities (e.g., TenantBaseEntity)
- Enumerations
- Shared DTOs
- Domain constants

---

## What This Module Does NOT Do

- No JPA configuration
- No repositories
- No service logic
- No Spring Boot configuration

It is strictly a **pure domain model module**.

---

## Why This Exists

To:

- Prevent entity duplication across services
- Ensure consistent domain modeling
- Support multi-tenant structure (orgId-based)
- Provide reusable DTO definitions

---

## Used By

- mercado-x-library-jpa
- mercado-x-oauth
- mercado-x-core
- mercado-x-email
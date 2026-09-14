# Database Schema — MyPage Insurance Product Wizard

All tables are in a PostgreSQL 15 database managed by Prisma ORM.

---

## Entity Relationship Diagram

```
ProductRegistry
    │
    ├──── ProductConfig (1:1)
    │         └── formSchema (JSON)
    │         └── rateTable (JSON)
    │
    └──── ProductPlan (1:many)
              └── ProductBenefit (1:many)
```

---

## Tables

### `product_registry`
The central table for all insurance products — both platform-native and synced from Liferay.

| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | UUID | PK, default uuid() | Internal unique identifier |
| `code` | VARCHAR | UNIQUE, NOT NULL | e.g. `PROPERTY_INSURANCE`, `PET_INSURANCE` |
| `name` | VARCHAR | NOT NULL | Display name |
| `source` | VARCHAR | NOT NULL, default 'platform' | `'platform'` or `'liferay'` |
| `liferay_id` | INT | NULLABLE | Liferay `productId` if source = liferay |
| `status` | VARCHAR | NOT NULL, default 'draft' | `'draft'`, `'active'`, `'inactive'` |
| `product_type` | VARCHAR | NULLABLE | `Motor`, `Property`, `Health`, `Travel`, etc. |
| `is_b2c` | BOOLEAN | NOT NULL, default true | Available for direct customers |
| `is_b2b` | BOOLEAN | NOT NULL, default false | Available for corporate clients |
| `is_b2b2c` | BOOLEAN | NOT NULL, default false | Available via intermediaries |
| `icon_url` | TEXT | NULLABLE | URL to product icon image |
| `created_at` | TIMESTAMP | NOT NULL, default now() | Creation timestamp |
| `updated_at` | TIMESTAMP | NOT NULL, auto-update | Last modification timestamp |

**Indexes:** `idx_product_registry_code`, `idx_product_registry_status`, `idx_product_registry_source`

---

### `product_config`
Stores admin configuration and the dynamic JSON schemas for each product. One-to-one with `product_registry`.

| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | UUID | PK | Internal identifier |
| `product_id` | UUID | FK → product_registry.id (CASCADE DELETE), UNIQUE | Parent product |
| `version` | INT | NOT NULL, default 1 | Config version (increments on publish) |
| `ojk_name` | VARCHAR | NULLABLE | Official OJK regulatory product name |
| `stamp_duty_idr` | DOUBLE | NOT NULL, default 0 | Stamp duty in IDR |
| `stamp_duty_usd` | DOUBLE | NOT NULL, default 0 | Stamp duty in USD |
| `policy_cost_idr` | DOUBLE | NOT NULL, default 0 | Administration fee in IDR |
| `policy_cost_usd` | DOUBLE | NOT NULL, default 0 | Administration fee in USD |
| `commission` | DOUBLE | NOT NULL, default 0 | Agent commission percentage |
| `grace_period` | INT | NOT NULL, default 30 | Grace period in days |
| `pep_enabled` | BOOLEAN | NOT NULL, default false | Whether PEP screening is required |
| `policy_wording_url` | TEXT | NULLABLE | URL to policy wording PDF document |
| `form_schema` | JSONB | NULLABLE | Dynamic customer purchase form definition |
| `rate_table` | JSONB | NULLABLE | Rate calculation variables and matrix |
| `updated_at` | TIMESTAMP | NOT NULL, auto-update | Last modification timestamp |

**JSON Schema — `form_schema`:**
```json
{
  "steps": [
    {
      "id": "step-1",
      "title": "Property Details",
      "fields": [
        {
          "id": "field-uuid",
          "name": "propertyType",
          "label": "Property Type",
          "type": "select",
          "required": true,
          "source": "static",
          "staticOptions": [
            { "label": "House", "value": "house" },
            { "label": "Apartment", "value": "apartment" }
          ],
          "conditionalDisplay": null
        },
        {
          "id": "field-uuid-2",
          "name": "province",
          "label": "Province",
          "type": "select",
          "required": true,
          "source": "liferay:provinces"
        }
      ]
    }
  ]
}
```

**JSON Schema — `rate_table`:**
```json
{
  "variables": [
    {
      "name": "Building Type",
      "values": ["Permanent", "Semi-Permanent", "Non-Permanent"]
    },
    {
      "name": "Occupancy Zone",
      "values": ["Zone 1", "Zone 2", "Zone 3"]
    }
  ],
  "matrix": {
    "Permanent|Zone 1": 0.00200,
    "Permanent|Zone 2": 0.00250,
    "Permanent|Zone 3": 0.00300,
    "Semi-Permanent|Zone 1": 0.00350,
    "Semi-Permanent|Zone 2": 0.00400,
    "Semi-Permanent|Zone 3": 0.00450,
    "Non-Permanent|Zone 1": 0.00500,
    "Non-Permanent|Zone 2": 0.00600,
    "Non-Permanent|Zone 3": 0.00750
  }
}
```

---

### `product_plan`
Stores insurance plan tiers for each product (e.g. Basic, Silver, Gold, Platinum).

| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | UUID | PK | Internal identifier |
| `product_id` | UUID | FK → product_registry.id (CASCADE DELETE), NOT NULL | Parent product |
| `name` | VARCHAR | NOT NULL | Plan display name (e.g. "Gold") |
| `tier` | VARCHAR | NULLABLE | `basic`, `silver`, `gold`, `platinum` |
| `description` | TEXT | NULLABLE | Short description of the plan |
| `sort_order` | INT | NOT NULL, default 0 | Display order (for ordering plans in UI) |

**Index:** `idx_product_plan_product_id`

---

### `product_benefit`
Stores individual benefits within each plan.

| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | UUID | PK | Internal identifier |
| `plan_id` | UUID | FK → product_plan.id (CASCADE DELETE), NOT NULL | Parent plan |
| `name` | VARCHAR | NOT NULL | Benefit name (e.g. "Fire Coverage") |
| `value` | VARCHAR | NULLABLE | Benefit value (e.g. "100%", "Up to 500jt") |
| `unit` | VARCHAR | NULLABLE | Value unit (e.g. "of SI", "IDR") |
| `highlight` | BOOLEAN | NOT NULL, default false | Whether to visually highlight this benefit |
| `sort_order` | INT | NOT NULL, default 0 | Display order within the plan |

**Index:** `idx_product_benefit_plan_id`

---

## Migration Notes

- All migrations are stored in `packages/api/prisma/migrations/`
- Always use **additive migrations** in production (add columns, never drop)
- To add a new column: create migration, default to `null` or a safe default value
- To run migrations in OpenShift: set up an init container or post-deploy hook that runs `npx prisma migrate deploy`

## Relationship to Liferay

The platform database does **not** replicate all of Liferay's data. It only stores:
1. Platform-native products (full data ownership)
2. Liferay-synced products (lightweight metadata + `liferay_id` FK reference)

All master data (provinces, cities, occupations, banks) remains in Liferay and is fetched on demand via the Liferay Bridge. This avoids data duplication and ensures master data stays consistent.

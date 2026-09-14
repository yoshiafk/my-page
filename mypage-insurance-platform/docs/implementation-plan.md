# Implementation Plan — MyPage Insurance Product Wizard

**Version:** 3.0 (Scope-Adjusted)
**Last Updated:** 2026-09-09
**Status:** Approved — Ready for Execution

---

## Scope Definition

> [!IMPORTANT]
> **This project is scoped to the Product Wizard only.**
> The customer purchase portal, agent portal, and all Liferay-based purchase flows are **out of scope** for this phase.
> Liferay continues to serve customers and agents unchanged.

### In Scope
- Internal Admin Product Wizard (React web app)
- Product configuration API (Node.js/TypeScript)
- Liferay integration for reading/writing existing product configurations
- OneAccount OIDC authentication (internal users only)

### Out of Scope (Liferay continues to handle these)
- Customer-facing purchase flows
- Agent portal and policy management
- Payment processing
- Policy issuance
- Lead/quote management

---

## Final Decisions

| Decision | Choice |
|---|---|
| Package Manager | **npm workspaces** (not pnpm) |
| Backend | Node.js 20 LTS + TypeScript + Fastify |
| Database | PostgreSQL 15 + Prisma ORM |
| Frontend | React 18 + Vite + TypeScript |
| Styling | Tailwind CSS + Shadcn UI (AXA Design System) |
| Forms | React Hook Form + Zod |
| State | Zustand (local) + TanStack Query (server) |
| Auth | **OneAccount** — Internal AXA OIDC Provider |
| Deployment | Docker / OpenShift (flexible via env vars) |
| Project Location | `c:\Work Github\mypage-insurance-platform` |

---

## Problem Statement

Adding a new insurance product to `my-page-liferay` currently requires:
1. A developer to modify the monolithic 2,000+ line `service.xml`
2. Running Liferay Service Builder (code generation)
3. Writing new Java admin portlet classes and JSPs
4. Manual wiring to existing payment and lead modules

This takes **2–3 weeks per product** and requires rare Liferay expertise.

The Product Wizard replaces step 1–3 entirely. Product configurations are stored in the platform database and exposed via API. Liferay reads these configurations at runtime instead of having them hardcoded in the database schema.

---

## Architecture

### System Overview

```
┌──────────────────────────────────────────────────────────┐
│                  OneAccount OIDC                          │
│            (Internal AXA SSO — JWT tokens)               │
└──────────────────────────┬───────────────────────────────┘
                           │
               ┌───────────▼───────────┐
               │   Product Wizard UI   │
               │   (React — Internal   │
               │   admin tool only)    │
               │                       │
               │  - Product list       │
               │  - Create new product │
               │  - Edit product       │
               │  - Publish product    │
               └───────────┬───────────┘
                           │
               ┌───────────▼───────────┐
               │   Platform API        │
               │ (Node.js/TypeScript)  │
               │                       │
               │  - /products CRUD     │
               │  - /plans CRUD        │
               │  - /rates CRUD        │
               │  - /sync-liferay      │
               └─────────┬─────────────┘
               │         │             │
    ┌──────────▼──┐  ┌───▼──────────┐  │
    │ Platform DB  │  │ Liferay      │  │
    │ (PostgreSQL) │  │ Bridge       │  │
    │              │  │ (read/write  │  │
    │ product_     │  │  existing    │  │
    │ registry     │  │  products    │  │
    │ product_     │  │  via JSONWS) │  │
    │ config       │  └──────────────┘  │
    │ product_plan │                    │
    │ product_rate │                    │
    └──────────────┘                    │
                                        │
               ┌────────────────────────▼──────────────────┐
               │         Liferay Portal (unchanged)         │
               │   my-page-liferay                          │
               │                                            │
               │  Customers & Agents continue using this    │
               │  ✅ SmartPay, MypageLeads, Pet, SmartTravel│
               │  ✅ Product configs now read from API       │
               │     instead of service.xml                 │
               └────────────────────────────────────────────┘
```

### Project Structure (npm workspaces)

```
mypage-insurance-platform/
├── packages/
│   ├── api/                          ← Node.js + TypeScript API
│   │   ├── src/
│   │   │   ├── modules/
│   │   │   │   ├── auth/             ← OneAccount OIDC middleware
│   │   │   │   ├── products/         ← Product registry CRUD
│   │   │   │   ├── plans/            ← Plans & benefits management
│   │   │   │   ├── rates/            ← Rate table management
│   │   │   │   └── liferay-bridge/   ← Adapter for Liferay JSONWS APIs
│   │   │   ├── shared/
│   │   │   │   ├── middleware/       ← Auth guard, error handler
│   │   │   │   └── utils/
│   │   │   └── main.ts
│   │   ├── prisma/
│   │   │   ├── schema.prisma
│   │   │   └── migrations/
│   │   ├── Dockerfile
│   │   └── package.json
│   │
│   └── admin/                        ← React Product Wizard UI
│       ├── src/
│       │   ├── pages/
│       │   │   ├── Dashboard.tsx
│       │   │   ├── ProductList.tsx
│       │   │   ├── ProductCreate.tsx
│       │   │   └── ProductEdit.tsx
│       │   ├── features/
│       │   │   ├── product-wizard/   ← 6-step new product wizard
│       │   │   │   ├── Step1Identity.tsx
│       │   │   │   ├── Step2Plans.tsx
│       │   │   │   ├── Step3Rates.tsx
│       │   │   │   ├── Step4FormBuilder.tsx
│       │   │   │   ├── Step5AdminConfig.tsx
│       │   │   │   └── Step6Preview.tsx
│       │   │   └── rate-table/       ← Rate matrix editor
│       │   ├── components/           ← Shared UI components (Shadcn-based)
│       │   ├── stores/               ← Zustand stores
│       │   ├── hooks/                ← TanStack Query hooks
│       │   └── App.tsx
│       ├── Dockerfile
│       └── package.json
│
├── docs/
│   ├── implementation-plan.md        ← This document
│   ├── task-plan.md
│   ├── agent-tasks.md
│   ├── api-contracts.md
│   └── database-schema.md
│
├── docker-compose.yml
├── openshift/
│   ├── deployment-api.yaml
│   ├── deployment-admin.yaml
│   └── configmap.yaml
├── .env.example
├── .gitignore
└── package.json                      ← npm workspaces root
```

---

## The Product Wizard — Core Feature Detail

The Product Wizard is the heart of this project. It is a **6-step multi-page form** used exclusively by the internal product team to configure insurance products.

### Step 1 — Product Identity
Fields:
- Product Name (text)
- Product Code (auto-slugified, e.g. `PROPERTY_INSURANCE`)
- OJK Name (official regulatory name)
- Product Icon (file upload)
- Product Type (dropdown: Motor / Property / Health / Travel / Life / Other)
- Distribution: B2C toggle, B2B toggle, B2B2C toggle

### Step 2 — Plans & Benefits
- Add/remove plan rows (e.g. Basic, Silver, Gold, Platinum)
- For each plan: name, tier, short description, price basis
- For each plan: add/remove benefit rows (benefit name, value, unit, highlighted flag)
- Drag-and-drop to reorder plans and benefits

### Step 3 — Rate Table
- Define rating variables (e.g. `Building Type`, `Occupancy Zone`, `Sum Insured Band`)
- For each variable: define allowed values/bands
- Auto-generate a rate matrix grid from defined variables
- Fill in rate multiplier cells (decimal number input)
- Import from CSV option for large rate tables

### Step 4 — Purchase Form Schema Builder
This step defines what the customer purchase form in Liferay should look like. The output is a JSON `FormSchema` that Liferay will read to render its purchase flow dynamically.
- Add/remove form steps (Step 1, Step 2, etc.)
- Drag-and-drop field palette into form canvas
- Supported field types: Text, Number, Date, Select, Radio, Checkbox, File Upload, Address (Province/City cascade), Phone
- For Select fields: define option source (static list or Liferay master data)
- Set required/optional per field
- Set conditional display rules (show field only if another field equals a value)
- Preview pane shows real-time form preview

### Step 5 — Admin Configuration
- Stamp Duty IDR, Stamp Duty USD
- Policy Cost IDR, Policy Cost USD
- Commission Percentage
- Grace Period (days)
- PEP (Politically Exposed Person) screening: enable/disable
- Policy Wording PDF upload (stored in Liferay Document Library)

### Step 6 — Review & Publish
- Full summary of all configured values
- Live preview of the generated FormSchema JSON
- Diff view when editing an existing product (shows what changed)
- Two actions:
  - **Save as Draft** — saved to DB, not visible in Liferay yet
  - **Publish** — immediately visible; Liferay reads via API

---

## OneAccount OIDC Integration

The Product Wizard is an **internal tool** — only authenticated AXA employees with the correct role can access it.

### Auth Flow
```
User visits Admin Wizard URL
        ↓
API checks for valid JWT
        ↓ (not found)
Redirect to OneAccount OIDC Authorization Endpoint
        ↓
User logs in with AXA corporate credentials
        ↓
OneAccount redirects back with Authorization Code
        ↓
API exchanges code → receives ID token + access token
        ↓
API issues its own short-lived session JWT
        ↓
All subsequent API calls carry Bearer JWT in header
```

### Role-Based Access
- `product-admin` role → full CRUD on all products
- `product-viewer` role → read-only view of all configurations

---

## Liferay Bridge

The platform reads existing Liferay product configurations to:
1. Display them alongside new platform products in the Product Wizard dashboard
2. Allow editing of safe config fields (name, OJK name, commission, stamp duty) that write back to Liferay via JSONWS

### How it works
```
Product Wizard: GET /api/products
                    ↓
Platform API calls Liferay JSONWS:
GET /api/jsonws/mp.productconfiguration/get-product-configurations
                    ↓
Platform normalizes and merges:
[
  { source: 'platform', name: 'Property Insurance', status: 'draft' },
  { source: 'liferay',  name: 'Pet Insurance',      status: 'active' },
  { source: 'liferay',  name: 'SmartTravel Int',    status: 'active' },
]
                    ↓
Returns unified list to React admin UI
```

### What can be edited for Liferay products
| Field | Editable via Wizard | Notes |
|---|---|---|
| Product Name | ✅ Yes | Writes to Liferay JSONWS |
| OJK Name | ✅ Yes | Writes to Liferay JSONWS |
| Commission % | ✅ Yes | Writes to Liferay JSONWS |
| Stamp Duty | ✅ Yes | Writes to Liferay JSONWS |
| Policy Cost | ✅ Yes | Writes to Liferay JSONWS |
| B2C/B2B toggles | ✅ Yes | Writes to Liferay JSONWS |
| Icon / PDF upload | ✅ Yes | Writes to Liferay Document Library |
| Database schema | ❌ No | Requires Liferay Service Builder — developer task |
| Plans & Rates | ❌ No | Schema-level change in Liferay (for now) |

---

## Delivery Phases

### Phase 1: Foundation (Week 1)
- npm workspaces setup
- Fastify API skeleton + Prisma + PostgreSQL
- React app scaffold with Tailwind + Shadcn UI
- OneAccount OIDC auth flow (login, callback, JWT validation)
- Docker Compose for local development

### Phase 2: API Core (Week 2)
- Product CRUD endpoints (`GET`, `POST`, `PUT`, `DELETE /api/products`)
- Plans & Benefits CRUD endpoints
- Rate table CRUD endpoints
- Liferay Bridge (sync existing products from Liferay JSONWS)
- Write-back to Liferay for editable fields

### Phase 3: Product Wizard UI (Weeks 3–4)
- Product list/dashboard page
- 6-step Product Creation Wizard
- Product Edit page (platform products: full edit; Liferay products: restricted edit)
- Form Schema Builder (Step 4 of wizard)
- Rate Table Matrix Editor (Step 3 of wizard)

### Phase 4: Deployment & Testing (Week 5)
- Deploy to OpenShift or Docker (same server)
- Configure OneAccount redirect URIs
- Liferay CORS policy update (allow platform API domain)
- End-to-end test: create Property Insurance product via wizard
- Handover to product team

---

## Timeline Summary

| Phase | Description | Duration |
|---|---|---|
| Phase 1 | Foundation & Auth | 1 week |
| Phase 2 | API Core + Liferay Bridge | 1 week |
| Phase 3 | Product Wizard UI | 2 weeks |
| Phase 4 | Deployment & Testing | 1 week |
| **Total** | | **~5 weeks** |

---

## Risk Assessment

| Risk | Severity | Mitigation |
|---|---|---|
| OneAccount OIDC redirect URIs not set up | 🔴 High | Raise with OneAccount team in Week 1 |
| Liferay JSONWS doesn't expose all product fields needed | 🟡 Medium | Add targeted JAX-RS endpoint if needed |
| Rate table editor UX complexity | 🟡 Medium | Start with manual cell entry; CSV import in v2 |
| Liferay CORS policy blocking platform API calls | 🟡 Medium | Coordinate with Liferay infra team early |
| npm workspace dependency hoisting conflicts | 🟢 Low | Use explicit versioning in each package |

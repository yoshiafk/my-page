# Task Plan — MyPage Insurance Product Wizard

**Format:** `[ ]` Not Started | `[/]` In Progress | `[x]` Done
**Package Manager:** npm workspaces
**Last Updated:** 2026-09-09

---

## Phase 1: Foundation & Scaffolding
**Target Duration:** 1 Week
**Status:** ✅ Scaffolding Complete — npm install in progress

### 1.1 npm Workspaces Root Setup
- [ ] Create root `package.json` with `"workspaces": ["packages/*"]`
- [ ] Create root `tsconfig.base.json` (strict TypeScript, ES2022, module NodeNext)
- [ ] Create root `.eslintrc.js` (TypeScript + React rules)
- [ ] Create root `.prettierrc`
- [ ] Create root `.gitignore` (node_modules, dist, .env, prisma/dev.db)
- [ ] Create `.env.example` with all required variables:
  ```
  # Database
  DATABASE_URL=postgresql://user:password@localhost:5432/insurance_platform

  # OneAccount OIDC
  OIDC_ISSUER_URL=https://oneaccount.axa.co.id
  OIDC_CLIENT_ID=
  OIDC_CLIENT_SECRET=
  OIDC_REDIRECT_URI=http://localhost:3001/auth/callback

  # JWT
  JWT_SECRET=
  JWT_EXPIRES_IN=8h

  # Liferay
  LIFERAY_BASE_URL=https://mypage.axa.co.id
  LIFERAY_API_USER=
  LIFERAY_API_PASSWORD=

  # API
  API_PORT=3001
  ADMIN_PORT=5173
  ```
- [ ] Run `npm install` from root — confirm workspaces resolve correctly

### 1.2 API Package — `packages/api`
- [ ] Create `packages/api/package.json`:
  ```json
  {
    "name": "@insurance/api",
    "scripts": {
      "dev": "tsx watch src/main.ts",
      "build": "tsc",
      "start": "node dist/main.js"
    },
    "dependencies": {
      "fastify": "^4",
      "@fastify/cors": "^8",
      "@fastify/helmet": "^11",
      "@fastify/jwt": "^8",
      "@fastify/env": "^4",
      "@fastify/multipart": "^8",
      "@prisma/client": "^5",
      "openid-client": "^5",
      "zod": "^3",
      "axios": "^1",
      "pino-pretty": "^10"
    },
    "devDependencies": {
      "prisma": "^5",
      "typescript": "^5",
      "tsx": "^4"
    }
  }
  ```
- [ ] Create `packages/api/tsconfig.json` (extends root base)
- [ ] Create `packages/api/src/main.ts` (Fastify server init)
- [ ] Register Fastify plugins: cors, helmet, jwt, env, multipart
- [ ] Create global error handler (normalizes Zod + Prisma errors)
- [ ] Create structured request logger (Pino)
- [ ] Add `GET /health` endpoint returning `{ status: 'ok', timestamp }`
- [ ] Create `packages/api/Dockerfile` (multi-stage: `node:20-alpine` builder + runner)

### 1.3 Database Setup
- [ ] Create `packages/api/prisma/schema.prisma`:
  ```prisma
  generator client {
    provider = "prisma-client-js"
  }

  datasource db {
    provider = "postgresql"
    url      = env("DATABASE_URL")
  }

  model ProductRegistry {
    id            String   @id @default(uuid())
    code          String   @unique
    name          String
    source        String   @default("platform") // 'platform' | 'liferay'
    liferayId     Int?
    status        String   @default("draft")    // 'draft' | 'active' | 'inactive'
    productType   String?
    isB2C         Boolean  @default(true)
    isB2B         Boolean  @default(false)
    isB2B2C       Boolean  @default(false)
    iconUrl       String?
    createdAt     DateTime @default(now())
    updatedAt     DateTime @updatedAt
    config        ProductConfig?
    plans         ProductPlan[]
  }

  model ProductConfig {
    id             String          @id @default(uuid())
    productId      String          @unique
    product        ProductRegistry @relation(fields: [productId], references: [id])
    version        Int             @default(1)
    ojkName        String?
    stampDutyIDR   Float           @default(0)
    stampDutyUSD   Float           @default(0)
    policyCostIDR  Float           @default(0)
    policyCostUSD  Float           @default(0)
    commission     Float           @default(0)
    gracePeriod    Int             @default(30)
    pepEnabled     Boolean         @default(false)
    policyWordingUrl String?
    formSchema     Json?
    rateTable      Json?
    updatedAt      DateTime        @updatedAt
  }

  model ProductPlan {
    id          String          @id @default(uuid())
    productId   String
    product     ProductRegistry @relation(fields: [productId], references: [id])
    name        String
    tier        String?
    description String?
    sortOrder   Int             @default(0)
    benefits    ProductBenefit[]
  }

  model ProductBenefit {
    id        String      @id @default(uuid())
    planId    String
    plan      ProductPlan @relation(fields: [planId], references: [id])
    name      String
    value     String?
    unit      String?
    highlight Boolean     @default(false)
    sortOrder Int         @default(0)
  }
  ```
- [ ] Run `npx prisma migrate dev --name init` to generate initial migration
- [ ] Run `npx prisma generate` to generate Prisma Client
- [ ] Create `packages/api/prisma/seed.ts` with sample product data
- [ ] Add seed script to `package.json`: `"prisma": { "seed": "tsx prisma/seed.ts" }`

### 1.4 OneAccount OIDC Auth
- [ ] Create `packages/api/src/modules/auth/oidc.service.ts`:
  - [ ] `discoverOIDC()` — reads `OIDC_ISSUER_URL/.well-known/openid-configuration`
  - [ ] `getAuthorizationUrl(state)` — builds redirect URL to OneAccount
  - [ ] `handleCallback(code, state)` — exchanges code for tokens
  - [ ] `getUserInfo(accessToken)` — fetches user profile from OneAccount
- [ ] Create auth routes:
  - [ ] `GET /auth/login` → generates state, redirects to OneAccount
  - [ ] `GET /auth/callback` → exchanges code, issues platform JWT, redirects to admin UI
  - [ ] `POST /auth/logout` → clears JWT cookie
  - [ ] `GET /auth/me` → returns decoded JWT user payload
- [ ] Create `authMiddleware` Fastify hook for protected routes (validates Bearer JWT)
- [ ] Create `roleGuard('product-admin')` hook for write operations

### 1.5 Admin React App — `packages/admin`
- [ ] Scaffold with: `npm create vite@latest admin -- --template react-ts`
- [ ] Install Tailwind CSS:
  ```bash
  npm install -D tailwindcss postcss autoprefixer
  npx tailwindcss init -p
  ```
- [ ] Configure `tailwind.config.js` with AXA design tokens:
  ```js
  colors: {
    'axa-blue': '#00008F',
    'axa-dark': '#000067',
    'axa-light': '#E6E6F5',
    'axa-accent': '#4976BA',
    'axa-red': '#FF1721',
    'axa-success': '#1CC54E',
    'axa-error': '#C91432',
    'axa-surface': '#F5F5F5',
    'axa-border': '#CCCCCC',
    'axa-text': '#333333',
    'axa-muted': '#5F5F5F',
  }
  ```
- [ ] Initialize Shadcn UI: `npx shadcn-ui@latest init`
- [ ] Install Shadcn components needed:
  ```bash
  npx shadcn-ui@latest add button input label select switch badge card table
  npx shadcn-ui@latest add dialog drawer toast progress separator tabs
  ```
- [ ] Install runtime dependencies:
  ```bash
  npm install @tanstack/react-query zustand react-router-dom
  npm install react-hook-form @hookform/resolvers zod
  npm install lucide-react framer-motion
  npm install @dnd-kit/core @dnd-kit/sortable @dnd-kit/utilities
  ```
- [ ] Set up React Router v6 in `App.tsx`
- [ ] Set up `QueryClientProvider` (TanStack Query) in `main.tsx`
- [ ] Create Zustand store stubs: `useProductWizardStore`, `useAuthStore`
- [ ] Create `packages/admin/Dockerfile` (Nginx-based)

### 1.6 Docker Compose
- [ ] Create root `docker-compose.yml`:
  ```yaml
  version: '3.8'
  services:
    postgres:
      image: postgres:15-alpine
      environment:
        POSTGRES_DB: insurance_platform
        POSTGRES_USER: admin
        POSTGRES_PASSWORD: password
      ports:
        - "5432:5432"
      volumes:
        - pgdata:/var/lib/postgresql/data

    api:
      build:
        context: ./packages/api
        dockerfile: Dockerfile
      ports:
        - "3001:3001"
      env_file: .env
      depends_on:
        - postgres

    admin:
      build:
        context: ./packages/admin
        dockerfile: Dockerfile
      ports:
        - "3000:80"

  volumes:
    pgdata:
  ```
- [ ] Test `docker-compose up` — all services start successfully
- [ ] Test `GET http://localhost:3001/health` returns 200

---

## Phase 2: API Core & Liferay Bridge
**Target Duration:** 1 Week
**Status:** ✅ Complete

### 2.1 Liferay Bridge Module
- [ ] Create `packages/api/src/modules/liferay-bridge/liferay.client.ts`:
  - [ ] Base HTTP client using Axios (configured with Liferay base URL + Basic Auth)
  - [ ] `getProductConfigurations()` → calls `/api/jsonws/mp.productconfiguration/get-all`
  - [ ] `updateProductConfiguration(id, data)` → calls `/api/jsonws/mp.productconfiguration/update`
  - [ ] `getMasterProvinces()` → calls `/api/jsonws/mp.masterprovince/get-all`
  - [ ] `getMasterCities(provinceId)` → calls `/api/jsonws/mp.mastercity/get-by-province-id`
  - [ ] `getMasterOccupations()` → calls `/api/jsonws/mp.masteroccupation/get-all`
- [ ] Create `packages/api/src/modules/liferay-bridge/liferay-sync.service.ts`:
  - [ ] `syncProducts()` — pulls all from Liferay, upserts into `ProductRegistry` with `source='liferay'`
  - [ ] Normalizes Liferay product data to the platform schema
  - [ ] `writeback(id, data)` — detects `source='liferay'`, routes update to Liferay JSONWS
- [ ] Add sync endpoint: `POST /api/products/sync` (admin-only, triggers a manual sync)
- [ ] Add startup hook — auto-sync from Liferay on API startup (non-blocking)

### 2.2 Products API Module
- [ ] Create `packages/api/src/modules/products/product.schema.ts` (Zod schemas):
  - `CreateProductDto` (name, code, productType, isB2C, isB2B, isB2B2C)
  - `UpdateProductDto` (all fields optional)
  - `PublishProductDto` (no body, changes status to active)
- [ ] Create `packages/api/src/modules/products/product.service.ts`:
  - [ ] `findAll(filters)` — returns merged list of platform + Liferay products
  - [ ] `findById(id)` — returns single product with config, plans, benefits
  - [ ] `create(dto)` — creates new platform product (source: 'platform', status: 'draft')
  - [ ] `update(id, dto)` — updates platform OR routes to Liferay writeback
  - [ ] `publish(id)` — changes status draft → active
  - [ ] `archive(id)` — changes status active → inactive
  - [ ] `delete(id)` — deletes draft platform products only
- [ ] Create `packages/api/src/modules/products/product.routes.ts`:
  - [ ] `GET /api/products` — list (supports ?source=platform|liferay|all, ?status=)
  - [ ] `GET /api/products/:id` — get single with full details
  - [ ] `POST /api/products` — create (product-admin role required)
  - [ ] `PUT /api/products/:id` — update (product-admin role required)
  - [ ] `POST /api/products/:id/publish` — publish (product-admin role required)
  - [ ] `POST /api/products/:id/archive` — archive
  - [ ] `DELETE /api/products/:id` — delete draft only
  - [ ] `POST /api/products/sync` — trigger Liferay sync

### 2.3 Plans & Benefits API Module
- [ ] Create plans service with CRUD operations:
  - `findByProductId(productId)`
  - `create(productId, dto)`
  - `update(planId, dto)`
  - `delete(planId)`
  - `reorder(productId, orderedIds)` — updates sortOrder
- [ ] Create plan routes under `/api/products/:productId/plans`
- [ ] Create benefits service with CRUD operations under each plan
- [ ] Create benefit routes under `/api/products/:productId/plans/:planId/benefits`

### 2.4 Product Config API Module
- [ ] Create config service:
  - `findByProductId(productId)`
  - `upsert(productId, dto)` — creates or updates config
- [ ] Create config routes:
  - `GET /api/products/:productId/config`
  - `PUT /api/products/:productId/config` — full config update (admin config fields)
  - `GET /api/products/:productId/form-schema` — get FormSchema JSON
  - `PUT /api/products/:productId/form-schema` — update FormSchema JSON
  - `GET /api/products/:productId/rate-table` — get rate table JSON
  - `PUT /api/products/:productId/rate-table` — update rate table JSON

---

## Phase 3: Product Wizard UI
**Target Duration:** 2 Weeks
**Status:** ✅ Complete

### 3.1 App Shell & Auth
- [ ] Create `AuthProvider` context reading JWT from localStorage
- [ ] Create `useAuth()` hook returning `{ user, isAuthenticated, login, logout }`
- [ ] Create `LoginPage.tsx` — shows "Login with OneAccount" button → redirects to `/auth/login` on API
- [ ] Create `AuthCallbackPage.tsx` — handles redirect from API after successful auth
- [ ] Create `ProtectedRoute` HOC — redirects to login if not authenticated
- [ ] Create main layout: sidebar navigation + header with user avatar + logout

### 3.2 Sidebar Navigation
- [ ] Create `AppSidebar.tsx` with links:
  - Dashboard (`/`)
  - Products (`/products`)
  - Add New Product (`/products/new`)
- [ ] Use AXA color tokens: sidebar background `bg-axa-blue`, text `text-white`
- [ ] Highlight active route
- [ ] Collapse/expand toggle

### 3.3 Dashboard Page (`/`)
- [ ] Fetch product stats from `GET /api/products`
- [ ] Display stat cards:
  - Total Active Products
  - Drafts in Progress
  - Liferay Products (synced)
  - Last Sync Time
- [ ] Recent products table (last 5 created/modified)
- [ ] "Add New Product" CTA button

### 3.4 Product List Page (`/products`)
- [ ] Fetch from `GET /api/products?source=all`
- [ ] Table columns: Icon, Name, Code, Type, Source Badge, Status Badge, Last Updated, Actions
- [ ] Source badge: "Platform" (blue `bg-axa-blue`) vs "Liferay" (grey `bg-axa-muted`)
- [ ] Status badge: "Active" (green), "Draft" (yellow), "Inactive" (grey)
- [ ] Search input (client-side filter by name or code)
- [ ] Filter dropdown: All / Platform / Liferay | All / Active / Draft / Inactive
- [ ] Row actions: Edit, Publish, Archive
- [ ] "Add New Product" button → navigates to `/products/new`

### 3.5 Product Creation Wizard (`/products/new`)
Use `MultiStepWizard` shell with progress bar.

**Zustand wizard store (`useProductWizardStore`):**
```ts
{
  currentStep: number,
  identity: IdentityFormData,
  plans: PlanFormData[],
  rateTable: RateTableData,
  formSchema: FormSchema,
  adminConfig: AdminConfigData,
  setStep: (step: number) => void,
  setIdentity: (data) => void,
  setPlans: (data) => void,
  // etc.
}
```

- [ ] **Step 1 — Identity** (`Step1Identity.tsx`):
  - [ ] Product Name input (required)
  - [ ] Product Code input (auto-generated from name, editable, uppercase slug)
  - [ ] OJK Name input
  - [ ] Product Type dropdown (Motor, Property, Health, Travel, Life, Personal Accident, Pet, Other)
  - [ ] Icon upload (shows preview after upload)
  - [ ] Distribution toggles: B2C, B2B, B2B2C (Shadcn `Switch` component)
  - [ ] Validate on Next → `POST /api/products` (creates draft), store returned `productId`

- [ ] **Step 2 — Plans & Benefits** (`Step2Plans.tsx`):
  - [ ] Add Plan button → adds new plan row with: Name, Tier (Basic/Silver/Gold/Platinum), Description
  - [ ] Drag handle for reordering plans (use `@dnd-kit/sortable`)
  - [ ] Delete plan button (with confirmation if plan has benefits)
  - [ ] Expand/collapse each plan to show its benefits
  - [ ] Inside each plan: add benefit rows (Name, Value, Unit, Highlight toggle)
  - [ ] Drag handle for reordering benefits within a plan
  - [ ] Save on Next → `PUT /api/products/:id/plans` (batch upsert)

- [ ] **Step 3 — Rate Table** (`Step3Rates.tsx`):
  - [ ] Add Variable section: variable name input + add value/band (e.g. Building Type: Permanent, Semi-Permanent, Non-Permanent)
  - [ ] "Generate Matrix" button → auto-creates a grid table from all variable combinations
  - [ ] Rate matrix table: rows = variable combinations, column = Rate Multiplier (decimal input)
  - [ ] Import CSV button (parses CSV and fills in the matrix)
  - [ ] Export CSV button (downloads current matrix)
  - [ ] Save on Next → `PUT /api/products/:id/rate-table`

- [ ] **Step 4 — Form Schema Builder** (`Step4FormBuilder.tsx`):
  - [ ] Left Panel: field type palette
    - Draggable chips: Text, Number, Date, Select, Radio, Checkbox, File Upload, Address Cascade, Phone, Textarea
  - [ ] Center Panel: form canvas
    - Step tabs (Step 1, Step 2, etc.) with Add/Remove Step buttons
    - Drop zone for each step
    - Dropped fields shown as cards with label, type badge, required indicator
    - Drag handle to reorder fields within a step
    - Click field to open field settings
  - [ ] Right Panel: field settings (shown when a field is selected)
    - Label input
    - Placeholder input
    - Required toggle
    - For `Select` type: choose source (Static List / Liferay Provinces / Liferay Cities / Liferay Occupations / Plan List)
    - For `Static List`: add/remove option values
    - Conditional Display: add rule (Field X equals Value Y)
  - [ ] Live preview toggle: shows a non-interactive mockup of the form
  - [ ] Save on Next → `PUT /api/products/:id/form-schema`

- [ ] **Step 5 — Admin Config** (`Step5AdminConfig.tsx`):
  - [ ] Stamp Duty IDR (number input with IDR currency formatting)
  - [ ] Stamp Duty USD (number input)
  - [ ] Policy Cost IDR (number input)
  - [ ] Policy Cost USD (number input)
  - [ ] Commission % (number input, 0–100)
  - [ ] Grace Period days (number input)
  - [ ] PEP Screening toggle (`Switch`)
  - [ ] Policy Wording PDF upload (shows filename after upload)
  - [ ] OJK Product Code (optional, separate from internal code)
  - [ ] Save on Next → `PUT /api/products/:id/config`

- [ ] **Step 6 — Review & Publish** (`Step6Preview.tsx`):
  - [ ] Full summary card for each section (collapsible)
  - [ ] Raw JSON view tab for FormSchema (for developer inspection)
  - [ ] "Back to Edit" links on each section
  - [ ] Two action buttons:
    - "Save as Draft" → no status change, redirect to product list
    - "Publish Product" → `POST /api/products/:id/publish`, redirect to product list with success toast

### 3.6 Product Edit Page (`/products/:id`)
- [ ] Fetch full product: `GET /api/products/:id`
- [ ] For `source: 'platform'` products: re-uses same wizard steps as creation (pre-populated)
- [ ] For `source: 'liferay'` products:
  - [ ] Shows all config as read-only by default
  - [ ] Editable fields (Name, OJK Name, Commission, Stamp Duty, Policy Cost, B2C/B2B toggles, Icon, PDF)
  - [ ] Orange banner: "This is a Liferay-managed product. Schema changes require a developer."
  - [ ] Save → `PUT /api/products/:id` → routes to Liferay writeback
- [ ] Show version history (last 5 config versions with timestamps)

---

## Phase 4: Deployment & Testing
**Target Duration:** 1 Week

### 4.1 OpenShift Manifests
- [x] Create `openshift/deployment-api.yaml` (2 replicas, resource limits 256Mi/500m)
- [x] Create `openshift/deployment-admin.yaml` (1 replica, Nginx serving static build)
- [x] Create `openshift/service.yaml` (ClusterIP services for each)
- [x] Create `openshift/route.yaml` (external routes with TLS termination)
- [x] Create `openshift/configmap.yaml` (non-secret env vars)
- [x] Create `openshift/secret.yaml` template (DATABASE_URL, OIDC_CLIENT_SECRET, JWT_SECRET)

### 4.2 Security
- [x] Ensure all product write routes require `product-admin` role
- [x] Set up rate limiting on auth routes (max 10 req/min per IP)
- [x] Set CORS to allow only the admin portal domain
- [x] Scan Docker images with Trivy before deployment
- [x] Validate all user inputs with Zod (no raw user data reaches DB)

### 4.3 End-to-End Test — Property Insurance
- [ ] Product team admin logs in via OneAccount
- [ ] Creates Property Insurance product using wizard
- [ ] Configures 3 plans (Basic, Standard, Comprehensive)
- [ ] Fills in rate table (building type × occupancy zone)
- [ ] Defines 5-step purchase form schema
- [ ] Publishes product
- [ ] Confirms product appears in product list as Active
- [ ] Confirms Liferay can call `GET /api/products/PROPERTY_INSURANCE` and receives FormSchema

### 4.4 Handover
- [ ] Record a short Loom walkthrough video of the product wizard for the product team
- [x] Write a user guide: `docs/user-guide.md`
- [ ] Deploy to production OpenShift
- [ ] Register OneAccount redirect URIs for production domain

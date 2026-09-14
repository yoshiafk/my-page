# Agent Tasks — MyPage Insurance Product Wizard

This document contains discrete, actionable tasks designed for AI coding agents or developers. Each task is self-contained, specifies its inputs, expected outputs, and relevant file paths.

**Scope reminder:** This project builds the Product Wizard only. No customer portal. No purchase flows. Liferay handles those unchanged.

---

## Agent Task 1: Initialize npm Workspace Monorepo

**Goal:** Set up the project root with npm workspaces configuration.
**Context:** We use npm workspaces (not pnpm) to manage two packages: `packages/api` (Fastify) and `packages/admin` (React).

**Create the following files:**

### `package.json` (root)
```json
{
  "name": "mypage-insurance-platform",
  "version": "1.0.0",
  "private": true,
  "workspaces": [
    "packages/*"
  ],
  "scripts": {
    "dev": "npm run dev --workspaces --if-present",
    "build": "npm run build --workspaces --if-present",
    "lint": "npm run lint --workspaces --if-present",
    "test": "npm run test --workspaces --if-present"
  },
  "devDependencies": {
    "typescript": "^5.4.0",
    "eslint": "^8.57.0",
    "prettier": "^3.2.0",
    "@typescript-eslint/parser": "^7.0.0",
    "@typescript-eslint/eslint-plugin": "^7.0.0"
  }
}
```

### `tsconfig.base.json`
```json
{
  "compilerOptions": {
    "target": "ES2022",
    "module": "NodeNext",
    "moduleResolution": "NodeNext",
    "strict": true,
    "esModuleInterop": true,
    "skipLibCheck": true,
    "forceConsistentCasingInFileNames": true,
    "resolveJsonModule": true,
    "declaration": true,
    "declarationMap": true,
    "sourceMap": true
  }
}
```

### `.prettierrc`
```json
{
  "semi": false,
  "singleQuote": true,
  "trailingComma": "all",
  "printWidth": 100,
  "tabWidth": 2
}
```

### `.gitignore`
```
node_modules/
dist/
build/
.env
*.env.local
packages/api/prisma/dev.db
packages/api/prisma/dev.db-journal
.DS_Store
```

**Expected Output:** `npm install` runs from root without errors.

---

## Agent Task 2: Scaffold Fastify API (`packages/api`)

**Goal:** Create a working Node.js + TypeScript Fastify API with Prisma ORM connected to PostgreSQL.

**Create the following files:**

### `packages/api/package.json`
```json
{
  "name": "@insurance/api",
  "version": "1.0.0",
  "type": "module",
  "scripts": {
    "dev": "tsx watch src/main.ts",
    "build": "tsc --project tsconfig.json",
    "start": "node dist/main.js",
    "db:migrate": "prisma migrate dev",
    "db:generate": "prisma generate",
    "db:seed": "tsx prisma/seed.ts",
    "db:studio": "prisma studio"
  },
  "dependencies": {
    "fastify": "^4.27.0",
    "@fastify/cors": "^9.0.0",
    "@fastify/helmet": "^11.1.1",
    "@fastify/jwt": "^8.0.1",
    "@fastify/env": "^4.3.0",
    "@fastify/multipart": "^8.3.0",
    "@prisma/client": "^5.14.0",
    "openid-client": "^5.6.5",
    "zod": "^3.23.8",
    "axios": "^1.7.2",
    "pino-pretty": "^11.1.0"
  },
  "devDependencies": {
    "prisma": "^5.14.0",
    "typescript": "^5.4.0",
    "tsx": "^4.15.7",
    "@types/node": "^20.14.0"
  }
}
```

### `packages/api/src/main.ts`
```typescript
import Fastify from 'fastify'
import cors from '@fastify/cors'
import helmet from '@fastify/helmet'
import jwt from '@fastify/jwt'
import { productRoutes } from './modules/products/product.routes.js'
import { authRoutes } from './modules/auth/auth.routes.js'

const app = Fastify({ logger: { transport: { target: 'pino-pretty' } } })

// Plugins
await app.register(cors, {
  origin: process.env.ADMIN_ORIGIN || 'http://localhost:5173',
  credentials: true,
})
await app.register(helmet)
await app.register(jwt, { secret: process.env.JWT_SECRET || 'dev-secret' })

// Routes
await app.register(authRoutes, { prefix: '/auth' })
await app.register(productRoutes, { prefix: '/api/products' })

// Health
app.get('/health', async () => ({ status: 'ok', timestamp: new Date().toISOString() }))

// Start
const port = Number(process.env.API_PORT) || 3001
await app.listen({ port, host: '0.0.0.0' })
console.log(`API running on http://localhost:${port}`)
```

### `packages/api/prisma/schema.prisma`
```prisma
generator client {
  provider = "prisma-client-js"
}

datasource db {
  provider = "postgresql"
  url      = env("DATABASE_URL")
}

model ProductRegistry {
  id          String   @id @default(uuid())
  code        String   @unique
  name        String
  source      String   @default("platform")
  liferayId   Int?
  status      String   @default("draft")
  productType String?
  isB2C       Boolean  @default(true)
  isB2B       Boolean  @default(false)
  isB2B2C     Boolean  @default(false)
  iconUrl     String?
  createdAt   DateTime @default(now())
  updatedAt   DateTime @updatedAt

  config   ProductConfig?
  plans    ProductPlan[]

  @@map("product_registry")
}

model ProductConfig {
  id               String          @id @default(uuid())
  productId        String          @unique
  product          ProductRegistry @relation(fields: [productId], references: [id], onDelete: Cascade)
  version          Int             @default(1)
  ojkName          String?
  stampDutyIDR     Float           @default(0)
  stampDutyUSD     Float           @default(0)
  policyCostIDR    Float           @default(0)
  policyCostUSD    Float           @default(0)
  commission       Float           @default(0)
  gracePeriod      Int             @default(30)
  pepEnabled       Boolean         @default(false)
  policyWordingUrl String?
  formSchema       Json?
  rateTable        Json?
  updatedAt        DateTime        @updatedAt

  @@map("product_config")
}

model ProductPlan {
  id          String          @id @default(uuid())
  productId   String
  product     ProductRegistry @relation(fields: [productId], references: [id], onDelete: Cascade)
  name        String
  tier        String?
  description String?
  sortOrder   Int             @default(0)
  benefits    ProductBenefit[]

  @@map("product_plan")
}

model ProductBenefit {
  id        String      @id @default(uuid())
  planId    String
  plan      ProductPlan @relation(fields: [planId], references: [id], onDelete: Cascade)
  name      String
  value     String?
  unit      String?
  highlight Boolean     @default(false)
  sortOrder Int         @default(0)

  @@map("product_benefit")
}
```

**Expected Output:** `npm run dev` starts the API on port 3001. `GET /health` returns 200.

---

## Agent Task 3: Scaffold React Admin App (`packages/admin`)

**Goal:** Create a working React 18 app with Vite, Tailwind CSS, Shadcn UI, and routing.

**Instructions:**
1. Inside `packages/admin`, initialize with `npm create vite@latest . -- --template react-ts`
2. Install Tailwind CSS and configure
3. Initialize Shadcn UI
4. Install routing, state, and form libraries

**Key Configuration Files:**

### `packages/admin/tailwind.config.js`
```js
/** @type {import('tailwindcss').Config} */
export default {
  darkMode: ['class'],
  content: ['./index.html', './src/**/*.{ts,tsx}'],
  theme: {
    extend: {
      colors: {
        'axa-blue': '#00008F',
        'axa-dark': '#000067',
        'axa-light': '#E6E6F5',
        'axa-accent': '#4976BA',
        'axa-red': '#FF1721',
        'axa-success': '#1CC54E',
        'axa-success-light': '#D7F4E0',
        'axa-error': '#C91432',
        'axa-error-light': '#FCE4E7',
        'axa-surface': '#F5F5F5',
        'axa-border': '#CCCCCC',
        'axa-text': '#333333',
        'axa-muted': '#5F5F5F',
      },
      borderRadius: {
        pill: '50px',
      },
      boxShadow: {
        card: '0 2px 12px rgba(0,0,0,0.08)',
        hover: '0 6px 24px rgba(0,0,143,0.15)',
      },
      fontFamily: {
        sans: ['Inter', 'system-ui', 'sans-serif'],
      },
    },
  },
  plugins: [require('tailwindcss-animate')],
}
```

### `packages/admin/src/App.tsx`
```tsx
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { AppLayout } from './components/AppLayout'
import { DashboardPage } from './pages/Dashboard'
import { ProductListPage } from './pages/ProductList'
import { ProductCreatePage } from './pages/ProductCreate'
import { ProductEditPage } from './pages/ProductEdit'
import { LoginPage } from './pages/Login'
import { AuthCallbackPage } from './pages/AuthCallback'
import { ProtectedRoute } from './components/ProtectedRoute'

const queryClient = new QueryClient({
  defaultOptions: { queries: { staleTime: 60_000, retry: 1 } },
})

export default function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/auth/callback" element={<AuthCallbackPage />} />
          <Route element={<ProtectedRoute><AppLayout /></ProtectedRoute>}>
            <Route path="/" element={<DashboardPage />} />
            <Route path="/products" element={<ProductListPage />} />
            <Route path="/products/new" element={<ProductCreatePage />} />
            <Route path="/products/:id" element={<ProductEditPage />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </QueryClientProvider>
  )
}
```

**Expected Output:** `npm run dev` in `packages/admin` starts Vite dev server on port 5173 showing AXA-styled login page.

---

## Agent Task 4: Implement OneAccount OIDC Authentication

**Goal:** Implement the full OIDC auth flow using OneAccount as the identity provider.
**Files to create:** `packages/api/src/modules/auth/`

### `auth.service.ts`
```typescript
import { Issuer } from 'openid-client'

let client: Awaited<ReturnType<typeof buildClient>> | null = null

async function buildClient() {
  const issuer = await Issuer.discover(process.env.OIDC_ISSUER_URL!)
  return new issuer.Client({
    client_id: process.env.OIDC_CLIENT_ID!,
    client_secret: process.env.OIDC_CLIENT_SECRET!,
    redirect_uris: [process.env.OIDC_REDIRECT_URI!],
    response_types: ['code'],
  })
}

export async function getOIDCClient() {
  if (!client) client = await buildClient()
  return client
}

export async function getAuthorizationUrl(state: string) {
  const oidcClient = await getOIDCClient()
  return oidcClient.authorizationUrl({
    scope: 'openid profile email',
    state,
  })
}

export async function handleCallback(url: string, state: string) {
  const oidcClient = await getOIDCClient()
  const params = oidcClient.callbackParams(url)
  const tokenSet = await oidcClient.callback(process.env.OIDC_REDIRECT_URI!, params, { state })
  const userinfo = await oidcClient.userinfo(tokenSet.access_token!)
  return userinfo
}
```

### `auth.routes.ts`
```typescript
import type { FastifyInstance } from 'fastify'
import { getAuthorizationUrl, handleCallback } from './auth.service.js'
import { randomBytes } from 'crypto'

export async function authRoutes(app: FastifyInstance) {
  // Redirect to OneAccount login
  app.get('/login', async (req, reply) => {
    const state = randomBytes(16).toString('hex')
    const url = await getAuthorizationUrl(state)
    reply.setCookie('oidc_state', state, { httpOnly: true, path: '/', sameSite: 'lax' })
    return reply.redirect(url)
  })

  // OneAccount redirects here after login
  app.get('/callback', async (req, reply) => {
    const user = await handleCallback(req.url, (req.cookies as any).oidc_state)
    const token = app.jwt.sign({
      sub: user.sub,
      email: user.email,
      name: user.name,
      role: 'product-admin', // map from OneAccount claims
    }, { expiresIn: '8h' })
    reply.setCookie('token', token, { httpOnly: true, path: '/' })
    return reply.redirect(process.env.ADMIN_ORIGIN + '/auth/callback?success=true')
  })

  // Get current user
  app.get('/me', { onRequest: [app.authenticate] }, async (req) => {
    return req.user
  })

  // Logout
  app.post('/logout', async (req, reply) => {
    reply.clearCookie('token')
    return { success: true }
  })
}
```

**Expected Output:** Visiting `http://localhost:3001/auth/login` redirects to OneAccount. After login, user is redirected back and a JWT cookie is set.

---

## Agent Task 5: Build Product Wizard Step 4 — Form Schema Builder

**Goal:** Build the most complex step of the wizard: the drag-and-drop purchase form builder.
**Context:** This component defines the structure of the customer purchase form in Liferay. It produces a JSON `FormSchema` object.
**File:** `packages/admin/src/features/product-wizard/Step4FormBuilder.tsx`

**Key dependencies:** `@dnd-kit/core`, `@dnd-kit/sortable`, `react-hook-form`, `zod`

**The component must support:**
- Left palette: draggable field type chips (Text, Number, Date, Select, Radio, Checkbox, File, Address, Phone)
- Center canvas: droppable area organized by form steps (tabs)
- Right panel: field configuration (label, placeholder, required, source for selects, conditional display)
- Add/remove form steps
- Drag to reorder fields within a step
- Clicking a dropped field opens its settings in the right panel
- Produces a JSON output matching this schema:
  ```typescript
  type FormSchema = {
    steps: Array<{
      id: string
      title: string
      fields: Array<{
        id: string
        name: string
        label: string
        type: 'text' | 'number' | 'date' | 'select' | 'radio' | 'checkbox' | 'file' | 'address' | 'phone' | 'textarea'
        placeholder?: string
        required: boolean
        source?: 'liferay:provinces' | 'liferay:cities' | 'liferay:occupations' | 'config:plans' | 'static'
        staticOptions?: Array<{ label: string; value: string }>
        conditionalDisplay?: { field: string; operator: 'equals' | 'not_equals'; value: string }
      }>
    }>
  }
  ```

**Expected Output:** A working drag-and-drop form builder that saves its JSON output to the wizard store and to `PUT /api/products/:id/form-schema`.

---

## Agent Task 6: Implement Liferay Bridge (Read + Write-back)

**Goal:** Implement the adapter in the API that reads all existing product configurations from Liferay and writes changes back for Liferay-managed products.
**File:** `packages/api/src/modules/liferay-bridge/liferay.service.ts`

**Instructions:**
1. Create an Axios instance configured with `LIFERAY_BASE_URL` and Basic Auth (`LIFERAY_API_USER:LIFERAY_API_PASSWORD`)
2. Implement `syncProducts()`:
   - Calls `GET {LIFERAY_BASE_URL}/api/jsonws/mp.productconfiguration/get-all-product-configurations`
   - Maps each result to `ProductRegistry` schema with `source: 'liferay'`
   - Upserts into platform DB using Prisma `upsert` on `liferayId`
3. Implement `updateLiferayProduct(liferayId, data)`:
   - Calls `POST {LIFERAY_BASE_URL}/api/jsonws/mp.productconfiguration/update-product-configuration`
   - Only updates the fields that are allowed to be edited via the wizard (name, OJK name, commission, stamp duty, etc.)
4. Register a startup hook in `main.ts` that calls `syncProducts()` asynchronously on boot (non-blocking — catch errors silently)
5. Create the sync endpoint: `POST /api/products/sync` (requires `product-admin` role)

**Expected Output:** On API startup, all Liferay products appear in `GET /api/products` with `source: 'liferay'`. When an admin edits a Liferay product in the wizard, changes are written back to Liferay within 2 seconds.

---

## Agent Task 7: Build Rate Table Matrix Editor

**Goal:** Build the rate table editor component (Step 3 of the wizard).
**File:** `packages/admin/src/features/product-wizard/Step3Rates.tsx`

**Behavior:**
1. User adds rating variables (e.g. "Building Type") and defines their options (e.g. "Permanent", "Semi-Permanent", "Non-Permanent")
2. User clicks "Generate Matrix" — component computes all combinations of variable values as table rows
3. Each row has an input cell for the rate multiplier (decimal, 0.000–99.999)
4. "Import CSV" button opens a file picker, parses the CSV, and fills the matrix
5. "Export CSV" downloads the current matrix as a `.csv` file
6. Saves as JSON object:
   ```json
   {
     "variables": [
       { "name": "Building Type", "values": ["Permanent", "Semi-Permanent", "Non-Permanent"] },
       { "name": "Occupancy Zone", "values": ["Zone 1", "Zone 2", "Zone 3"] }
     ],
     "matrix": {
       "Permanent|Zone 1": 0.002,
       "Permanent|Zone 2": 0.003,
       "Semi-Permanent|Zone 1": 0.004
     }
   }
   ```

**Expected Output:** A functional rate table editor that generates, edits, and exports rate matrices.

---

## Agent Task 8: Docker + OpenShift Deployment Setup

**Goal:** Create all deployment configuration files for both Docker Compose and OpenShift.

### `docker-compose.yml`
```yaml
version: '3.8'

services:
  postgres:
    image: postgres:15-alpine
    restart: unless-stopped
    environment:
      POSTGRES_DB: insurance_platform
      POSTGRES_USER: ${DB_USER:-admin}
      POSTGRES_PASSWORD: ${DB_PASSWORD:-password}
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U admin"]
      interval: 10s
      timeout: 5s
      retries: 5

  api:
    build:
      context: ./packages/api
      dockerfile: Dockerfile
    restart: unless-stopped
    ports:
      - "3001:3001"
    env_file: .env
    depends_on:
      postgres:
        condition: service_healthy
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:3001/health"]
      interval: 30s
      timeout: 10s
      retries: 3

  admin:
    build:
      context: ./packages/admin
      dockerfile: Dockerfile
    restart: unless-stopped
    ports:
      - "3000:80"
    depends_on:
      - api

volumes:
  pgdata:
```

### `packages/api/Dockerfile`
```dockerfile
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
COPY prisma ./prisma/
RUN npm ci
COPY . .
RUN npm run db:generate
RUN npm run build

FROM node:20-alpine AS runner
WORKDIR /app
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
COPY --from=builder /app/dist ./dist
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/prisma ./prisma
USER appuser
EXPOSE 3001
CMD ["node", "dist/main.js"]
```

### `packages/admin/Dockerfile`
```dockerfile
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine AS runner
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

### `packages/admin/nginx.conf`
```nginx
server {
  listen 80;
  root /usr/share/nginx/html;
  index index.html;

  location / {
    try_files $uri $uri/ /index.html;
  }

  location /api {
    proxy_pass http://api:3001;
    proxy_set_header Host $host;
    proxy_set_header X-Real-IP $remote_addr;
  }
}
```

**Expected Output:** `docker-compose up` successfully starts all 3 services. Admin UI loads at `http://localhost:3000`.

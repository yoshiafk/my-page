# MyPage Insurance Product Wizard

An internal admin tool for the AXA product team to configure, manage, and publish insurance product configurations — without requiring developer intervention for every new product.

## Scope (Current)

> **This project covers the Product Wizard only.**
> Customer purchase flows and agent portals continue to operate on the existing `my-page-liferay` system.

**Who uses this:** Internal product/business team
**What it does:**
- Register new insurance products (plans, rates, benefits, admin config)
- View and edit configurations of existing Liferay products
- Publish product configs that Liferay reads at runtime

## Architecture

```
mypage-insurance-platform/
├── packages/
│   ├── api/          ← Node.js + TypeScript (Fastify) — product config API
│   └── admin/        ← React 18 + Vite — Product Wizard UI
└── package.json      ← npm workspaces root
```

## Tech Stack

| Layer | Technology |
|---|---|
| Backend API | Node.js 20 LTS + TypeScript + Fastify |
| Database | PostgreSQL 15 + Prisma ORM |
| Frontend | React 18 + Vite + TypeScript |
| Styling | Tailwind CSS + Shadcn UI (AXA Design System) |
| Forms | React Hook Form + Zod |
| State | Zustand + TanStack Query |
| Auth | OneAccount (Internal AXA OIDC) |
| Package Manager | npm workspaces |
| Containers | Docker / OpenShift |

## Documentation

See the [`docs/`](./docs) folder:

- [Implementation Plan](./docs/implementation-plan.md)
- [Task Plan](./docs/task-plan.md)
- [Agent Tasks](./docs/agent-tasks.md)
- [API Contracts](./docs/api-contracts.md)
- [Database Schema](./docs/database-schema.md)

## Getting Started

```bash
# Install all packages
npm install

# Start API + Admin in development
npm run dev

# Build all packages
npm run build
```

# API Contracts — MyPage Insurance Product Wizard

All endpoints use `Content-Type: application/json`. All protected endpoints require `Authorization: Bearer <JWT>` header.
Base URL: `http://localhost:3001` (dev) / `https://api.insurance-platform.axa.co.id` (prod)

---

## Authentication Endpoints

### `GET /auth/login`
Redirects to OneAccount OIDC login page.
**Auth:** Public
**Response:** 302 redirect to OneAccount

### `GET /auth/callback`
Handles OneAccount redirect. Issues platform JWT.
**Auth:** Public (called by OneAccount)
**Response:** 302 redirect to admin portal with JWT cookie set

### `GET /auth/me`
Returns current authenticated user's profile.
**Auth:** Required
**Response:**
```json
{
  "sub": "oneaccount-user-id",
  "email": "user@axa.co.id",
  "name": "John Doe",
  "role": "product-admin"
}
```

### `POST /auth/logout`
Clears the JWT cookie.
**Auth:** Required
**Response:** `{ "success": true }`

---

## Product Endpoints

### `GET /api/products`
Returns all products (platform + Liferay synced).
**Auth:** Required
**Query Params:**
- `source` — `platform` | `liferay` | `all` (default: `all`)
- `status` — `draft` | `active` | `inactive` | `all` (default: `all`)
- `search` — string, filters by name or code

**Response:**
```json
{
  "data": [
    {
      "id": "uuid",
      "code": "PROPERTY_INSURANCE",
      "name": "Property Insurance",
      "source": "platform",
      "status": "active",
      "productType": "Property",
      "isB2C": true,
      "isB2B": false,
      "isB2B2C": false,
      "iconUrl": "https://...",
      "createdAt": "2026-09-09T00:00:00Z",
      "updatedAt": "2026-09-09T00:00:00Z"
    }
  ],
  "total": 7
}
```

### `GET /api/products/:id`
Returns a single product with full details (config, plans, benefits, form schema, rate table).
**Auth:** Required
**Response:**
```json
{
  "id": "uuid",
  "code": "PROPERTY_INSURANCE",
  "name": "Property Insurance",
  "source": "platform",
  "status": "draft",
  "config": {
    "ojkName": "Asuransi Properti All Risk",
    "stampDutyIDR": 10000,
    "stampDutyUSD": 0,
    "policyCostIDR": 50000,
    "commission": 15,
    "gracePeriod": 30,
    "pepEnabled": false,
    "policyWordingUrl": "https://...",
    "formSchema": { ... },
    "rateTable": { ... },
    "version": 1
  },
  "plans": [
    {
      "id": "uuid",
      "name": "Basic",
      "tier": "basic",
      "description": "Essential coverage",
      "sortOrder": 0,
      "benefits": [
        { "id": "uuid", "name": "Fire Coverage", "value": "100%", "unit": "of SI", "highlight": true, "sortOrder": 0 }
      ]
    }
  ]
}
```

### `POST /api/products`
Creates a new product (status: draft).
**Auth:** Required (role: `product-admin`)
**Body:**
```json
{
  "name": "Property Insurance",
  "code": "PROPERTY_INSURANCE",
  "productType": "Property",
  "isB2C": true,
  "isB2B": false,
  "isB2B2C": false
}
```
**Response:** `201` with created product object.

### `PUT /api/products/:id`
Updates a product. For `source: 'liferay'` products, routes editable fields to Liferay JSONWS.
**Auth:** Required (role: `product-admin`)
**Body:** Any subset of product fields.
**Response:** Updated product object.

### `POST /api/products/:id/publish`
Changes product status from `draft` to `active`.
**Auth:** Required (role: `product-admin`)
**Body:** Empty `{}`
**Response:** `{ "success": true, "status": "active" }`

### `POST /api/products/:id/archive`
Changes product status to `inactive`.
**Auth:** Required (role: `product-admin`)
**Response:** `{ "success": true, "status": "inactive" }`

### `DELETE /api/products/:id`
Deletes a draft platform product. Liferay products cannot be deleted here.
**Auth:** Required (role: `product-admin`)
**Response:** `204 No Content`

### `POST /api/products/sync`
Triggers a manual sync from Liferay to update the product registry.
**Auth:** Required (role: `product-admin`)
**Response:** `{ "synced": 6, "created": 0, "updated": 1 }`

---

## Plans & Benefits Endpoints

### `GET /api/products/:productId/plans`
Returns all plans with nested benefits for a product.
**Auth:** Required

### `POST /api/products/:productId/plans`
Creates a new plan.
**Body:** `{ "name": "Gold", "tier": "gold", "description": "..." }`
**Response:** Created plan object.

### `PUT /api/products/:productId/plans/:planId`
Updates a plan.
**Body:** Any plan fields.

### `DELETE /api/products/:productId/plans/:planId`
Deletes a plan and all its benefits.

### `POST /api/products/:productId/plans/:planId/benefits`
Adds a benefit to a plan.
**Body:** `{ "name": "Fire Coverage", "value": "100%", "unit": "of SI", "highlight": true }`

### `PUT /api/products/:productId/plans/:planId/benefits/reorder`
Reorders benefits within a plan.
**Body:** `{ "orderedIds": ["uuid1", "uuid2", "uuid3"] }`

---

## Config Endpoints

### `GET /api/products/:productId/config`
Returns the full product configuration.
**Auth:** Required

### `PUT /api/products/:productId/config`
Updates admin configuration fields.
**Body:**
```json
{
  "ojkName": "Asuransi Properti All Risk",
  "stampDutyIDR": 10000,
  "stampDutyUSD": 0,
  "policyCostIDR": 50000,
  "policyCostUSD": 0,
  "commission": 15,
  "gracePeriod": 30,
  "pepEnabled": false
}
```

### `GET /api/products/:productId/form-schema`
Returns the FormSchema JSON.
**Auth:** Required
**Note:** This is also the endpoint Liferay will call at runtime to render the customer purchase form.

### `PUT /api/products/:productId/form-schema`
Replaces the full FormSchema JSON.
**Body:** Full FormSchema object (see structure in agent-tasks.md Task 5).

### `GET /api/products/:productId/rate-table`
Returns the rate table JSON.

### `PUT /api/products/:productId/rate-table`
Replaces the full rate table JSON.
**Body:** Rate table object (see structure in agent-tasks.md Task 7).

---

## Error Response Format

All errors follow this structure:
```json
{
  "statusCode": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "details": [
    { "field": "name", "message": "Required" }
  ]
}
```

| Status Code | Meaning |
|---|---|
| 400 | Validation error (bad request body) |
| 401 | Not authenticated (missing or invalid JWT) |
| 403 | Forbidden (authenticated but insufficient role) |
| 404 | Resource not found |
| 409 | Conflict (e.g. product code already exists) |
| 500 | Internal server error |

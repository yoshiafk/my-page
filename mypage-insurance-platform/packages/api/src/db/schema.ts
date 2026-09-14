import { pgTable, uuid, varchar, boolean, integer, doublePrecision, jsonb, timestamp } from 'drizzle-orm/pg-core'
import { relations } from 'drizzle-orm'

// ─── Product Registry ────────────────────────────────────────────────────────
export const productRegistry = pgTable('product_registry', {
  id:          uuid('id').defaultRandom().primaryKey(),
  code:        varchar('code', { length: 100 }).notNull().unique(),
  name:        varchar('name', { length: 255 }).notNull(),
  source:      varchar('source', { length: 50 }).notNull().default('platform'), // 'platform' | 'liferay'
  liferayId:   integer('liferay_id'),
  status:      varchar('status', { length: 50 }).notNull().default('draft'),    // 'draft' | 'active' | 'inactive'
  productType: varchar('product_type', { length: 100 }),
  isB2C:       boolean('is_b2c').notNull().default(true),
  isB2B:       boolean('is_b2b').notNull().default(false),
  isB2B2C:     boolean('is_b2b2c').notNull().default(false),
  iconUrl:     varchar('icon_url', { length: 500 }),
  createdAt:   timestamp('created_at').notNull().defaultNow(),
  updatedAt:   timestamp('updated_at').notNull().defaultNow(),
})

// ─── Product Config ───────────────────────────────────────────────────────────
export const productConfig = pgTable('product_config', {
  id:               uuid('id').defaultRandom().primaryKey(),
  productId:        uuid('product_id').notNull().unique().references(() => productRegistry.id, { onDelete: 'cascade' }),
  version:          integer('version').notNull().default(1),
  ojkName:          varchar('ojk_name', { length: 255 }),
  stampDutyIDR:     doublePrecision('stamp_duty_idr').notNull().default(0),
  stampDutyUSD:     doublePrecision('stamp_duty_usd').notNull().default(0),
  policyCostIDR:    doublePrecision('policy_cost_idr').notNull().default(0),
  policyCostUSD:    doublePrecision('policy_cost_usd').notNull().default(0),
  commission:       doublePrecision('commission').notNull().default(0),
  gracePeriod:      integer('grace_period').notNull().default(30),
  pepEnabled:       boolean('pep_enabled').notNull().default(false),
  policyWordingUrl: varchar('policy_wording_url', { length: 500 }),
  formSchema:       jsonb('form_schema'),
  rateTable:        jsonb('rate_table'),
  updatedAt:        timestamp('updated_at').notNull().defaultNow(),
})

// ─── Product Plan ─────────────────────────────────────────────────────────────
export const productPlan = pgTable('product_plan', {
  id:          uuid('id').defaultRandom().primaryKey(),
  productId:   uuid('product_id').notNull().references(() => productRegistry.id, { onDelete: 'cascade' }),
  name:        varchar('name', { length: 255 }).notNull(),
  tier:        varchar('tier', { length: 50 }),
  description: varchar('description', { length: 1000 }),
  sortOrder:   integer('sort_order').notNull().default(0),
})

// ─── Product Benefit ──────────────────────────────────────────────────────────
export const productBenefit = pgTable('product_benefit', {
  id:        uuid('id').defaultRandom().primaryKey(),
  planId:    uuid('plan_id').notNull().references(() => productPlan.id, { onDelete: 'cascade' }),
  name:      varchar('name', { length: 255 }).notNull(),
  value:     varchar('value', { length: 255 }),
  unit:      varchar('unit', { length: 50 }),
  highlight: boolean('highlight').notNull().default(false),
  sortOrder: integer('sort_order').notNull().default(0),
})

// ─── Relations ────────────────────────────────────────────────────────────────
export const productRegistryRelations = relations(productRegistry, ({ one, many }) => ({
  config: one(productConfig, { fields: [productRegistry.id], references: [productConfig.productId] }),
  plans:  many(productPlan),
}))

export const productConfigRelations = relations(productConfig, ({ one }) => ({
  product: one(productRegistry, { fields: [productConfig.productId], references: [productRegistry.id] }),
}))

export const productPlanRelations = relations(productPlan, ({ one, many }) => ({
  product:  one(productRegistry, { fields: [productPlan.productId], references: [productRegistry.id] }),
  benefits: many(productBenefit),
}))

export const productBenefitRelations = relations(productBenefit, ({ one }) => ({
  plan: one(productPlan, { fields: [productBenefit.planId], references: [productPlan.id] }),
}))

// ─── Types (inferred) ────────────────────────────────────────────────────────
export type ProductRegistry = typeof productRegistry.$inferSelect
export type NewProductRegistry = typeof productRegistry.$inferInsert
export type ProductConfig = typeof productConfig.$inferSelect
export type NewProductConfig = typeof productConfig.$inferInsert
export type ProductPlan = typeof productPlan.$inferSelect
export type NewProductPlan = typeof productPlan.$inferInsert
export type ProductBenefit = typeof productBenefit.$inferSelect
export type NewProductBenefit = typeof productBenefit.$inferInsert

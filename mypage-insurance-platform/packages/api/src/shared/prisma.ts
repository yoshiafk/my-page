// Drizzle db instance — replaces the old Prisma singleton
// Exported as both `db` (new) and `prisma` (legacy alias for existing service files)
import 'dotenv/config'
import { drizzle } from 'drizzle-orm/postgres-js'
import postgres from 'postgres'
import * as schema from '../db/schema.js'

if (!process.env.DATABASE_URL) {
  throw new Error('DATABASE_URL environment variable is required')
}

const client = postgres(process.env.DATABASE_URL)
export const db = drizzle(client, { schema })

// Legacy alias — existing service files import { prisma } from './prisma.js'
export const prisma = db

export type DB = typeof db

import 'dotenv/config'
import { db } from './index.js'
import { randomUUID } from 'crypto'

async function seed() {
  console.log('🌱 Seeding database...')
  await db.init()

  // Platform product — Property Insurance (draft)
  const propertyId = randomUUID()
  db.data.products.push({
    id: propertyId,
    code: 'PROPERTY_INSURANCE',
    name: 'Property Insurance',
    source: 'platform',
    status: 'draft',
    productType: 'Property',
    isB2C: true,
    isB2B: true,
    isB2B2C: false,
  })

  db.data.configs.push({
    productId: propertyId,
    ojkName: 'Asuransi Properti All Risk',
    stampDutyIDR: 10000,
    policyCostIDR: 50000,
    commission: 15,
    gracePeriod: 30,
    pepEnabled: false,
  })

  const basicPlanId = randomUUID()
  db.data.plans.push({
    id: basicPlanId,
    productId: propertyId,
    name: 'Basic',
    tier: 'basic',
    description: 'Essential fire and lightning coverage',
    sortOrder: 0,
  })

  db.data.benefits.push(
    { id: randomUUID(), planId: basicPlanId, name: 'Fire & Lightning', value: '100%', unit: 'of SI', highlight: true, sortOrder: 0 },
    { id: randomUUID(), planId: basicPlanId, name: 'Explosion', value: '100%', unit: 'of SI', highlight: false, sortOrder: 1 },
  )

  // Liferay-synced product — Pet Insurance (active)
  const petId = randomUUID()
  db.data.products.push({
    id: petId,
    code: 'PET_INSURANCE',
    name: 'Pet Insurance',
    source: 'liferay',
    liferayId: 1,
    status: 'active',
    productType: 'Pet',
    isB2C: true,
    isB2B: false,
    isB2B2C: false,
  })

  db.data.configs.push({
    productId: petId,
    ojkName: 'Asuransi Hewan Peliharaan',
    stampDutyIDR: 10000,
    policyCostIDR: 30000,
    commission: 10,
    gracePeriod: 30,
    pepEnabled: true,
  })

  await db.save()

  console.log('✅ Seed complete!')
  console.log(`   - Property Insurance (draft, platform) id: ${propertyId}`)
  console.log(`   - Pet Insurance (active, liferay)      id: ${petId}`)
  process.exit(0)
}

seed().catch((err) => {
  console.error('❌ Seed failed:', err)
  process.exit(1)
})

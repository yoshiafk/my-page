
import { db } from '../../db/index.js';
import { randomUUID } from 'crypto';

class ProductService {
  async findAll(filters: { source?: string, status?: string, search?: string }) {
    await db.init();
    let res = db.data.products;
    if (filters.source && filters.source !== 'all') res = res.filter((p: any) => p.source === filters.source);
    if (filters.status && filters.status !== 'all') res = res.filter((p: any) => p.status === filters.status);
    if (filters.search) {
      const s = filters.search.toLowerCase();
      res = res.filter((p: any) => p.name.toLowerCase().includes(s) || p.code.toLowerCase().includes(s));
    }
    return res;
  }

  async findById(id: string) {
    await db.init();
    const product = db.data.products.find((p: any) => p.id === id);
    if (!product) return null;
    const config = db.data.configs.find((c: any) => c.productId === id);
    const plans = db.data.plans.filter((p: any) => p.productId === id).map((pl: any) => ({
      ...pl,
      benefits: db.data.benefits.filter((b: any) => b.planId === pl.id)
    }));
    return { ...product, config, plans };
  }

  async create(dto: any) {
    await db.init();
    const product = { ...dto, id: randomUUID(), status: 'draft', source: 'platform', createdAt: new Date() };
    db.data.products.push(product);
    await db.save();
    return product;
  }

  async update(id: string, dto: any) {
    await db.init();
    const idx = db.data.products.findIndex((p: any) => p.id === id);
    if (idx > -1) Object.assign(db.data.products[idx], { ...dto, updatedAt: new Date() });
    await db.save();
    return db.data.products[idx];
  }

  async publish(id: string) {
    await db.init();
    const idx = db.data.products.findIndex((p: any) => p.id === id);
    if (idx > -1) db.data.products[idx].status = 'active';
    await db.save();
    return db.data.products[idx];
  }

  async archive(id: string) {
    await db.init();
    const idx = db.data.products.findIndex((p: any) => p.id === id);
    if (idx > -1) db.data.products[idx].status = 'inactive';
    await db.save();
    return db.data.products[idx];
  }

  async delete(id: string) {
    await db.init();
    db.data.products = db.data.products.filter((p: any) => p.id !== id);
    await db.save();
  }
}

export const productService = new ProductService();

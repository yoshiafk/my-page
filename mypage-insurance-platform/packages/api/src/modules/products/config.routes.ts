
import { FastifyInstance } from 'fastify';
import { db } from '../../db/index.js';
import { authMiddleware } from '../../shared/middleware/auth.middleware.js';
import { randomUUID } from 'crypto';

export default async function(app: FastifyInstance) {
  app.addHook('preHandler', authMiddleware);

  app.get('/:id/config', async (request, reply) => {
    await db.init();
    const config = db.data.configs.find((c: any) => c.productId === (request.params as any).id);
    return config || {};
  });

  app.put('/:id/config', async (request, reply) => {
    await db.init();
    const id = (request.params as any).id;
    let config = db.data.configs.find((c: any) => c.productId === id);
    if (!config) {
      config = { id: randomUUID(), productId: id, ...request.body as any };
      db.data.configs.push(config);
    } else {
      Object.assign(config, request.body as any);
    }
    await db.save();
    return config;
  });

  app.get('/:id/form-schema', async (request, reply) => {
    await db.init();
    const config = db.data.configs.find((c: any) => c.productId === (request.params as any).id);
    return config?.formSchema || {};
  });

  app.put('/:id/form-schema', async (request, reply) => {
    await db.init();
    const id = (request.params as any).id;
    let config = db.data.configs.find((c: any) => c.productId === id);
    if (!config) {
      config = { id: randomUUID(), productId: id, formSchema: request.body };
      db.data.configs.push(config);
    } else {
      config.formSchema = request.body;
    }
    await db.save();
    return config.formSchema;
  });

  app.get('/:id/rate-table', async (request, reply) => {
    await db.init();
    const config = db.data.configs.find((c: any) => c.productId === (request.params as any).id);
    return config?.rateTable || {};
  });

  app.put('/:id/rate-table', async (request, reply) => {
    await db.init();
    const id = (request.params as any).id;
    let config = db.data.configs.find((c: any) => c.productId === id);
    if (!config) {
      config = { id: randomUUID(), productId: id, rateTable: request.body };
      db.data.configs.push(config);
    } else {
      config.rateTable = request.body;
    }
    await db.save();
    return config.rateTable;
  });
}

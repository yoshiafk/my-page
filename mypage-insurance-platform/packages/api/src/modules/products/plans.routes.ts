
import { FastifyInstance } from 'fastify';
import { db } from '../../db/index.js';
import { authMiddleware } from '../../shared/middleware/auth.middleware.js';
import { randomUUID } from 'crypto';

export default async function(app: FastifyInstance) {
  app.addHook('preHandler', authMiddleware);

  app.get('/:productId/plans', async (request, reply) => {
    await db.init();
    const plans = db.data.plans.filter((p: any) => p.productId === (request.params as any).productId);
    return plans.map((pl: any) => ({
      ...pl,
      benefits: db.data.benefits.filter((b: any) => b.planId === pl.id)
    }));
  });

  app.post('/:productId/plans', async (request, reply) => {
    await db.init();
    const id = (request.params as any).productId;
    const body = request.body as any;
    const plan = { id: randomUUID(), productId: id, ...body };
    db.data.plans.push(plan);
    if (body.benefits) {
      for (const b of body.benefits) {
        db.data.benefits.push({ id: randomUUID(), planId: plan.id, ...b });
      }
    }
    await db.save();
    return plan;
  });

  app.put('/:productId/plans/:planId', async (request, reply) => {
    await db.init();
    const plan = db.data.plans.find((p: any) => p.id === (request.params as any).planId);
    if (plan) Object.assign(plan, request.body as any);
    await db.save();
    return plan;
  });

  app.delete('/:productId/plans/:planId', async (request, reply) => {
    await db.init();
    db.data.plans = db.data.plans.filter((p: any) => p.id !== (request.params as any).planId);
    db.data.benefits = db.data.benefits.filter((b: any) => b.planId !== (request.params as any).planId);
    await db.save();
    return { success: true };
  });
}

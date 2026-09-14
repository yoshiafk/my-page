import { FastifyInstance } from 'fastify';
import { authMiddleware } from '../../shared/middleware/auth.middleware.js';
import { productService } from './product.service.js';
import { CreateProductSchema, UpdateProductSchema } from './product.schema.js';
import { liferaySyncService } from '../liferay-bridge/liferay-sync.service.js';

export default async function(app: FastifyInstance) {
  app.get('/', { preHandler: [authMiddleware] }, async (request, reply) => {
    const query = request.query as any;
    return productService.findAll(query);
  });

  app.get('/:id', { preHandler: [authMiddleware] }, async (request, reply) => {
    const { id } = request.params as any;
    const product = await productService.findById(id);
    if (!product) return reply.status(404).send({ statusCode: 404, message: 'Not found' });
    return product;
  });

  app.post('/', { preHandler: [authMiddleware] }, async (request, reply) => {
    const dto = CreateProductSchema.parse(request.body);
    const product = await productService.create(dto);
    return reply.status(201).send(product);
  });

  app.put('/:id', { preHandler: [authMiddleware] }, async (request, reply) => {
    const { id } = request.params as any;
    const dto = UpdateProductSchema.parse(request.body);
    return productService.update(id, dto);
  });

  app.post('/:id/publish', { preHandler: [authMiddleware] }, async (request, reply) => {
    const { id } = request.params as any;
    await productService.publish(id);
    return { success: true, status: 'active' };
  });

  app.post('/:id/archive', { preHandler: [authMiddleware] }, async (request, reply) => {
    const { id } = request.params as any;
    await productService.archive(id);
    return { success: true, status: 'inactive' };
  });

  app.delete('/:id', { preHandler: [authMiddleware] }, async (request, reply) => {
    const { id } = request.params as any;
    await productService.delete(id);
    return reply.status(204).send();
  });

  app.post('/sync', { preHandler: [authMiddleware] }, async (request, reply) => {
    const result = await liferaySyncService.syncProducts();
    return result;
  });
}

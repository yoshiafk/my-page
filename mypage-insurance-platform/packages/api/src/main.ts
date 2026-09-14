import 'dotenv/config';
import Fastify from 'fastify';
import cors from '@fastify/cors';
import helmet from '@fastify/helmet';
import jwt from '@fastify/jwt';
import cookie from '@fastify/cookie';
import rateLimit from '@fastify/rate-limit';
import { ZodError } from 'zod';

import authRoutes from './modules/auth/auth.routes.js';
import productRoutes from './modules/products/product.routes.js';
import configRoutes from './modules/products/config.routes.js';
import plansRoutes from './modules/products/plans.routes.js';
import { liferaySyncService } from './modules/liferay-bridge/liferay-sync.service.js';

const app = Fastify({ logger: true });

async function buildServer() {
  await app.register(cors, {
    origin: process.env.ADMIN_ORIGIN || 'http://localhost:3000',
    credentials: true,
  });
  
  await app.register(helmet);
  await app.register(cookie);
  await app.register(rateLimit, { global: false });
  await app.register(jwt, {
    secret: process.env.JWT_SECRET || 'supersecret',
    cookie: {
      cookieName: 'token',
      signed: false,
    },
  });

  app.setErrorHandler((error, request, reply) => {
    if (error instanceof ZodError) {
      return reply.status(400).send({
        statusCode: 400,
        error: 'Bad Request',
        message: 'Validation failed',
        details: error.errors.map(err => ({ field: err.path.join('.'), message: err.message })),
      });
    }

    if (error.statusCode) {
      return reply.status(error.statusCode).send({
        statusCode: error.statusCode,
        error: error.name,
        message: error.message,
      });
    }

    app.log.error(error);
    return reply.status(500).send({
      statusCode: 500,
      error: 'Internal Server Error',
      message: 'An unexpected error occurred',
    });
  });

  app.get('/health', async () => {
    return { status: 'ok', timestamp: new Date().toISOString() };
  });

  await app.register(authRoutes, { prefix: '/auth' });
  await app.register(productRoutes, { prefix: '/api/products' });
  await app.register(configRoutes, { prefix: '/api/products' });
  await app.register(plansRoutes, { prefix: '/api/products' });

  return app;
}

const start = async () => {
  try {
    const server = await buildServer();
    const port = parseInt(process.env.API_PORT || '3001', 10);
    await server.listen({ port, host: '0.0.0.0' });
    console.log(`Server listening on port ${port}, DEV_MODE: ${process.env.DEV_MODE}`);

    // Run sync in the background
    liferaySyncService.syncProducts().then(res => {
      console.log(`Synced ${res.synced} products from Liferay on startup`);
    }).catch(err => {
      console.log('Liferay sync failed on startup:', err.message);
    });
  } catch (err) {
    app.log.error(err);
    process.exit(1);
  }
};

start();

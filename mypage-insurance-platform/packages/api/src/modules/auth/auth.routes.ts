import { FastifyInstance } from 'fastify';
import { authService } from './auth.service.js';
import { authMiddleware } from '../../shared/middleware/auth.middleware.js';

export default async function(app: FastifyInstance) {
  const rateLimitConfig = {
    config: {
      rateLimit: {
        max: 10,
        timeWindow: '1 minute'
      }
    }
  };

  app.get('/login', rateLimitConfig, async (request, reply) => {
    const state = 'dummy-state-123';
    const url = await authService.getAuthorizationUrl(state);
    return reply.redirect(url);
  });

  app.get('/callback', rateLimitConfig, async (request, reply) => {
    const expectedState = 'dummy-state-123';
    const url = `${request.protocol}://${request.hostname}${request.url}`;
    const user = await authService.handleCallback(url, expectedState);
    
    const token = app.jwt.sign(user);
    reply.setCookie('token', token, {
      path: '/',
      httpOnly: true,
      secure: process.env.NODE_ENV === 'production',
      sameSite: 'lax',
    });
    
    return reply.redirect(`${process.env.ADMIN_ORIGIN || 'http://localhost:3000'}/login/callback?token=${token}`);
  });

  app.get('/me', { preHandler: [authMiddleware] }, async (request, reply) => {
    return request.user;
  });

  app.post('/logout', { preHandler: [authMiddleware] }, async (request, reply) => {
    reply.clearCookie('token', { path: '/' });
    return { success: true };
  });
}

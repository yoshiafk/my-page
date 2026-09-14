import { FastifyRequest, FastifyReply } from 'fastify';

export async function authMiddleware(request: FastifyRequest, reply: FastifyReply) {
  try {
    await request.jwtVerify();
    const user = request.user as any;
    if (user.role !== 'product-admin') {
      return reply.status(403).send({
        statusCode: 403,
        error: 'Forbidden',
        message: 'Requires product-admin role'
      });
    }
  } catch (err) {
    return reply.status(401).send({
      statusCode: 401,
      error: 'Unauthorized',
      message: 'Invalid or missing token'
    });
  }
}

import { Issuer, BaseClient } from 'openid-client';

class AuthService {
  private client: BaseClient | null = null;
  
  async init() {
    if (this.client || process.env.DEV_MODE === 'true') return;
    
    const issuer = await Issuer.discover(process.env.OIDC_ISSUER_URL || 'https://oneaccount.axa.com');
    this.client = new issuer.Client({
      client_id: process.env.OIDC_CLIENT_ID || 'client-id',
      client_secret: process.env.OIDC_CLIENT_SECRET || 'client-secret',
      redirect_uris: [process.env.OIDC_REDIRECT_URI || 'http://localhost:3001/auth/callback'],
      response_types: ['code'],
    });
  }

  async getAuthorizationUrl(state: string) {
    // ALWAYS return mock for local dev to avoid corporate proxy hangs
    return `http://localhost:3001/auth/callback?mock=true&state=${state}`;
  }

  async handleCallback(callbackUrl: string, expectedState: string) {
    return {
      sub: 'mock-uuid',
      email: 'admin@axa.co.id',
      name: 'Mock Admin',
      role: 'product-admin',
    };
  }
}

export const authService = new AuthService();

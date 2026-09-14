
import { db } from '../../db/index.js';
import { liferayApi } from './liferay.client.js';
import { randomUUID } from 'crypto';

class LiferaySyncService {
  async syncProducts() {
    await db.init();
    try {
      const configs = await liferayApi.getProductConfigurations();
      let count = 0;
      for (const config of configs.slice(0, 10)) {
        const existing = db.data.products.find((p: any) => p.liferayId === config.id || p.code === config.code);
        if (existing) {
          existing.name = config.name;
        } else {
          db.data.products.push({
            id: randomUUID(),
            liferayId: config.id,
            code: config.code || `LIFERAY-${config.id}`,
            name: config.name,
            source: 'liferay',
            status: 'active',
            createdAt: new Date()
          });
        }
        count++;
      }
      await db.save();
      return { synced: count };
    } catch (err: unknown) {
      const message = err instanceof Error ? err.message : String(err);
      console.error(`[LiferaySyncService] Sync Error: Could not connect to real Liferay (${message}). Skipping sync.`);
      return { synced: 0 };
    }
  }

  async writeback(liferayId: number, data: any) {
    try {
      console.log(`[LiferaySyncService] Attempting to write back configuration to Liferay ID: ${liferayId}`);
      const result = await liferayApi.updateProductConfiguration(liferayId, data);
      console.log(`[LiferaySyncService] Successfully wrote back to Liferay ID: ${liferayId}`);
      return result;
    } catch (err: unknown) {
      const message = err instanceof Error ? err.message : String(err);
      console.error(`[LiferaySyncService] Critical Error: Failed to write back to Liferay JSONWS for ID: ${liferayId}. Reason:`, message);
      throw new Error(`Liferay integration failed: Unable to save legacy configuration. Ensure the Liferay VM is reachable and JSONWS is active. Details: ${message}`);
    }
  }
}

export const liferaySyncService = new LiferaySyncService();


import fs from 'fs/promises';
import path from 'path';

const DB_PATH = path.resolve(process.cwd(), 'db.json');

export class JsonDB {
  data: any = {
    products: [],
    configs: [],
    plans: [],
    benefits: []
  };

  async init() {
    try {
      const content = await fs.readFile(DB_PATH, 'utf-8');
      this.data = JSON.parse(content);
    } catch {
      await this.save();
    }
  }

  async save() {
    await fs.writeFile(DB_PATH, JSON.stringify(this.data, null, 2));
  }
}

export const db = new JsonDB();
// initialize on first use

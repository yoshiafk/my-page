import axios from 'axios';
import { env } from 'process';

export const liferayClient = axios.create({
  baseURL: env.LIFERAY_BASE_URL || 'https://mypage.axa.co.id',
  auth: {
    username: env.LIFERAY_API_USER || '',
    password: env.LIFERAY_API_PASSWORD || ''
  }
});

export const liferayApi = {
  getProductConfigurations: () => liferayClient.get('/api/jsonws/mp.productconfiguration/get-all').then(r => r.data),
  updateProductConfiguration: (id: number, data: any) => liferayClient.post('/api/jsonws/mp.productconfiguration/update', { id, ...data }).then(r => r.data),
  getMasterProvinces: () => Promise.resolve([]),
  getMasterCities: (provinceId: number) => Promise.resolve([]),
  getMasterOccupations: () => Promise.resolve([])
};

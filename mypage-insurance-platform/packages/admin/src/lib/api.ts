import axios from 'axios';

export const apiClient = axios.create({
  baseURL: (import.meta as any).env.VITE_API_URL || 'http://localhost:3001',
  withCredentials: true,
});

// Intercept 401 → redirect to /login
apiClient.interceptors.response.use(
  (r) => r,
  (error) => {
    if (error.response?.status === 401) window.location.href = '/login';
    return Promise.reject(error);
  }
);

export const productsApi = {
  list: (params?: { source?: string; status?: string; search?: string }) =>
    apiClient.get('/api/products', { params }).then((r) => r.data),
  get: (id: string) => apiClient.get(`/api/products/${id}`).then((r) => r.data),
  create: (data: any) => apiClient.post('/api/products', data).then((r) => r.data),
  update: (id: string, data: any) => apiClient.put(`/api/products/${id}`, data).then((r) => r.data),
  publish: (id: string) => apiClient.post(`/api/products/${id}/publish`).then((r) => r.data),
  archive: (id: string) => apiClient.post(`/api/products/${id}/archive`).then((r) => r.data),
  delete: (id: string) => apiClient.delete(`/api/products/${id}`).then((r) => r.data),
  getConfig: (id: string) => apiClient.get(`/api/products/${id}/config`).then((r) => r.data),
  updateConfig: (id: string, data: any) =>
    apiClient.put(`/api/products/${id}/config`, data).then((r) => r.data),
  getPlans: (id: string) => apiClient.get(`/api/products/${id}/plans`).then((r) => r.data),
  createPlan: (id: string, data: any) =>
    apiClient.post(`/api/products/${id}/plans`, data).then((r) => r.data),
  updatePlan: (id: string, planId: string, data: any) =>
    apiClient.put(`/api/products/${id}/plans/${planId}`, data).then((r) => r.data),
  deletePlan: (id: string, planId: string) =>
    apiClient.delete(`/api/products/${id}/plans/${planId}`).then((r) => r.data),
  reorderBenefits: (id: string, planId: string, orderedIds: string[]) =>
    apiClient
      .put(`/api/products/${id}/plans/${planId}/benefits/reorder`, { orderedIds })
      .then((r) => r.data),
  createBenefit: (id: string, planId: string, data: any) =>
    apiClient.post(`/api/products/${id}/plans/${planId}/benefits`, data).then((r) => r.data),
  deleteBenefit: (id: string, planId: string, benefitId: string) =>
    apiClient
      .delete(`/api/products/${id}/plans/${planId}/benefits/${benefitId}`)
      .then((r) => r.data),
  updateFormSchema: (id: string, data: any) =>
    apiClient.put(`/api/products/${id}/form-schema`, data).then((r) => r.data),
  updateRateTable: (id: string, data: any) =>
    apiClient.put(`/api/products/${id}/rate-table`, data).then((r) => r.data),
};

// Keep default export for backward compatibility with existing code
export default apiClient;

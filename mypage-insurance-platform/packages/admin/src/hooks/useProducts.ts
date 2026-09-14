import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { productsApi } from "../lib/api";

export function useProducts(params?: { source?: string; status?: string; search?: string }) {
  return useQuery({
    queryKey: ["products", params],
    queryFn: () => productsApi.list(params),
  });
}

export function useProduct(id: string) {
  return useQuery({
    queryKey: ["product", id],
    queryFn: () => productsApi.get(id),
    enabled: !!id,
  });
}

export function useCreateProduct() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: productsApi.create,
    onSuccess: () => qc.invalidateQueries({ queryKey: ["products"] }),
  });
}

export function useUpdateProduct(id: string) {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: (data: any) => productsApi.update(id, data),
    onSuccess: () => qc.invalidateQueries({ queryKey: ["products"] }),
  });
}

export function usePublishProduct() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: productsApi.publish,
    onSuccess: () => qc.invalidateQueries({ queryKey: ["products"] }),
  });
}

export function useArchiveProduct() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: productsApi.archive,
    onSuccess: () => qc.invalidateQueries({ queryKey: ["products"] }),
  });
}

export function useDeleteProduct() {
  const qc = useQueryClient();
  return useMutation({
    mutationFn: productsApi.delete,
    onSuccess: () => qc.invalidateQueries({ queryKey: ["products"] }),
  });
}

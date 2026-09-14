import { z } from 'zod';

export const CreateProductSchema = z.object({
  name: z.string().min(1),
  code: z.string().min(1),
  productType: z.string().optional(),
  isB2C: z.boolean().optional(),
  isB2B: z.boolean().optional(),
  isB2B2C: z.boolean().optional(),
});

export const UpdateProductSchema = CreateProductSchema.partial();

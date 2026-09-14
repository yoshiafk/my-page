export interface User { id: string; name: string; email: string; }
export interface AuthState { user: User | null; token: string | null; }

export interface Product {
  id: string;
  name: string;
  code: string;
  status: 'DRAFT' | 'ACTIVE' | 'INACTIVE';
  source: 'PLATFORM' | 'LIFERAY';
  updatedAt: string;
}

export interface ProductConfig {}
export interface ProductPlan { name: string; tier: string; description: string; benefits: ProductBenefit[]; }
export interface ProductBenefit { name: string; value: string; unit: string; highlight: boolean; }

export interface FormSchema { steps: FormStep[]; }
export interface FormStep { id: string; fields: FormField[]; }
export interface FormField { id: string; label: string; type: string; required: boolean; }

export interface RateTableData { variables: RateVariable[]; matrix: any[]; }
export interface RateVariable { name: string; options: string[]; }

export interface IdentityFormData { name: string; code: string; ojkName: string; type: string; target: string; }
export interface PlanFormData extends ProductPlan { id: string; }
export interface AdminConfigData { stampDutyIDR: number; stampDutyUSD: number; policyCostIDR: number; policyCostUSD: number; commissionPercent: number; gracePeriodDays: number; requirePEP: boolean; }

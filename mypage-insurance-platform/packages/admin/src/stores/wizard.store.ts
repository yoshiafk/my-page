import { create } from 'zustand';
import { IdentityFormData, PlanFormData, RateTableData, FormSchema, AdminConfigData } from '../types';

interface WizardStore {
  currentStep: number;
  productId: string | null;
  identity: IdentityFormData | null;
  plans: PlanFormData[];
  rateTable: RateTableData | null;
  formSchema: FormSchema | null;
  adminConfig: AdminConfigData | null;
  setStep: (step: number) => void;
  setProductId: (id: string) => void;
  setIdentity: (data: IdentityFormData) => void;
  setPlans: (data: PlanFormData[]) => void;
  setRateTable: (data: RateTableData) => void;
  setFormSchema: (data: FormSchema) => void;
  setAdminConfig: (data: AdminConfigData) => void;
  reset: () => void;
}

export const useWizardStore = create<WizardStore>((set) => ({
  currentStep: 1,
  productId: null,
  identity: null,
  plans: [],
  rateTable: null,
  formSchema: null,
  adminConfig: null,
  setStep: (step) => set({ currentStep: step }),
  setProductId: (id) => set({ productId: id }),
  setIdentity: (data) => set({ identity: data }),
  setPlans: (data) => set({ plans: data }),
  setRateTable: (data) => set({ rateTable: data }),
  setFormSchema: (data) => set({ formSchema: data }),
  setAdminConfig: (data) => set({ adminConfig: data }),
  reset: () => set({
    currentStep: 1,
    productId: null,
    identity: null,
    plans: [],
    rateTable: null,
    formSchema: null,
    adminConfig: null,
  }),
}));

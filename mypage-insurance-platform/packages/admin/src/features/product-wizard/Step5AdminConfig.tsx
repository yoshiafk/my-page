import { useForm } from 'react-hook-form';
import { Button, Input, Label, Card } from '../../components/ui';
import { useWizardStore } from '../../stores/wizard.store';
import { apiClient } from '../../lib/api';
import { useState } from 'react';

interface AdminConfigFormData {
  stampDutyIDR: number;
  stampDutyUSD: number;
  policyCostIDR: number;
  policyCostUSD: number;
  commissionPercent: number;
  gracePeriodDays: number;
  pepScreening: boolean;
  policyWordingUrl: string;
  ojkProductCode: string;
}

function SectionHeading({ children }: { children: React.ReactNode }) {
  return (
    <h3 className="text-sm font-semibold text-axa-blue uppercase tracking-wide border-b border-axa-border pb-2 mb-4">
      {children}
    </h3>
  );
}

export default function Step5AdminConfig() {
  const { adminConfig, setAdminConfig, setStep, productId } = useWizardStore();
  const [saving, setSaving] = useState(false);

  const { register, handleSubmit, formState: { errors } } = useForm<AdminConfigFormData>({
    defaultValues: adminConfig
      ? {
          stampDutyIDR:      (adminConfig as any).stampDutyIDR      ?? 0,
          stampDutyUSD:      (adminConfig as any).stampDutyUSD      ?? 0,
          policyCostIDR:     (adminConfig as any).policyCostIDR     ?? 0,
          policyCostUSD:     (adminConfig as any).policyCostUSD     ?? 0,
          commissionPercent: (adminConfig as any).commissionPercent ?? 0,
          gracePeriodDays:   (adminConfig as any).gracePeriodDays   ?? 30,
          pepScreening:      (adminConfig as any).pepScreening      ?? false,
          policyWordingUrl:  (adminConfig as any).policyWordingUrl  ?? '',
          ojkProductCode:    (adminConfig as any).ojkProductCode    ?? '',
        }
      : {
          stampDutyIDR: 0, stampDutyUSD: 0,
          policyCostIDR: 0, policyCostUSD: 0,
          commissionPercent: 0, gracePeriodDays: 30,
          pepScreening: false, policyWordingUrl: '', ojkProductCode: '',
        },
  });

  const onSubmit = async (data: AdminConfigFormData) => {
    // Cast numbers (react-hook-form returns strings for number inputs)
    const parsed = {
      ...data,
      stampDutyIDR:      Number(data.stampDutyIDR),
      stampDutyUSD:      Number(data.stampDutyUSD),
      policyCostIDR:     Number(data.policyCostIDR),
      policyCostUSD:     Number(data.policyCostUSD),
      commissionPercent: Number(data.commissionPercent),
      gracePeriodDays:   Number(data.gracePeriodDays),
    };
    setAdminConfig(parsed as any);

    if (productId && !productId.startsWith('DRAFT-')) {
      try {
        setSaving(true);
        await apiClient.put(`/products/${productId}/config`, parsed);
      } catch {
        // non-blocking
      } finally {
        setSaving(false);
      }
    }
    setStep(6);
  };

  const numberFieldClass = "mt-1";

  return (
    <form onSubmit={handleSubmit(onSubmit)} className="space-y-6">
      <h2 className="text-lg font-bold text-axa-text">Admin Configuration</h2>

      {/* ── Financial Parameters ── */}
      <Card className="p-5">
        <SectionHeading>Financial Parameters</SectionHeading>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
          <div>
            <Label>Stamp Duty (IDR)</Label>
            <Input
              type="number"
              step={1000}
              min={0}
              className={numberFieldClass}
              {...register('stampDutyIDR')}
            />
          </div>
          <div>
            <Label>Stamp Duty (USD)</Label>
            <Input
              type="number"
              step={0.01}
              min={0}
              className={numberFieldClass}
              {...register('stampDutyUSD')}
            />
          </div>
          <div>
            <Label>Policy Cost (IDR)</Label>
            <Input
              type="number"
              step={1000}
              min={0}
              className={numberFieldClass}
              {...register('policyCostIDR')}
            />
          </div>
          <div>
            <Label>Policy Cost (USD)</Label>
            <Input
              type="number"
              step={0.01}
              min={0}
              className={numberFieldClass}
              {...register('policyCostUSD')}
            />
          </div>
          <div>
            <Label>Commission (%)</Label>
            <Input
              type="number"
              step={0.1}
              min={0}
              max={100}
              className={numberFieldClass}
              placeholder="0.0"
              {...register('commissionPercent', { min: 0, max: 100 })}
            />
            {errors.commissionPercent && (
              <p className="text-xs text-axa-error mt-1">Must be between 0 and 100</p>
            )}
          </div>
        </div>
      </Card>

      {/* ── Policy Settings ── */}
      <Card className="p-5">
        <SectionHeading>Policy Settings</SectionHeading>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-5">
          <div>
            <Label>Grace Period (Days)</Label>
            <Input
              type="number"
              step={1}
              min={0}
              max={365}
              className={numberFieldClass}
              {...register('gracePeriodDays', { min: 0, max: 365 })}
            />
            {errors.gracePeriodDays && (
              <p className="text-xs text-axa-error mt-1">Must be between 0 and 365</p>
            )}
          </div>

          <div className="flex items-start gap-3 pt-1">
            <div className="mt-6 flex items-center gap-2">
              <input
                type="checkbox"
                id="pepScreening"
                className="w-4 h-4 accent-axa-blue"
                {...register('pepScreening')}
              />
              <label htmlFor="pepScreening" className="text-sm font-medium text-axa-text cursor-pointer select-none">
                Enable PEP Screening
              </label>
            </div>
          </div>

          <div className="md:col-span-2">
            <Label>Policy Wording PDF URL</Label>
            <Input
              type="text"
              className={numberFieldClass}
              placeholder="https://..."
              {...register('policyWordingUrl')}
            />
          </div>
        </div>
      </Card>

      {/* ── Regulatory ── */}
      <Card className="p-5">
        <SectionHeading>Regulatory</SectionHeading>
        <div className="max-w-sm">
          <Label>OJK Product Code <span className="font-normal text-axa-muted">(optional)</span></Label>
          <Input
            type="text"
            className={numberFieldClass}
            placeholder="e.g. OJK-2024-001"
            {...register('ojkProductCode')}
          />
          <p className="text-xs text-axa-muted mt-1">
            External OJK code — separate from the internal product code.
          </p>
        </div>
      </Card>

      {/* Navigation */}
      <div className="flex justify-between pt-2 border-t border-axa-border">
        <Button type="button" variant="outline" onClick={() => setStep(4)}>Back</Button>
        <Button type="submit" disabled={saving}>
          {saving ? 'Saving…' : 'Next Step'}
        </Button>
      </div>
    </form>
  );
}

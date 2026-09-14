import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { CheckCircle, AlertCircle, ChevronDown } from 'lucide-react';
import { Button, Badge, Card } from '../../components/ui';
import { useWizardStore } from '../../stores/wizard.store';
import { apiClient } from '../../lib/api';

// ─── Collapsible Section ──────────────────────────────────────────────────────

function Section({ title, children, defaultOpen = true }: { title: string; children: React.ReactNode; defaultOpen?: boolean }) {
  return (
    <details open={defaultOpen} className="group border border-axa-border rounded-lg overflow-hidden">
      <summary className="flex items-center justify-between px-4 py-3 bg-axa-surface cursor-pointer select-none list-none hover:bg-axa-light transition-colors">
        <span className="font-semibold text-axa-text text-sm">{title}</span>
        <ChevronDown className="w-4 h-4 text-axa-muted transition-transform group-open:rotate-180" />
      </summary>
      <div className="p-4 bg-white">{children}</div>
    </details>
  );
}

function Row({ label, value }: { label: string; value?: string | number | boolean | null }) {
  const display = value === null || value === undefined ? '—' : String(value);
  return (
    <div className="flex py-1.5 border-b border-axa-border/40 last:border-0">
      <span className="w-44 text-xs text-axa-muted flex-shrink-0">{label}</span>
      <span className="text-sm text-axa-text font-medium break-all">{display}</span>
    </div>
  );
}

// ─── Main Component ───────────────────────────────────────────────────────────

export default function Step6Preview() {
  const store = useWizardStore();
  const navigate = useNavigate();
  const { identity, plans, rateTable, formSchema, adminConfig, productId } = store;

  const [publishing, setPublishing] = useState(false);
  const [savingDraft, setSavingDraft] = useState(false);
  const [successMsg, setSuccessMsg] = useState('');
  const [errorMsg, setErrorMsg] = useState('');
  const [showRawJson, setShowRawJson] = useState(false);

  const handleSaveDraft = async () => {
    if (!productId) return;
    setSavingDraft(true);
    setErrorMsg('');
    try {
      // Product already created — just navigate to the list
      await new Promise(r => setTimeout(r, 400)); // brief UX pause
      store.reset();
      navigate('/products');
    } catch (err: any) {
      setErrorMsg(err?.response?.data?.message ?? 'Failed to save draft.');
    } finally {
      setSavingDraft(false);
    }
  };

  const handlePublish = async () => {
    if (!productId) return;
    setPublishing(true);
    setErrorMsg('');
    setSuccessMsg('');
    try {
      await apiClient.post(`/products/${productId}/publish`);
      setSuccessMsg('Product published successfully!');
      setTimeout(() => {
        store.reset();
        navigate('/products');
      }, 1500);
    } catch (err: any) {
      setErrorMsg(err?.response?.data?.message ?? 'Failed to publish product.');
    } finally {
      setPublishing(false);
    }
  };

  // ─── No productId guard ────────────────────────────────────────────────────

  if (!productId) {
    return (
      <div className="space-y-4">
        <h2 className="text-lg font-bold text-axa-text">Review &amp; Publish</h2>
        <div className="flex items-start gap-3 p-4 bg-axa-error-light border border-axa-error rounded-lg">
          <AlertCircle className="w-5 h-5 text-axa-error flex-shrink-0 mt-0.5" />
          <p className="text-sm text-axa-error">
            No product ID found. Please go back and complete Step 1.
          </p>
        </div>
        <div className="flex justify-start pt-2">
          <Button variant="outline" onClick={() => store.setStep(5)}>Back</Button>
        </div>
      </div>
    );
  }

  // ─── Render ────────────────────────────────────────────────────────────────

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <h2 className="text-lg font-bold text-axa-text">Review &amp; Publish</h2>
        <span className="text-xs text-axa-muted">Product ID: <code className="bg-axa-surface px-1 rounded">{productId}</code></span>
      </div>

      {/* Success / Error banners */}
      {successMsg && (
        <div className="flex items-center gap-2 p-3 bg-axa-success-light border border-axa-success rounded-lg">
          <CheckCircle className="w-4 h-4 text-axa-success" />
          <p className="text-sm text-axa-success font-medium">{successMsg}</p>
        </div>
      )}
      {errorMsg && (
        <div className="flex items-center gap-2 p-3 bg-axa-error-light border border-axa-error rounded-lg">
          <AlertCircle className="w-4 h-4 text-axa-error" />
          <p className="text-sm text-axa-error">{errorMsg}</p>
        </div>
      )}

      {/* 1. Identity */}
      <Section title="1. Identity">
        <Row label="Product Name"       value={identity?.name} />
        <Row label="Product Code"       value={identity?.code} />
        <Row label="OJK Name"           value={identity?.ojkName} />
        <Row label="Product Type"       value={identity?.type} />
        <Row label="Target Market"      value={identity?.target} />
      </Section>

      {/* 2. Plans & Benefits */}
      <Section title="2. Plans &amp; Benefits">
        {(!plans || plans.length === 0) ? (
          <p className="text-sm text-axa-muted">No plans defined.</p>
        ) : (
          <div className="space-y-3">
            {plans.map((plan, i) => (
              <Card key={plan.id ?? i} className="p-3">
                <div className="flex items-center gap-2 mb-2">
                  <span className="font-semibold text-sm text-axa-text">{plan.name || `Plan ${i + 1}`}</span>
                  <Badge>{plan.tier}</Badge>
                </div>
                {plan.description && <p className="text-xs text-axa-muted mb-2">{plan.description}</p>}
                {plan.benefits && plan.benefits.length > 0 && (
                  <ul className="text-xs text-axa-text space-y-0.5">
                    {plan.benefits.map((b, j) => (
                      <li key={j} className="flex gap-2">
                        <span className="text-axa-muted w-40 flex-shrink-0">{b.name}</span>
                        <span>{b.value} {b.unit}</span>
                        {b.highlight && <Badge variant="success" className="text-xs py-0 px-1">★</Badge>}
                      </li>
                    ))}
                  </ul>
                )}
              </Card>
            ))}
          </div>
        )}
      </Section>

      {/* 3. Rate Table */}
      <Section title="3. Rate Table" defaultOpen={false}>
        {!rateTable ? (
          <p className="text-sm text-axa-muted">No rate table defined.</p>
        ) : (
          <div className="space-y-2">
            <p className="text-sm text-axa-text">
              <span className="text-axa-muted">Variables: </span>
              {rateTable.variables?.map(v => v.name).join(', ') || '—'}
            </p>
            <p className="text-sm text-axa-text">
              <span className="text-axa-muted">Matrix rows: </span>
              {rateTable.matrix?.length ?? 0}
            </p>
          </div>
        )}
      </Section>

      {/* 4. Form Schema */}
      <Section title="4. Form Schema" defaultOpen={false}>
        {!formSchema || !formSchema.steps?.length ? (
          <p className="text-sm text-axa-muted">No form schema defined.</p>
        ) : (
          <div className="space-y-2">
            {formSchema.steps.map((step: any, i: number) => (
              <div key={step.id ?? i} className="flex items-center justify-between text-sm py-1 border-b border-axa-border/40 last:border-0">
                <span className="text-axa-text font-medium">{step.label || `Step ${i + 1}`}</span>
                <span className="text-axa-muted text-xs">{step.fields?.length ?? 0} field(s)</span>
              </div>
            ))}
            <button
              onClick={() => setShowRawJson(v => !v)}
              className="text-xs text-axa-blue hover:underline mt-2"
            >
              {showRawJson ? 'Hide' : 'View'} Raw JSON
            </button>
            {showRawJson && (
              <pre className="text-xs bg-axa-surface border border-axa-border rounded p-3 overflow-auto max-h-48 mt-2">
                {JSON.stringify(formSchema, null, 2)}
              </pre>
            )}
          </div>
        )}
      </Section>

      {/* 5. Admin Config */}
      <Section title="5. Admin Config" defaultOpen={false}>
        {!adminConfig ? (
          <p className="text-sm text-axa-muted">No admin config defined.</p>
        ) : (
          <div>
            <Row label="Stamp Duty IDR"    value={(adminConfig as any).stampDutyIDR} />
            <Row label="Stamp Duty USD"    value={(adminConfig as any).stampDutyUSD} />
            <Row label="Policy Cost IDR"   value={(adminConfig as any).policyCostIDR} />
            <Row label="Policy Cost USD"   value={(adminConfig as any).policyCostUSD} />
            <Row label="Commission %"      value={(adminConfig as any).commissionPercent} />
            <Row label="Grace Period"      value={`${(adminConfig as any).gracePeriodDays ?? '—'} days`} />
            <Row label="PEP Screening"     value={(adminConfig as any).pepScreening ? 'Enabled' : 'Disabled'} />
            <Row label="Policy Wording URL" value={(adminConfig as any).policyWordingUrl} />
            <Row label="OJK Product Code"  value={(adminConfig as any).ojkProductCode} />
          </div>
        )}
      </Section>

      {/* Navigation */}
      <div className="flex justify-between items-center pt-4 border-t border-axa-border">
        <Button variant="outline" onClick={() => store.setStep(5)}>Back</Button>
        <div className="flex gap-3">
          <Button
            variant="outline"
            onClick={handleSaveDraft}
            disabled={savingDraft || publishing}
          >
            {savingDraft ? 'Saving…' : 'Save as Draft'}
          </Button>
          <Button
            className="bg-axa-blue text-white hover:bg-axa-dark"
            onClick={handlePublish}
            disabled={publishing || savingDraft}
          >
            {publishing ? 'Publishing…' : 'Publish Product'}
          </Button>
        </div>
      </div>
    </div>
  );
}

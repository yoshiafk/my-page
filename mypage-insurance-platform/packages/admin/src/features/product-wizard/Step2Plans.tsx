import { useState, useCallback } from "react";
import { ChevronDown, ChevronUp, Plus, Trash2, AlertCircle, Loader2 } from "lucide-react";
import { Button, Input, Label } from "../../components/ui";
import { useWizardStore } from "../../stores/wizard.store";
import { productsApi } from "../../lib/api";
import type { PlanFormData } from "../../types";

const TIERS = ["Basic", "Silver", "Gold", "Platinum", "Custom"] as const;

interface Benefit {
  id: string;
  name: string;
  value: string;
  unit: string;
  highlight: boolean;
}

interface LocalPlan {
  id: string;
  name: string;
  tier: string;
  description: string;
  benefits: Benefit[];
  isExpanded: boolean;
}

function genId() {
  return "tmp-" + Math.random().toString(36).slice(2, 10);
}

export default function Step2Plans() {
  const { plans, setPlans, setStep, productId } = useWizardStore();

  const [localPlans, setLocalPlans] = useState<LocalPlan[]>(() =>
    plans.length
      ? plans.map((p) => ({
          ...p,
          isExpanded: true,
          benefits: p.benefits.map((b: any) => ({ ...b, id: b.id || genId() }))
        }))
      : []
  );
  const [isSaving, setIsSaving] = useState(false);
  const [saveError, setSaveError] = useState<string | null>(null);

  // ── Plan-level helpers ────────────────────────────────────────────────────
  const addPlan = () =>
    setLocalPlans((prev) => [
      ...prev,
      {
        id: genId(),
        name: "",
        tier: "Basic",
        description: "",
        benefits: [],
        isExpanded: true,
      },
    ]);

  const deletePlan = (planId: string) => {
    if (!window.confirm("Delete this plan?")) return;
    setLocalPlans((prev) => prev.filter((p) => p.id !== planId));
  };

  const toggleExpand = (planId: string) =>
    setLocalPlans((prev) =>
      prev.map((p) => (p.id === planId ? { ...p, isExpanded: !p.isExpanded } : p))
    );

  const updatePlan = useCallback(
    (planId: string, field: keyof Omit<LocalPlan, "id" | "benefits" | "isExpanded">, value: string) =>
      setLocalPlans((prev) =>
        prev.map((p) => (p.id === planId ? { ...p, [field]: value } : p))
      ),
    []
  );

  // ── Benefit-level helpers ─────────────────────────────────────────────────
  const addBenefit = (planId: string) =>
    setLocalPlans((prev) =>
      prev.map((p) =>
        p.id === planId
          ? {
              ...p,
              benefits: [
                ...p.benefits,
                { id: genId(), name: "", value: "", unit: "", highlight: false },
              ],
            }
          : p
      )
    );

  const deleteBenefit = (planId: string, benefitId: string) =>
    setLocalPlans((prev) =>
      prev.map((p) =>
        p.id === planId
          ? { ...p, benefits: p.benefits.filter((b) => b.id !== benefitId) }
          : p
      )
    );

  const updateBenefit = (
    planId: string,
    benefitId: string,
    field: keyof Benefit,
    value: string | boolean
  ) =>
    setLocalPlans((prev) =>
      prev.map((p) =>
        p.id === planId
          ? {
              ...p,
              benefits: p.benefits.map((b) =>
                b.id === benefitId ? { ...b, [field]: value } : b
              ),
            }
          : p
      )
    );

  // ── Submit ─────────────────────────────────────────────────────────────────
  const onNext = async () => {
    setSaveError(null);
    const planData: PlanFormData[] = localPlans.map(({ id, name, tier, description, benefits }) => ({
      id,
      name,
      tier,
      description,
      benefits: benefits.map(({ name: n, value, unit, highlight }) => ({
        name: n,
        value,
        unit,
        highlight,
      })),
    }));
    setPlans(planData);

    if (productId) {
      setIsSaving(true);
      try {
        // TODO: add drag-and-drop reordering via productsApi.reorderBenefits
        await Promise.all(planData.map((p) => productsApi.createPlan(productId, p)));
      } catch (err) {
        setSaveError(err instanceof Error ? err.message : "Failed to save plans.");
        setIsSaving(false);
        return;
      }
      setIsSaving(false);
    }

    setStep(3);
  };

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex items-center justify-between">
        <div>
          <h2 className="text-lg font-semibold text-axa-text">Plans &amp; Benefits</h2>
          <p className="text-sm text-axa-muted mt-0.5">
            Define coverage tiers and their included benefits.
          </p>
        </div>
        <Button variant="outline" onClick={addPlan}>
          <Plus size={16} className="mr-1.5" />
          Add Plan
        </Button>
      </div>

      {localPlans.length === 0 && (
        <div className="rounded-lg border border-dashed border-axa-border bg-axa-surface p-10 text-center text-axa-muted text-sm">
          No plans yet. Click "Add Plan" to get started.
        </div>
      )}

      {localPlans.map((plan, planIdx) => (
        <div
          key={plan.id}
          className="shadow-card border border-axa-border rounded-lg p-4 mb-4 bg-white"
        >
          {/* Plan header */}
          <div className="flex items-center gap-3 mb-4">
            <span className="text-xs font-semibold text-axa-muted uppercase tracking-wider w-6 text-center">
              #{planIdx + 1}
            </span>
            <div className="grid grid-cols-1 sm:grid-cols-3 gap-3 flex-1">
              {/* Plan Name */}
              <div className="space-y-1">
                <Label className="text-axa-text text-xs">Plan Name</Label>
                <Input
                  value={plan.name}
                  onChange={(e) => updatePlan(plan.id, "name", e.target.value)}
                  placeholder="e.g. Comprehensive Cover"
                />
              </div>
              {/* Tier */}
              <div className="space-y-1">
                <Label className="text-axa-text text-xs">Tier</Label>
                <select
                  value={plan.tier}
                  onChange={(e) => updatePlan(plan.id, "tier", e.target.value)}
                  className="flex h-10 w-full rounded-md border border-axa-border bg-white px-3 py-2 text-sm text-axa-text focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring"
                >
                  {TIERS.map((t) => (
                    <option key={t} value={t}>{t}</option>
                  ))}
                </select>
              </div>
              {/* Description */}
              <div className="space-y-1">
                <Label className="text-axa-text text-xs">Description</Label>
                <textarea
                  value={plan.description}
                  onChange={(e) => updatePlan(plan.id, "description", e.target.value)}
                  rows={1}
                  placeholder="Short description"
                  className="flex w-full rounded-md border border-axa-border bg-white px-3 py-2 text-sm text-axa-text placeholder:text-axa-muted focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring resize-none"
                />
              </div>
            </div>
            {/* Actions */}
            <div className="flex items-center gap-1 ml-2">
              <button
                type="button"
                onClick={() => toggleExpand(plan.id)}
                className="p-1.5 rounded hover:bg-axa-surface text-axa-muted hover:text-axa-text transition-colors"
                title={plan.isExpanded ? "Collapse" : "Expand"}
              >
                {plan.isExpanded ? <ChevronUp size={16} /> : <ChevronDown size={16} />}
              </button>
              <button
                type="button"
                onClick={() => deletePlan(plan.id)}
                className="p-1.5 rounded hover:bg-axa-error-light text-axa-muted hover:text-axa-error transition-colors"
                title="Delete plan"
              >
                <Trash2 size={16} />
              </button>
            </div>
          </div>

          {/* Benefits */}
          {plan.isExpanded && (
            <div className="mt-3 border-t border-axa-border pt-4 space-y-3">
              <div className="flex items-center justify-between mb-2">
                <span className="text-xs font-semibold text-axa-muted uppercase tracking-wider">
                  Benefits ({plan.benefits.length})
                </span>
                <Button variant="ghost" onClick={() => addBenefit(plan.id)} className="h-7 text-xs px-2">
                  <Plus size={13} className="mr-1" />
                  Add Benefit
                </Button>
              </div>

              {plan.benefits.length === 0 && (
                <p className="text-xs text-axa-muted text-center py-3">
                  No benefits yet. Click "Add Benefit".
                </p>
              )}

              {plan.benefits.map((benefit, bIdx) => (
                <div key={benefit.id} className="flex items-center gap-2 bg-axa-surface rounded-md px-3 py-2">
                  <span className="text-xs text-axa-muted w-4 shrink-0">{bIdx + 1}.</span>
                  <Input
                    value={benefit.name}
                    onChange={(e) => updateBenefit(plan.id, benefit.id, "name", e.target.value)}
                    placeholder="Benefit name"
                    className="flex-1 h-8 text-xs"
                  />
                  <Input
                    value={benefit.value}
                    onChange={(e) => updateBenefit(plan.id, benefit.id, "value", e.target.value)}
                    placeholder="Value"
                    className="w-28 h-8 text-xs"
                  />
                  <Input
                    value={benefit.unit}
                    onChange={(e) => updateBenefit(plan.id, benefit.id, "unit", e.target.value)}
                    placeholder="Unit (IDR, %…)"
                    className="w-28 h-8 text-xs"
                  />
                  <label className="flex items-center gap-1.5 cursor-pointer shrink-0">
                    <input
                      type="checkbox"
                      checked={benefit.highlight}
                      onChange={(e) => updateBenefit(plan.id, benefit.id, "highlight", e.target.checked)}
                      className="h-4 w-4 rounded border-axa-border accent-axa-blue"
                    />
                    <span className="text-xs text-axa-muted">Highlight</span>
                  </label>
                  <button
                    type="button"
                    onClick={() => deleteBenefit(plan.id, benefit.id)}
                    className="p-1 rounded hover:bg-axa-error-light text-axa-muted hover:text-axa-error transition-colors shrink-0"
                  >
                    <Trash2 size={13} />
                  </button>
                </div>
              ))}
            </div>
          )}
        </div>
      ))}

      {/* Error */}
      {saveError && (
        <div className="flex items-center gap-2 rounded-md border border-axa-error-light bg-axa-error-light px-4 py-3 text-sm text-axa-error">
          <AlertCircle size={16} className="shrink-0" />
          {saveError}
        </div>
      )}

      {/* Navigation */}
      <div className="flex justify-between pt-2">
        <Button variant="outline" onClick={() => setStep(1)}>
          Back
        </Button>
        <Button onClick={onNext} disabled={isSaving}>
          {isSaving ? (
            <>
              <Loader2 size={16} className="mr-2 animate-spin" />
              Saving…
            </>
          ) : (
            "Next Step"
          )}
        </Button>
      </div>
    </div>
  );
}

import { useState } from 'react';
import {
  ChevronUp, ChevronDown, Pencil, Trash2, Plus, X,
  Type, Hash, Calendar, List, CheckSquare, FileUp, Phone, AlignLeft, CircleDot,
} from 'lucide-react';
import { Button, Input, Label } from '../../components/ui';
import { useWizardStore } from '../../stores/wizard.store';
import { apiClient } from '../../lib/api';

// ─── Types ────────────────────────────────────────────────────────────────────

type FieldType = 'text' | 'number' | 'date' | 'select' | 'radio' | 'checkbox' | 'file' | 'phone' | 'textarea';

interface Field {
  id: string;
  type: FieldType;
  label: string;
  placeholder?: string;
  required: boolean;
  options?: string[];
  source?: string;
  conditionalOn?: { field: string; value: string };
}

interface WizardStep {
  id: string;
  label: string;
  fields: Field[];
}

// ─── Palette config ───────────────────────────────────────────────────────────

const FIELD_PALETTE: { type: FieldType; label: string; icon: React.ReactNode }[] = [
  { type: 'text',     label: 'Text',        icon: <Type className="w-4 h-4" /> },
  { type: 'number',   label: 'Number',      icon: <Hash className="w-4 h-4" /> },
  { type: 'date',     label: 'Date',        icon: <Calendar className="w-4 h-4" /> },
  { type: 'select',   label: 'Select',      icon: <List className="w-4 h-4" /> },
  { type: 'radio',    label: 'Radio',       icon: <CircleDot className="w-4 h-4" /> },
  { type: 'checkbox', label: 'Checkbox',    icon: <CheckSquare className="w-4 h-4" /> },
  { type: 'file',     label: 'File Upload', icon: <FileUp className="w-4 h-4" /> },
  { type: 'phone',    label: 'Phone',       icon: <Phone className="w-4 h-4" /> },
  { type: 'textarea', label: 'Textarea',    icon: <AlignLeft className="w-4 h-4" /> },
];

const SOURCE_OPTIONS = [
  { value: '',                    label: 'None' },
  { value: 'liferay_provinces',   label: 'Liferay Provinces' },
  { value: 'liferay_cities',      label: 'Liferay Cities' },
  { value: 'liferay_occupations', label: 'Liferay Occupations' },
  { value: 'product_plans',       label: 'Product Plans' },
];

const typeBadgeColor: Record<FieldType, string> = {
  text:     'bg-blue-100 text-blue-700',
  number:   'bg-purple-100 text-purple-700',
  date:     'bg-yellow-100 text-yellow-700',
  select:   'bg-green-100 text-green-700',
  radio:    'bg-pink-100 text-pink-700',
  checkbox: 'bg-orange-100 text-orange-700',
  file:     'bg-red-100 text-red-700',
  phone:    'bg-teal-100 text-teal-700',
  textarea: 'bg-indigo-100 text-indigo-700',
};

// ─── Helpers ──────────────────────────────────────────────────────────────────

const newField = (type: FieldType): Field => ({
  id: `field_${Date.now()}_${Math.random().toString(36).slice(2, 6)}`,
  type,
  label: `${type.charAt(0).toUpperCase() + type.slice(1)} Field`,
  placeholder: '',
  required: false,
  options: type === 'select' || type === 'radio' ? ['Option 1'] : undefined,
  source: '',
});

const newStep = (index: number): WizardStep => ({
  id: `step_${Date.now()}`,
  label: `Step ${index}`,
  fields: [],
});

// ─── Field Editor ─────────────────────────────────────────────────────────────

interface FieldEditorProps {
  field: Field;
  onChange: (updated: Field) => void;
  onClose: () => void;
}

function FieldEditor({ field, onChange, onClose }: FieldEditorProps) {
  const [local, setLocal] = useState<Field>({ ...field });

  const update = (patch: Partial<Field>) => {
    const updated = { ...local, ...patch };
    setLocal(updated);
    onChange(updated);
  };

  const hasPlaceholder = ['text', 'number', 'phone', 'textarea'].includes(local.type);
  const hasOptions     = ['select', 'radio'].includes(local.type);
  const hasSource      = local.type === 'select';

  return (
    <div className="mt-1 border border-axa-blue/30 rounded-lg p-4 bg-axa-surface space-y-3 text-sm">
      <div className="flex justify-between items-center">
        <span className="font-semibold text-axa-text text-xs uppercase tracking-wide">Edit Field</span>
        <button onClick={onClose} className="text-axa-muted hover:text-axa-text">
          <X className="w-4 h-4" />
        </button>
      </div>

      <div>
        <Label>Label</Label>
        <Input className="mt-1" value={local.label} onChange={e => update({ label: e.target.value })} />
      </div>

      {hasPlaceholder && (
        <div>
          <Label>Placeholder</Label>
          <Input
            className="mt-1"
            value={local.placeholder ?? ''}
            onChange={e => update({ placeholder: e.target.value })}
            placeholder="e.g. Enter your name…"
          />
        </div>
      )}

      <div className="flex items-center gap-2">
        <input
          type="checkbox"
          id={`req_${local.id}`}
          checked={local.required}
          onChange={e => update({ required: e.target.checked })}
          className="w-4 h-4 accent-axa-blue"
        />
        <label htmlFor={`req_${local.id}`} className="text-axa-text select-none cursor-pointer">Required</label>
      </div>

      {hasOptions && (
        <div>
          <Label>
            Options <span className="font-normal text-axa-muted">(one per line)</span>
          </Label>
          <textarea
            className="mt-1 flex w-full rounded-md border border-axa-border bg-white px-3 py-2 text-sm focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-axa-blue min-h-[80px]"
            value={(local.options ?? []).join('\n')}
            onChange={e => update({ options: e.target.value.split('\n') })}
          />
        </div>
      )}

      {hasSource && (
        <div>
          <Label>Source</Label>
          <select
            className="mt-1 flex h-10 w-full rounded-md border border-axa-border bg-white px-3 py-2 text-sm"
            value={local.source ?? ''}
            onChange={e => update({ source: e.target.value })}
          >
            {SOURCE_OPTIONS.map(o => (
              <option key={o.value} value={o.value}>{o.label}</option>
            ))}
          </select>
        </div>
      )}
    </div>
  );
}

// ─── Main Component ───────────────────────────────────────────────────────────

export default function Step4FormBuilder() {
  const { setFormSchema, setStep, productId, formSchema } = useWizardStore();

  const [steps, setSteps] = useState<WizardStep[]>(() => {
    if (formSchema?.steps && formSchema.steps.length > 0) {
      return formSchema.steps as unknown as WizardStep[];
    }
    return [{ id: 'step_1', label: 'Step 1', fields: [] }];
  });

  const [activeStepId, setActiveStepId] = useState<string>(steps[0].id);
  const [editingFieldId, setEditingFieldId] = useState<string | null>(null);
  const [saving, setSaving] = useState(false);

  const activeStep = steps.find(s => s.id === activeStepId) ?? steps[0];

  // ─── Step helpers ──────────────────────────────────────────────────────────

  const addStep = () => {
    const s = newStep(steps.length + 1);
    setSteps(prev => [...prev, s]);
    setActiveStepId(s.id);
  };

  const removeStep = (id: string) => {
    if (steps.length <= 1) return;
    const next = steps.filter(s => s.id !== id);
    setSteps(next);
    setActiveStepId(next[next.length - 1].id);
  };

  const renameStep = (id: string, label: string) => {
    setSteps(prev => prev.map(s => s.id === id ? { ...s, label } : s));
  };

  // ─── Field helpers ─────────────────────────────────────────────────────────

  const setActiveFields = (fields: Field[]) => {
    setSteps(prev => prev.map(s => s.id === activeStepId ? { ...s, fields } : s));
  };

  const addField = (type: FieldType) => {
    const f = newField(type);
    const currentFields = steps.find(s => s.id === activeStepId)?.fields ?? [];
    setSteps(prev => prev.map(s => s.id === activeStepId ? { ...s, fields: [...currentFields, f] } : s));
    setEditingFieldId(f.id);
  };

  const deleteField = (id: string) => {
    const currentFields = steps.find(s => s.id === activeStepId)?.fields ?? [];
    setActiveFields(currentFields.filter(f => f.id !== id));
    if (editingFieldId === id) setEditingFieldId(null);
  };

  const updateField = (id: string, updated: Field) => {
    const currentFields = steps.find(s => s.id === activeStepId)?.fields ?? [];
    setActiveFields(currentFields.map(f => f.id === id ? updated : f));
  };

  const moveField = (id: string, dir: 'up' | 'down') => {
    const currentFields = steps.find(s => s.id === activeStepId)?.fields ?? [];
    const idx = currentFields.findIndex(f => f.id === id);
    if (idx === -1) return;
    const next = [...currentFields];
    const swapIdx = dir === 'up' ? idx - 1 : idx + 1;
    if (swapIdx < 0 || swapIdx >= next.length) return;
    [next[idx], next[swapIdx]] = [next[swapIdx], next[idx]];
    setActiveFields(next);
  };

  // ─── Save & Next ───────────────────────────────────────────────────────────

  const onNext = async () => {
    const schema = { steps };
    setFormSchema(schema as any);
    if (productId && !productId.startsWith('DRAFT-')) {
      try {
        setSaving(true);
        await apiClient.put(`/products/${productId}/form-schema`, schema);
      } catch {
        // non-blocking — best effort
      } finally {
        setSaving(false);
      }
    }
    setStep(5);
  };

  // ─── Render ────────────────────────────────────────────────────────────────

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between">
        <h2 className="text-lg font-bold text-axa-text">Form Builder</h2>
        <p className="text-xs text-axa-muted">Design the customer purchase form</p>
      </div>

      <div className="flex gap-4 min-h-[520px]">
        {/* Left Palette */}
        <aside className="w-44 flex-shrink-0 bg-axa-surface border-r border-axa-border rounded-l-lg p-3">
          <p className="text-xs font-semibold text-axa-muted uppercase tracking-wide mb-2">Field Types</p>
          <div className="space-y-1">
            {FIELD_PALETTE.map(p => (
              <button
                key={p.type}
                onClick={() => addField(p.type)}
                className="w-full flex items-center gap-2 text-sm px-2 py-2 rounded-md border border-axa-border bg-white hover:bg-axa-light hover:border-axa-blue text-axa-text transition-colors"
              >
                <span className="text-axa-blue">{p.icon}</span>
                {p.label}
              </button>
            ))}
          </div>
        </aside>

        {/* Center Canvas */}
        <div className="flex-1 bg-white border border-axa-border rounded-r-lg flex flex-col">
          {/* Step Tabs */}
          <div className="flex items-center gap-1 px-3 pt-3 pb-0 border-b border-axa-border flex-wrap">
            {steps.map((s) => (
              <div key={s.id} className="flex items-center">
                <button
                  onClick={() => { setActiveStepId(s.id); setEditingFieldId(null); }}
                  className={`px-3 py-1.5 rounded-t-md text-sm font-medium transition-colors border-b-2 ${
                    s.id === activeStepId
                      ? 'border-axa-blue text-axa-blue bg-axa-light'
                      : 'border-transparent text-axa-muted hover:text-axa-text'
                  }`}
                >
                  {s.label}
                </button>
                {steps.length > 1 && (
                  <button
                    onClick={() => removeStep(s.id)}
                    title="Remove step"
                    className="ml-0.5 text-axa-muted hover:text-axa-red transition-colors"
                  >
                    <X className="w-3 h-3" />
                  </button>
                )}
              </div>
            ))}
            <button
              onClick={addStep}
              className="flex items-center gap-1 px-2 py-1.5 text-xs text-axa-blue hover:bg-axa-light rounded-md transition-colors"
            >
              <Plus className="w-3 h-3" /> Add Step
            </button>
          </div>

          {/* Step Label Editor */}
          <div className="px-4 pt-3 pb-1 flex items-center gap-2 border-b border-axa-border/50">
            <Label className="text-xs text-axa-muted whitespace-nowrap">Step label:</Label>
            <Input
              className="h-7 text-sm py-0 max-w-[200px]"
              value={activeStep.label}
              onChange={e => renameStep(activeStep.id, e.target.value)}
            />
            <span className="text-xs text-axa-muted ml-auto">{activeStep.fields.length} field(s)</span>
          </div>

          {/* Fields */}
          <div className="flex-1 p-4 overflow-y-auto">
            {activeStep.fields.length === 0 ? (
              <div className="flex flex-col items-center justify-center h-full text-center text-axa-muted border-2 border-dashed border-axa-border rounded-lg py-12">
                <Plus className="w-8 h-8 mb-2 opacity-30" />
                <p className="text-sm">Click a field type on the left to add fields</p>
              </div>
            ) : (
              <div className="space-y-2">
                {activeStep.fields.map((field, idx) => (
                  <div key={field.id}>
                    {/* Field Card */}
                    <div className="border border-axa-border rounded-lg p-3 flex items-center gap-3 bg-white hover:shadow-card transition-shadow">
                      {/* Reorder Buttons */}
                      <div className="flex flex-col gap-0.5">
                        <button
                          onClick={() => moveField(field.id, 'up')}
                          disabled={idx === 0}
                          className="text-axa-muted hover:text-axa-text disabled:opacity-25 transition-colors"
                          title="Move up"
                        >
                          <ChevronUp className="w-4 h-4" />
                        </button>
                        <button
                          onClick={() => moveField(field.id, 'down')}
                          disabled={idx === activeStep.fields.length - 1}
                          className="text-axa-muted hover:text-axa-text disabled:opacity-25 transition-colors"
                          title="Move down"
                        >
                          <ChevronDown className="w-4 h-4" />
                        </button>
                      </div>

                      {/* Field Info */}
                      <div className="flex-1 min-w-0">
                        <p className="text-sm font-medium text-axa-text truncate">
                          {field.label}
                          {field.required && <span className="text-axa-red ml-1" title="Required">*</span>}
                        </p>
                        <span className={`inline-block text-xs px-1.5 py-0.5 rounded font-medium mt-0.5 ${typeBadgeColor[field.type]}`}>
                          {field.type}
                        </span>
                        {field.source && (
                          <span className="ml-2 text-xs text-axa-muted">src: {field.source}</span>
                        )}
                      </div>

                      {/* Actions */}
                      <div className="flex items-center gap-1 flex-shrink-0">
                        <button
                          onClick={() => setEditingFieldId(editingFieldId === field.id ? null : field.id)}
                          className={`p-1.5 rounded hover:bg-axa-light transition-colors ${editingFieldId === field.id ? 'text-axa-blue bg-axa-light' : 'text-axa-muted hover:text-axa-text'}`}
                          title="Edit field"
                        >
                          <Pencil className="w-4 h-4" />
                        </button>
                        <button
                          onClick={() => deleteField(field.id)}
                          className="p-1.5 rounded hover:bg-axa-error-light text-axa-muted hover:text-axa-error transition-colors"
                          title="Delete field"
                        >
                          <Trash2 className="w-4 h-4" />
                        </button>
                      </div>
                    </div>

                    {/* Inline Field Editor */}
                    {editingFieldId === field.id && (
                      <FieldEditor
                        field={field}
                        onChange={updated => updateField(field.id, updated)}
                        onClose={() => setEditingFieldId(null)}
                      />
                    )}
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>
      </div>

      {/* Navigation */}
      <div className="flex justify-between pt-4 border-t border-axa-border">
        <Button variant="outline" onClick={() => setStep(3)}>Back</Button>
        <Button onClick={onNext} disabled={saving}>
          {saving ? 'Saving…' : 'Next Step'}
        </Button>
      </div>
    </div>
  );
}

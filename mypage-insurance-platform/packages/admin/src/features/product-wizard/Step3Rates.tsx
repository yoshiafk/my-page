import { useState } from "react";
import { Plus, Trash2, AlertCircle, Loader2, RefreshCw } from "lucide-react";
import { Button, Input, Label, Card } from "../../components/ui";
import { useWizardStore } from "../../stores/wizard.store";
import { productsApi } from "../../lib/api";
import type { RateTableData } from "../../types";

interface Variable {
  name: string;
  values: string[];
}

interface MatrixRow {
  combo: Record<string, string>;
  rate: number;
}

/** Compute the Cartesian product of variable value arrays. */
function cartesianProduct(variables: Variable[]): Record<string, string>[] {
  if (variables.length === 0) return [];
  const valid = variables.filter((v) => v.name && v.values.filter(Boolean).length > 0);
  if (valid.length === 0) return [];

  return valid.reduce<Record<string, string>[]>((acc, variable) => {
    const validValues = variable.values.filter(Boolean);
    if (acc.length === 0) {
      return validValues.map((v) => ({ [variable.name]: v }));
    }
    return acc.flatMap((row) =>
      validValues.map((v) => ({ ...row, [variable.name]: v }))
    );
  }, []);
}

export default function Step3Rates() {
  const { setRateTable, setStep, productId, rateTable } = useWizardStore();

  const [variables, setVariables] = useState<Variable[]>(
    rateTable?.variables?.map((v: any) => ({ name: v.name, values: v.options ?? v.values ?? [] })) ?? []
  );
  const [matrix, setMatrix] = useState<MatrixRow[]>([]);
  const [matrixGenerated, setMatrixGenerated] = useState(false);
  const [isSaving, setIsSaving] = useState(false);
  const [saveError, setSaveError] = useState<string | null>(null);

  // ── Variable helpers ───────────────────────────────────────────────────────
  const addVariable = () =>
    setVariables((prev) => [...prev, { name: "", values: [""] }]);

  const removeVariable = (idx: number) => {
    setVariables((prev) => prev.filter((_, i) => i !== idx));
    setMatrixGenerated(false);
    setMatrix([]);
  };

  const updateVariableName = (idx: number, name: string) =>
    setVariables((prev) => prev.map((v, i) => (i === idx ? { ...v, name } : v)));

  const addValue = (varIdx: number) =>
    setVariables((prev) =>
      prev.map((v, i) => (i === varIdx ? { ...v, values: [...v.values, ""] } : v))
    );

  const removeValue = (varIdx: number, valIdx: number) =>
    setVariables((prev) =>
      prev.map((v, i) =>
        i === varIdx ? { ...v, values: v.values.filter((_, vi) => vi !== valIdx) } : v
      )
    );

  const updateValue = (varIdx: number, valIdx: number, val: string) =>
    setVariables((prev) =>
      prev.map((v, i) =>
        i === varIdx
          ? { ...v, values: v.values.map((existing, vi) => (vi === valIdx ? val : existing)) }
          : v
      )
    );

  // ── Matrix ─────────────────────────────────────────────────────────────────
  const generateMatrix = () => {
    const combos = cartesianProduct(variables);
    setMatrix(combos.map((combo) => ({ combo, rate: 0 })));
    setMatrixGenerated(true);
  };

  const clearAll = () => {
    setVariables([]);
    setMatrix([]);
    setMatrixGenerated(false);
    setSaveError(null);
  };

  const updateRate = (rowIdx: number, rate: number) =>
    setMatrix((prev) => prev.map((r, i) => (i === rowIdx ? { ...r, rate } : r)));

  // ── Submit ─────────────────────────────────────────────────────────────────
  const onNext = async () => {
    setSaveError(null);

    const rateTableData: RateTableData = {
      variables: variables.map((v) => ({
        name: v.name,
        options: v.values.filter(Boolean),
      })),
      matrix: matrix.map(({ combo, rate }) => ({ combo, rate })),
    };

    setRateTable(rateTableData);

    if (productId) {
      setIsSaving(true);
      try {
        await productsApi.updateRateTable(productId, rateTableData);
      } catch (err) {
        setSaveError(err instanceof Error ? err.message : "Failed to save rate table.");
        setIsSaving(false);
        return;
      }
      setIsSaving(false);
    }

    setStep(4);
  };

  const variableNames = variables.filter((v) => v.name).map((v) => v.name);

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex items-center justify-between">
        <div>
          <h2 className="text-lg font-semibold text-axa-text">Rate Table</h2>
          <p className="text-sm text-axa-muted mt-0.5">
            Define pricing variables and generate a rate matrix.
          </p>
        </div>
        <div className="flex gap-2">
          <Button variant="outline" onClick={addVariable}>
            <Plus size={16} className="mr-1.5" />
            Add Variable
          </Button>
          <Button variant="outline" onClick={clearAll}>
            Clear
          </Button>
        </div>
      </div>

      {/* Variables */}
      {variables.length === 0 && (
        <div className="rounded-lg border border-dashed border-axa-border bg-axa-surface p-10 text-center text-axa-muted text-sm">
          No variables defined. Click "Add Variable" to start building the matrix.
        </div>
      )}

      {variables.map((variable, varIdx) => (
        <Card key={varIdx} className="p-4">
          <div className="flex items-start gap-3">
            <div className="flex-1 space-y-3">
              {/* Variable name */}
              <div className="flex items-center gap-3">
                <div className="space-y-1 flex-1">
                  <Label className="text-xs text-axa-muted uppercase tracking-wider">
                    Variable {varIdx + 1} Name
                  </Label>
                  <Input
                    value={variable.name}
                    onChange={(e) => updateVariableName(varIdx, e.target.value)}
                    placeholder='e.g. "Building Type" or "Occupancy Zone"'
                  />
                </div>
                <button
                  type="button"
                  onClick={() => removeVariable(varIdx)}
                  className="mt-5 p-1.5 rounded hover:bg-axa-error-light text-axa-muted hover:text-axa-error transition-colors"
                  title="Remove variable"
                >
                  <Trash2 size={15} />
                </button>
              </div>

              {/* Values */}
              <div>
                <Label className="text-xs text-axa-muted uppercase tracking-wider">
                  Possible Values
                </Label>
                <div className="mt-1 flex flex-wrap gap-2">
                  {variable.values.map((val, valIdx) => (
                    <div key={valIdx} className="flex items-center gap-1">
                      <Input
                        value={val}
                        onChange={(e) => updateValue(varIdx, valIdx, e.target.value)}
                        placeholder={`Value ${valIdx + 1}`}
                        className="h-8 w-40 text-xs"
                      />
                      {variable.values.length > 1 && (
                        <button
                          type="button"
                          onClick={() => removeValue(varIdx, valIdx)}
                          className="p-1 rounded hover:bg-axa-error-light text-axa-muted hover:text-axa-error transition-colors"
                        >
                          <Trash2 size={12} />
                        </button>
                      )}
                    </div>
                  ))}
                  <Button
                    variant="ghost"
                    onClick={() => addValue(varIdx)}
                    className="h-8 text-xs px-2"
                  >
                    <Plus size={13} className="mr-1" />
                    Add Value
                  </Button>
                </div>
              </div>
            </div>
          </div>
        </Card>
      ))}

      {/* Generate Matrix */}
      {variables.length > 0 && (
        <Button variant="outline" onClick={generateMatrix}>
          <RefreshCw size={15} className="mr-1.5" />
          Generate Matrix
        </Button>
      )}

      {/* Matrix Table */}
      {matrixGenerated && (
        <Card className="overflow-auto p-0">
          <div className="p-4 border-b border-axa-border">
            <h3 className="text-sm font-semibold text-axa-text">
              Rate Matrix ({matrix.length} combinations)
            </h3>
          </div>
          {matrix.length === 0 ? (
            <p className="p-4 text-sm text-axa-muted">
              No combinations generated. Make sure variables have non-empty values.
            </p>
          ) : (
            <table className="w-full text-sm">
              <thead className="bg-axa-surface">
                <tr>
                  {variableNames.map((name) => (
                    <th
                      key={name}
                      className="px-4 py-2 text-left text-xs font-semibold text-axa-muted uppercase tracking-wider border-b border-axa-border"
                    >
                      {name}
                    </th>
                  ))}
                  <th className="px-4 py-2 text-left text-xs font-semibold text-axa-muted uppercase tracking-wider border-b border-axa-border">
                    Rate (%)
                  </th>
                </tr>
              </thead>
              <tbody>
                {matrix.map((row, rowIdx) => (
                  <tr
                    key={rowIdx}
                    className={rowIdx % 2 === 0 ? "bg-white" : "bg-axa-surface"}
                  >
                    {variableNames.map((name) => (
                      <td key={name} className="px-4 py-2 text-axa-text border-b border-axa-border">
                        {row.combo[name]}
                      </td>
                    ))}
                    <td className="px-4 py-2 border-b border-axa-border">
                      <input
                        type="number"
                        step="0.001"
                        min="0"
                        value={row.rate}
                        onChange={(e) => updateRate(rowIdx, parseFloat(e.target.value) || 0)}
                        placeholder="0.00"
                        className="h-8 w-28 rounded-md border border-axa-border bg-white px-2 py-1 text-sm text-axa-text focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring"
                      />
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </Card>
      )}

      {/* Error */}
      {saveError && (
        <div className="flex items-center gap-2 rounded-md border border-axa-error-light bg-axa-error-light px-4 py-3 text-sm text-axa-error">
          <AlertCircle size={16} className="shrink-0" />
          {saveError}
        </div>
      )}

      {/* Navigation */}
      <div className="flex justify-between pt-2">
        <Button variant="outline" onClick={() => setStep(2)}>
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

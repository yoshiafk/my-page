import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
import { Loader2, AlertCircle } from "lucide-react";
import { Button, Input, Label, Card } from "../../components/ui";
import { useWizardStore } from "../../stores/wizard.store";
import { useCreateProduct } from "../../hooks/useProducts";
import type { IdentityFormData } from "../../types";

const PRODUCT_TYPES = [
  { value: "MOTOR", label: "Motor" },
  { value: "PROPERTY", label: "Property" },
  { value: "HEALTH", label: "Health" },
  { value: "TRAVEL", label: "Travel" },
  { value: "LIFE", label: "Life" },
  { value: "PERSONAL_ACCIDENT", label: "Personal Accident" },
  { value: "PET", label: "Pet" },
  { value: "OTHER", label: "Other" },
] as const;

const schema = z.object({
  name: z.string().min(1, "Product name is required"),
  code: z.string().min(1, "Product code is required"),
  ojkName: z.string().optional(),
  type: z.string().min(1, "Product type is required"),
  distB2C: z.boolean().default(false),
  distB2B: z.boolean().default(false),
  distB2B2C: z.boolean().default(false),
});

type FormValues = z.infer<typeof schema>;

function toUpperSnakeCase(value: string): string {
  return value
    .trim()
    .toUpperCase()
    .replace(/[^A-Z0-9]+/g, "_")
    .replace(/^_+|_+$/g, "");
}

export default function Step1Identity() {
  const { identity, setIdentity, setStep, setProductId } = useWizardStore();
  const createProduct = useCreateProduct();

  const {
    register,
    handleSubmit,
    watch,
    setValue,
    formState: { errors },
  } = useForm<FormValues>({
    resolver: zodResolver(schema),
    defaultValues: {
      name: identity?.name ?? "",
      code: identity?.code ?? "",
      ojkName: identity?.ojkName ?? "",
      type: identity?.type ?? "MOTOR",
      distB2C: false,
      distB2B: false,
      distB2B2C: false,
    },
  });

  const watchedName = watch("name");
  const watchedCode = watch("code");

  // Auto-generate code from name when code field is empty
  useEffect(() => {
    if (!watchedCode && watchedName) {
      setValue("code", toUpperSnakeCase(watchedName), { shouldValidate: false });
    }
  }, [watchedName, watchedCode, setValue]);

  const onSubmit = async (data: FormValues) => {
    const identityData: IdentityFormData = {
      name: data.name,
      code: data.code,
      ojkName: data.ojkName ?? "",
      type: data.type,
      target: [
        data.distB2C && "B2C",
        data.distB2B && "B2B",
        data.distB2B2C && "B2B2C",
      ]
        .filter(Boolean)
        .join(","),
    };

    try {
      const result = await createProduct.mutateAsync({
        ...identityData,
        distribution: {
          b2c: data.distB2C,
          b2b: data.distB2B,
          b2b2c: data.distB2B2C,
        },
      });
      const productId = result?.id ?? result?.productId ?? ("DRAFT-" + Date.now());
      setProductId(productId);
      setIdentity(identityData);
      setStep(2);
    } catch {
      // Error is surfaced via createProduct.error
    }
  };

  const errorMessage =
    createProduct.error instanceof Error
      ? createProduct.error.message
      : createProduct.isError
      ? "Failed to create product. Please try again."
      : null;

  return (
    <form onSubmit={handleSubmit(onSubmit)} className="space-y-6">
      {/* Product Identity */}
      <Card className="p-6">
        <h3 className="text-base font-semibold text-axa-text mb-4">Product Identity</h3>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          {/* Product Name */}
          <div className="space-y-1">
            <Label htmlFor="name" className="text-axa-text">
              Product Name <span className="text-axa-red">*</span>
            </Label>
            <Input
              id="name"
              placeholder="e.g. AXA Motor Comprehensive"
              {...register("name")}
              className={errors.name ? "border-axa-error" : ""}
            />
            {errors.name && (
              <p className="text-xs text-axa-error">{errors.name.message}</p>
            )}
          </div>

          {/* Product Code */}
          <div className="space-y-1">
            <Label htmlFor="code" className="text-axa-text">
              Product Code <span className="text-axa-red">*</span>
            </Label>
            <Input
              id="code"
              placeholder="Auto-generated from name"
              {...register("code")}
              className={errors.code ? "border-axa-error" : ""}
              onChange={(e) =>
                setValue("code", e.target.value.toUpperCase().replace(/[^A-Z0-9_]/g, ""), {
                  shouldValidate: true,
                })
              }
            />
            {errors.code && (
              <p className="text-xs text-axa-error">{errors.code.message}</p>
            )}
            <p className="text-xs text-axa-muted">UPPER_SNAKE_CASE, auto-derived from name</p>
          </div>

          {/* OJK Name */}
          <div className="space-y-1 md:col-span-2">
            <Label htmlFor="ojkName" className="text-axa-text">
              OJK Name
            </Label>
            <Input
              id="ojkName"
              placeholder="Official OJK product name"
              {...register("ojkName")}
            />
          </div>
        </div>
      </Card>

      {/* Product Type */}
      <Card className="p-6">
        <h3 className="text-base font-semibold text-axa-text mb-4">Product Type</h3>
        <div className="space-y-1">
          <Label htmlFor="type" className="text-axa-text">
            Insurance Type <span className="text-axa-red">*</span>
          </Label>
          <select
            id="type"
            {...register("type")}
            className="flex h-10 w-full max-w-xs rounded-md border border-axa-border bg-white px-3 py-2 text-sm text-axa-text focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring"
          >
            {PRODUCT_TYPES.map((t) => (
              <option key={t.value} value={t.value}>
                {t.label}
              </option>
            ))}
          </select>
          {errors.type && (
            <p className="text-xs text-axa-error">{errors.type.message}</p>
          )}
        </div>
      </Card>

      {/* Distribution Channels */}
      <Card className="p-6">
        <h3 className="text-base font-semibold text-axa-text mb-4">Distribution Channels</h3>
        <div className="flex flex-wrap gap-6">
          {(
            [
              { field: "distB2C", label: "B2C", desc: "Direct to consumer" },
              { field: "distB2B", label: "B2B", desc: "Business to business" },
              { field: "distB2B2C", label: "B2B2C", desc: "Business to business to consumer" },
            ] as const
          ).map(({ field, label, desc }) => (
            <label
              key={field}
              className="flex items-start gap-3 cursor-pointer group"
            >
              <input
                type="checkbox"
                {...register(field)}
                className="mt-0.5 h-4 w-4 rounded border-axa-border text-axa-blue accent-axa-blue cursor-pointer"
              />
              <span>
                <span className="text-sm font-medium text-axa-text group-hover:text-axa-blue transition-colors">
                  {label}
                </span>
                <span className="block text-xs text-axa-muted">{desc}</span>
              </span>
            </label>
          ))}
        </div>
      </Card>

      {/* Error Banner */}
      {errorMessage && (
        <div className="flex items-center gap-2 rounded-md border border-axa-error-light bg-axa-error-light px-4 py-3 text-sm text-axa-error">
          <AlertCircle size={16} className="shrink-0" />
          {errorMessage}
        </div>
      )}

      {/* Navigation */}
      <div className="flex justify-end pt-2">
        <Button type="submit" disabled={createProduct.isPending}>
          {createProduct.isPending ? (
            <>
              <Loader2 size={16} className="mr-2 animate-spin" />
              Creating…
            </>
          ) : (
            "Next Step"
          )}
        </Button>
      </div>
    </form>
  );
}

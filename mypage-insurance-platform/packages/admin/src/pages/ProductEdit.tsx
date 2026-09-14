import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { AlertTriangle, ArrowLeft, Settings, FileText, DollarSign, Layout, Save } from 'lucide-react';
import { useProduct } from '../hooks/useProducts';
import { productsApi } from '../lib/api';
import { Card, CardContent, Button, Input, Label } from '../components/ui';

// ─── Unified Liferay-Style Edit Form ──────────────────────────────────────────

interface LiferayEditFormValues {
  name: string;
  ojkName: string;
  code: string;
  type: string;
  commissionPercent: number;
  stampDutyIDR: number;
  stampDutyUSD: number;
  policyCostIDR: number;
  policyCostUSD: number;
  gracePeriod: number;
  b2c: boolean;
  b2b: boolean;
  b2b2c: boolean;
  pepEnable: boolean;
  policyWordingUrl: string;
}

export default function ProductEdit() {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const { data: product, isLoading, isError } = useProduct(id!);

  const [activeCategory, setActiveCategory] = useState('configuration');
  const [activeTab, setActiveTab] = useState('general');
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState('');

  const { register, handleSubmit, reset, formState: { errors } } = useForm<LiferayEditFormValues>();

  useEffect(() => {
    if (product) {
      reset({
        name:              product.name ?? '',
        ojkName:           product.ojkName ?? '',
        code:              product.code ?? '',
        type:              product.type ?? '',
        commissionPercent: product.config?.commissionPercent ?? 0,
        stampDutyIDR:      product.config?.stampDutyIDR ?? 0,
        stampDutyUSD:      product.config?.stampDutyUSD ?? 0,
        policyCostIDR:     product.config?.policyCostIDR ?? 0,
        policyCostUSD:     product.config?.policyCostUSD ?? 0,
        b2c:               product.target?.includes('B2C') ?? false,
        b2b:               product.target?.includes('B2B') ?? false,
        b2b2c:             product.target?.includes('B2B2C') ?? false,
        pepEnable:         product.config?.pepEnabled ?? false,
        gracePeriod:       product.config?.gracePeriod ?? 0,
        policyWordingUrl:  product.config?.policyWordingUrl ?? '',
      });
    }
  }, [product, reset]);

  const onSubmit = async (data: LiferayEditFormValues) => {
    setSaving(true);
    setError('');
    try {
      const target = [data.b2c && 'B2C', data.b2b && 'B2B', data.b2b2c && 'B2B2C'].filter(Boolean).join(',');
      await productsApi.update(product!.id, {
        name:    data.name,
        ojkName: data.ojkName,
        code:    data.code,
        type:    data.type,
        target,
        config: {
          commissionPercent: Number(data.commissionPercent),
          stampDutyIDR:      Number(data.stampDutyIDR),
          stampDutyUSD:      Number(data.stampDutyUSD),
          policyCostIDR:     Number(data.policyCostIDR),
          policyCostUSD:     Number(data.policyCostUSD),
          gracePeriod:       Number(data.gracePeriod),
          pepEnabled:        data.pepEnable,
          policyWordingUrl:  data.policyWordingUrl,
        },
      });
      // Optional: show toast success
      navigate('/products');
    } catch (err: any) {
      setError(err?.response?.data?.message ?? 'Failed to save changes.');
    } finally {
      setSaving(false);
    }
  };

  if (isLoading) {
    return (
      <div className="flex items-center justify-center py-24">
        <div className="w-10 h-10 border-4 border-axa-blue border-t-transparent rounded-full animate-spin" />
      </div>
    );
  }

  if (isError || !product) {
    return (
      <div className="max-w-lg mx-auto py-12 text-center space-y-4">
        <AlertTriangle className="w-12 h-12 text-axa-error mx-auto" />
        <h2 className="text-xl font-bold text-axa-text">Product Not Found</h2>
        <Button variant="outline" onClick={() => navigate('/products')}>
          <ArrowLeft className="w-4 h-4 mr-1" /> Back to Products
        </Button>
      </div>
    );
  }

  // --- Liferay-Mimic Menu Structure ---
  const MENU_STRUCTURE = [
    {
      group: "GENERAL",
      items: [
        { id: "configuration", label: "Configuration", icon: <Settings className="w-4 h-4 mr-2" />, tabs: [{ id: "general", label: "General" }, { id: "admin", label: "Admin Config" }] },
        { id: "form_builder", label: "Form Fields", icon: <Layout className="w-4 h-4 mr-2" />, tabs: [{ id: "schema", label: "Field Schema" }] },
      ]
    },
    {
      group: "BENEFIT",
      items: [
        { id: "plans", label: "Benefit Type", icon: <FileText className="w-4 h-4 mr-2" />, tabs: [{ id: "plan_setup", label: "Benefit Types" }] },
        { id: "rates", label: "Class Rate", icon: <DollarSign className="w-4 h-4 mr-2" />, tabs: [{ id: "rate_table", label: "Premium Rates" }] },
      ]
    }
  ];

  const currentCategoryObj = MENU_STRUCTURE.flatMap(g => g.items).find(i => i.id === activeCategory);
  
  return (
    <form onSubmit={handleSubmit(onSubmit)} className="flex h-[calc(100vh-64px)] -mx-6 -my-6 bg-axa-surface">
      {/* Left Sidebar Mimic */}
      <div className="w-64 bg-white border-r border-axa-border overflow-y-auto hidden md:block">
        <div className="p-4 border-b border-axa-border flex items-center text-sm font-semibold text-axa-text">
           <FileText className="w-4 h-4 mr-2 text-axa-blue" />
           {product.name}
        </div>
        <div className="py-2">
          {MENU_STRUCTURE.map((group, idx) => (
            <div key={idx} className="mb-4">
              <div className="px-4 py-2 text-xs font-bold text-axa-muted uppercase tracking-wider">
                {group.group}
              </div>
              <ul className="space-y-1">
                {group.items.map((item) => (
                  <li key={item.id}>
                    <button
                      type="button"
                      onClick={() => {
                        setActiveCategory(item.id);
                        setActiveTab(item.tabs[0].id);
                      }}
                      className={`w-full flex items-center px-4 py-2 text-sm text-left transition-colors ${
                        activeCategory === item.id 
                          ? "bg-axa-surface text-axa-blue font-medium border-r-4 border-axa-blue" 
                          : "text-axa-text-secondary hover:bg-axa-surface"
                      }`}
                    >
                      {item.icon}
                      {item.label}
                    </button>
                  </li>
                ))}
              </ul>
            </div>
          ))}
        </div>
      </div>

      {/* Main Content Area */}
      <div className="flex-1 flex flex-col min-w-0 overflow-y-auto p-6 bg-white m-4 shadow-card rounded-lg border border-axa-border">
        
        {/* Header matching Liferay format */}
        <div className="mb-6 border-b border-axa-border pb-2 flex justify-between items-center">
          <h2 className="text-xl font-semibold text-axa-text flex items-center">
            {currentCategoryObj?.icon}
            {currentCategoryObj?.label}
          </h2>
          <Button type="submit" disabled={saving} className="bg-axa-blue text-white hover:shadow-hover">
            <Save className="w-4 h-4 mr-2" />
            {saving ? 'Saving...' : 'Save Configuration'}
          </Button>
        </div>

        {error && (
          <div className="mb-4 p-3 bg-axa-error-light border border-axa-error rounded-md text-sm text-axa-error">{error}</div>
        )}

        {/* Liferay-style Dark Tabs */}
        {currentCategoryObj && currentCategoryObj.tabs.length > 0 && (
          <div className="flex bg-axa-dark text-sm rounded-t-md overflow-hidden mb-6">
            {currentCategoryObj.tabs.map((tab) => (
              <button
                type="button"
                key={tab.id}
                onClick={() => setActiveTab(tab.id)}
                className={`px-6 py-2.5 font-medium transition-colors ${
                  activeTab === tab.id
                    ? "bg-axa-dark text-white border-b-2 border-axa-accent"
                    : "text-axa-light hover:text-white bg-transparent"
                }`}
              >
                {tab.label}
              </button>
            ))}
          </div>
        )}

        {/* Dynamic Tab Content based on Liferay structure */}
        <div className="max-w-4xl space-y-6">
           
           {/* CONFIGURATION > GENERAL TAB */}
           {activeCategory === 'configuration' && activeTab === 'general' && (
             <div className="animate-in fade-in slide-in-from-bottom-2 duration-300">
               <Card>
                 <CardContent className="pt-6">
                   <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Product Name <span className="text-axa-error">*</span></Label>
                       <Input className="transition-shadow hover:shadow-sm" {...register('name', { required: true })} />
                       {errors.name && <p className="text-xs text-axa-error mt-1">Required</p>}
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">OJK Name <span className="text-axa-error">*</span></Label>
                       <Input className="transition-shadow hover:shadow-sm" {...register('ojkName', { required: true })} />
                       {errors.ojkName && <p className="text-xs text-axa-error mt-1">Required</p>}
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Product Code <span className="text-axa-error">*</span></Label>
                       <Input className="bg-axa-surface/50 text-axa-muted" readOnly {...register('code')} />
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Default Agent Commission</Label>
                       <Input type="number" step="0.1" className="transition-shadow hover:shadow-sm" {...register('commissionPercent')} />
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Stampduty IDR</Label>
                       <Input type="number" className="transition-shadow hover:shadow-sm" {...register('stampDutyIDR')} />
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Stampduty USD</Label>
                       <Input type="number" className="transition-shadow hover:shadow-sm" {...register('stampDutyUSD')} />
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Policy Cost IDR</Label>
                       <Input type="number" className="transition-shadow hover:shadow-sm" {...register('policyCostIDR')} />
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Policy Cost USD</Label>
                       <Input type="number" className="transition-shadow hover:shadow-sm" {...register('policyCostUSD')} />
                     </div>
                   </div>
                 </CardContent>
               </Card>
             </div>
           )}

           {/* CONFIGURATION > ADMIN CONFIG TAB */}
           {activeCategory === 'configuration' && activeTab === 'admin' && (
             <div className="animate-in fade-in slide-in-from-bottom-2 duration-300">
               <Card>
                 <CardContent className="pt-6 space-y-6">
                   <div>
                     <Label className="text-axa-text-secondary font-normal mb-2 block">Distribution Channels</Label>
                     <div className="flex gap-6">
                       {(['b2c', 'b2b', 'b2b2c'] as const).map(ch => (
                         <label key={ch} className="flex items-center gap-2 text-sm cursor-pointer text-axa-text hover:text-axa-blue transition-colors">
                           <input type="checkbox" className="w-4 h-4 accent-axa-blue rounded transition-transform hover:scale-110 cursor-pointer" {...register(ch)} />
                           {ch.toUpperCase()}
                         </label>
                       ))}
                     </div>
                   </div>
                   <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-1 block">Grace Period (Days)</Label>
                       <Input type="number" className="transition-shadow hover:shadow-sm" {...register('gracePeriod')} />
                     </div>
                     <div>
                       <Label className="text-axa-text-secondary font-normal mb-2 block">Compliance</Label>
                       <label className="flex items-center gap-2 text-sm cursor-pointer text-axa-text h-10 hover:text-axa-blue transition-colors">
                         <input type="checkbox" className="w-4 h-4 accent-axa-blue rounded transition-transform hover:scale-110 cursor-pointer" {...register('pepEnable')} />
                         Enable PEP Screening
                       </label>
                     </div>
                   </div>
                   <div>
                     <Label className="text-axa-text-secondary font-normal mb-1 block">Policy Wording URL</Label>
                     <Input type="text" className="transition-shadow hover:shadow-sm" {...register('policyWordingUrl')} />
                   </div>
                 </CardContent>
               </Card>
             </div>
           )}
           
           {/* Placeholder for other tabs */}
           {activeCategory === 'plans' && (
             <div className="p-8 text-center text-axa-muted border-2 border-dashed border-axa-border rounded-md bg-axa-surface">
                Benefit Type configuration will be loaded from Node.js schema.
             </div>
           )}
           
           {activeCategory === 'rates' && (
             <div className="p-8 text-center text-axa-muted border-2 border-dashed border-axa-border rounded-md bg-axa-surface">
                Premium Rate tables will be loaded from Node.js schema.
             </div>
           )}

           {activeCategory === 'form_builder' && (
             <div className="p-8 text-center text-axa-muted border-2 border-dashed border-axa-border rounded-md bg-axa-surface">
                Dynamic Form Fields will be mapped here.
             </div>
           )}

        </div>
      </div>
    </form>
  );
}

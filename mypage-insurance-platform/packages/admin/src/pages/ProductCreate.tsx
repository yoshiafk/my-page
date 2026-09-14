import { useEffect, useState } from 'react';
import { useWizardStore } from '../stores/wizard.store';
import MultiStepWizard from '../components/MultiStepWizard';
import Step1Identity from '../features/product-wizard/Step1Identity';
import Step2Plans from '../features/product-wizard/Step2Plans';
import Step3Rates from '../features/product-wizard/Step3Rates';
import Step4FormBuilder from '../features/product-wizard/Step4FormBuilder';
import Step5AdminConfig from '../features/product-wizard/Step5AdminConfig';
import Step6Preview from '../features/product-wizard/Step6Preview';
import { Button } from '../components/ui';
import { FilePlus, Copy } from 'lucide-react';

const STEPS = [
  { id: 1, label: 'Identity' },
  { id: 2, label: 'Plans & Benefits' },
  { id: 3, label: 'Rate Table' },
  { id: 4, label: 'Form Builder' },
  { id: 5, label: 'Admin Config' },
  { id: 6, label: 'Review & Publish' },
];

export default function ProductCreate() {
  const { currentStep, reset, setIdentity, setPlans, setRateTable, setFormSchema, setAdminConfig } = useWizardStore();
  const [hasStarted, setHasStarted] = useState(false);

  // Reset wizard state when entering the Create page
  useEffect(() => {
    reset();
    setHasStarted(false);
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const startBlank = () => {
    setHasStarted(true);
  };

  const startFromTemplate = () => {
    // Pre-fill the store with a real-world example (e.g., SmartTravel)
    setIdentity({
      name: 'SmartTravel International',
      code: 'SMARTTRAVEL_INTL',
      ojkName: 'Asuransi Perjalanan Luar Negeri',
      isB2C: true,
      isB2B: false,
      isB2B2C: true,
    } as any);
    
    setPlans([
      { name: 'Asia', tier: 'Basic', description: 'Coverage for Asian countries only', benefits: [
        { id: 'b1', name: 'Medical Expenses', value: '1000000', unit: 'IDR', highlight: true, sortOrder: 0 }
      ] },
      { name: 'Worldwide', tier: 'Gold', description: 'Global coverage excluding USA/Canada', benefits: [
        { id: 'b2', name: 'Medical Expenses', value: '5000000', unit: 'IDR', highlight: true, sortOrder: 0 }
      ] }
    ] as any);

    setRateTable({
      variables: [
        { name: 'Region', options: ['Asia', 'Worldwide'] },
        { name: 'Trip Duration (Days)', options: ['1-4', '5-8', '9-31'] }
      ],
      matrix: [
        { combo: { 'Region': 'Asia', 'Trip Duration (Days)': '1-4' }, rate: 50000 },
        { combo: { 'Region': 'Asia', 'Trip Duration (Days)': '5-8' }, rate: 90000 },
        { combo: { 'Region': 'Worldwide', 'Trip Duration (Days)': '1-4' }, rate: 120000 },
      ]
    });

    setFormSchema({
      steps: [
        {
          id: 'step_1',
          label: 'Traveler Details',
          fields: [
            { id: 'f1', type: 'text', label: 'Full Name', required: true, source: '' },
            { id: 'f2', type: 'date', label: 'Departure Date', required: true, source: '' }
          ]
        }
      ]
    } as any);

    setAdminConfig({
      stampDutyIDR: 10000,
      stampDutyUSD: 0,
      policyCostIDR: 20000,
      policyCostUSD: 0,
      commission: 15,
      gracePeriod: 0,
      pepEnabled: true,
    } as any);

    setHasStarted(true);
  };

  if (!hasStarted) {
    return (
      <div className="max-w-4xl mx-auto py-12">
        <h1 className="text-2xl font-bold text-axa-text text-center mb-2">Create New Product</h1>
        <p className="text-axa-muted text-center mb-10">How would you like to start building your new insurance product?</p>
        
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <div 
            onClick={startBlank}
            className="border-2 border-axa-border rounded-xl p-8 bg-white hover:border-axa-blue hover:shadow-card cursor-pointer transition-all flex flex-col items-center text-center group"
          >
            <div className="w-16 h-16 rounded-full bg-axa-light flex items-center justify-center mb-6 group-hover:bg-axa-blue group-hover:text-white transition-colors text-axa-blue">
              <FilePlus size={32} />
            </div>
            <h3 className="text-xl font-semibold text-axa-text mb-2">Start from Blank</h3>
            <p className="text-sm text-axa-muted mb-6">Create a new product from scratch. You will manually define all plans, rates, and forms.</p>
            <Button variant="outline" className="mt-auto w-full group-hover:bg-axa-blue group-hover:text-white">Select Blank</Button>
          </div>

          <div 
            onClick={startFromTemplate}
            className="border-2 border-axa-border rounded-xl p-8 bg-white hover:border-axa-accent hover:shadow-card cursor-pointer transition-all flex flex-col items-center text-center group relative overflow-hidden"
          >
            <div className="absolute top-0 right-0 bg-axa-success-light text-axa-success text-xs font-bold px-3 py-1 rounded-bl-lg">RECOMMENDED</div>
            <div className="w-16 h-16 rounded-full bg-axa-info flex items-center justify-center mb-6 group-hover:bg-axa-accent group-hover:text-white transition-colors text-axa-accent">
              <Copy size={32} />
            </div>
            <h3 className="text-xl font-semibold text-axa-text mb-2">SmartTravel Template</h3>
            <p className="text-sm text-axa-muted mb-6">Pre-loads the wizard with plans, pricing matrices, and form schemas based on Liferay's SmartTravel product.</p>
            <Button className="mt-auto w-full bg-axa-accent group-hover:bg-axa-blue">Use Template</Button>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="max-w-5xl mx-auto py-6">
      <h1 className="text-2xl font-bold text-axa-text mb-6">Create New Product</h1>
      <MultiStepWizard steps={STEPS} currentStep={currentStep}>
        {currentStep === 1 && <Step1Identity />}
        {currentStep === 2 && <Step2Plans />}
        {currentStep === 3 && <Step3Rates />}
        {currentStep === 4 && <Step4FormBuilder />}
        {currentStep === 5 && <Step5AdminConfig />}
        {currentStep === 6 && <Step6Preview />}
      </MultiStepWizard>
    </div>
  );
}

import React from 'react';
import { Check } from 'lucide-react';
import { cn } from '../lib/utils';

interface Step { id: number; label: string; }
interface WizardProps { steps: Step[]; currentStep: number; children: React.ReactNode; }

export default function MultiStepWizard({ steps, currentStep, children }: WizardProps) {
  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between mb-8">
        {steps.map((step, index) => {
          const isCompleted = step.id < currentStep;
          const isCurrent = step.id === currentStep;
          return (
            <div key={step.id} className="flex items-center relative flex-1 last:flex-none">
              <div className="flex flex-col items-center">
                <div className={cn("w-8 h-8 rounded-full flex items-center justify-center border-2 text-sm font-semibold z-10 bg-white",
                  isCompleted ? "border-axa-blue bg-axa-blue text-white" : isCurrent ? "border-axa-blue text-axa-blue" : "border-axa-border text-axa-muted"
                )}>
                  {isCompleted ? <Check className="w-4 h-4" /> : step.id}
                </div>
                <span className={cn("absolute top-10 text-xs font-medium whitespace-nowrap", isCurrent || isCompleted ? "text-axa-text" : "text-axa-muted")}>{step.label}</span>
              </div>
              {index < steps.length - 1 && (
                <div className={cn("h-0.5 flex-1 mx-2", isCompleted ? "bg-axa-blue" : "bg-axa-border")} />
              )}
            </div>
          );
        })}
      </div>
      <div className="bg-white rounded-lg shadow-card border border-axa-border p-6 mt-12">
        {children}
      </div>
    </div>
  );
}

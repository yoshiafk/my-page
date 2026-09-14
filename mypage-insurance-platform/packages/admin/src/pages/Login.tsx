import { Button, Card, CardContent } from '../components/ui';

export default function Login() {
  const handleLogin = () => {
    window.location.href = '/auth/login';
  };

  return (
    <div className="min-h-screen bg-axa-surface flex items-center justify-center p-4 relative overflow-hidden font-sans">
      
      <Card className="w-full max-w-md relative z-10 shadow-2xl border-axa-border/50 animate-in fade-in zoom-in-95 duration-500">
        <CardContent className="p-10 flex flex-col items-center text-center space-y-8">
          
          <div className="space-y-4 w-full flex flex-col items-center">
            {/* Official AXA Logo */}
            <img 
              src="https://upload.wikimedia.org/wikipedia/commons/9/94/AXA_Logo.svg" 
              alt="AXA Logo" 
              className="h-16 w-auto"
            />
            
            <h2 className="text-xl font-semibold text-axa-text border-b border-axa-border/50 pb-4 w-full mt-6">
              Product Wizard
            </h2>
            <p className="text-sm text-axa-muted pt-2">
              Internal portal for AXA product management.
            </p>
          </div>
          
          <div className="w-full space-y-4">
            <Button onClick={handleLogin} className="w-full h-12 text-base font-semibold shadow-sm transition-transform hover:scale-[1.02]">
              Login with OneAccount
            </Button>
            <p className="text-xs text-axa-muted">
              Secure Single Sign-On
            </p>
          </div>
          
        </CardContent>
      </Card>
    </div>
  );
}

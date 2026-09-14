import { Outlet, Link, useLocation } from 'react-router-dom';
import { LayoutDashboard, Package, PlusCircle, LogOut } from 'lucide-react';
import { useAuthStore } from '../stores/auth.store';
import { cn } from '../lib/utils';

export default function AppLayout() {
  const { user, logout } = useAuthStore();
  const location = useLocation();

  const navItems = [
    { name: 'Dashboard', href: '/', icon: LayoutDashboard },
    { name: 'Products', href: '/products', icon: Package },
    { name: 'Add Product', href: '/products/new', icon: PlusCircle },
  ];

  return (
    <div className="flex h-screen bg-axa-surface overflow-hidden">
      <div className="w-64 bg-axa-blue text-white flex flex-col">
        <div className="p-6">
          <h1 className="text-2xl font-bold tracking-tight">AXA</h1>
          <p className="text-sm opacity-80">Product Wizard</p>
        </div>
        <nav className="flex-1 px-4 space-y-2">
          {navItems.map((item) => (
            <Link
              key={item.name}
              to={item.href}
              className={cn("flex items-center gap-3 px-3 py-2 rounded-md transition-colors",
                location.pathname === item.href ? "bg-white/10" : "hover:bg-white/5"
              )}
            >
              <item.icon className="w-5 h-5" />
              {item.name}
            </Link>
          ))}
        </nav>
      </div>
      <div className="flex-1 flex flex-col min-w-0">
        <header className="h-16 bg-white border-b border-axa-border flex items-center justify-between px-6 shadow-sm z-10">
          <div className="font-semibold text-axa-text">Admin Portal</div>
          <div className="flex items-center gap-4">
            <span className="text-sm text-axa-muted">{user?.name || 'Admin User'}</span>
            <button onClick={logout} className="text-axa-muted hover:text-axa-red transition-colors">
              <LogOut className="w-5 h-5" />
            </button>
          </div>
        </header>
        <main className="flex-1 overflow-auto p-6 bg-axa-surface/50">
          <div className="animate-in fade-in slide-in-from-bottom-4 duration-500 ease-out fill-mode-both">
            <Outlet />
          </div>
        </main>
      </div>
    </div>
  );
}

import { Link } from 'react-router-dom';
import { useQuery } from '@tanstack/react-query';
import { PackagePlus, LayoutDashboard, Layers, Globe } from 'lucide-react';
import { Button, Card, CardHeader, CardTitle, CardContent, Badge, Table, TableHeader, TableRow, TableHead, TableBody, TableCell } from '../components/ui';
import { productsApi } from '../lib/api';

interface Product {
  id: string;
  name: string;
  code: string;
  status: string;
  source: string;
  updatedAt?: string;
  createdAt?: string;
}

function StatCard({ label, value, icon }: { label: string; value: number; icon: React.ReactNode }) {
  return (
    <Card>
      <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
        <CardTitle className="text-sm font-medium text-axa-muted">{label}</CardTitle>
        <div className="p-2 bg-axa-light rounded-lg text-axa-blue">
          {icon}
        </div>
      </CardHeader>
      <CardContent>
        <div className="text-2xl font-bold text-axa-blue">{value}</div>
      </CardContent>
    </Card>
  );
}

function statusBadgeVariant(status: string): 'default' | 'success' | 'warning' {
  const s = status?.toLowerCase();
  if (s === 'active') return 'success';
  if (s === 'draft')  return 'warning';
  return 'default';
}

export default function Dashboard() {
  const { data: products, isLoading } = useQuery<Product[]>({
    queryKey: ['products'],
    queryFn: () => productsApi.list(),
  });

  const all      = products ?? [];
  const active   = all.filter(p => p.status?.toLowerCase() === 'active').length;
  const drafts   = all.filter(p => p.status?.toLowerCase() === 'draft').length;
  const liferay  = all.filter(p => p.source?.toLowerCase() === 'liferay').length;
  const total    = all.length;

  const recent = [...all]
    .sort((a, b) => {
      const da = new Date(a.updatedAt ?? a.createdAt ?? 0).getTime();
      const db = new Date(b.updatedAt ?? b.createdAt ?? 0).getTime();
      return db - da;
    })
    .slice(0, 5);

  return (
    <div className="flex flex-col gap-6">
      {/* Header */}
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-bold text-axa-text">Dashboard</h1>
        <Link to="/products/new">
          <Button className="flex items-center gap-2">
            <PackagePlus className="w-4 h-4" />
            Add New Product
          </Button>
        </Link>
      </div>

      {/* Stats */}
      {isLoading ? (
        <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
          {[...Array(4)].map((_, i) => (
            <Card key={i} className="animate-pulse">
              <CardHeader className="space-y-0 pb-2"><div className="h-4 w-28 bg-axa-surface rounded" /></CardHeader>
              <CardContent><div className="h-8 w-16 bg-axa-surface rounded" /></CardContent>
            </Card>
          ))}
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
          <StatCard label="Total Active Products" value={active}  icon={<Layers className="w-4 h-4" />} />
          <StatCard label="Drafts in Progress"    value={drafts}  icon={<LayoutDashboard className="w-4 h-4" />} />
          <StatCard label="Liferay Products"      value={liferay} icon={<Globe className="w-4 h-4" />} />
          <StatCard label="Total Products"        value={total}   icon={<PackagePlus className="w-4 h-4" />} />
        </div>
      )}

      {/* Recent Products */}
      <Card>
        <CardHeader className="flex flex-row items-center justify-between border-b border-axa-border px-6 py-4">
          <CardTitle className="text-lg">Recent Products</CardTitle>
          <Link to="/products" className="text-sm font-medium text-axa-blue hover:underline">View all</Link>
        </CardHeader>
        
        {isLoading ? (
          <div className="flex items-center justify-center py-12">
            <div className="w-8 h-8 border-4 border-axa-blue border-t-transparent rounded-full animate-spin" />
          </div>
        ) : recent.length === 0 ? (
          <CardContent className="flex flex-col items-center justify-center py-10">
            <p className="text-axa-muted text-sm mb-4">No products yet.</p>
            <Link to="/products/new">
              <Button variant="outline">Create your first product</Button>
            </Link>
          </CardContent>
        ) : (
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Name</TableHead>
                <TableHead>Code</TableHead>
                <TableHead>Status</TableHead>
                <TableHead>Source</TableHead>
                <TableHead className="text-right">Actions</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {recent.map(p => (
                <TableRow key={p.id}>
                  <TableCell className="font-medium">{p.name}</TableCell>
                  <TableCell className="text-axa-muted font-mono text-xs">{p.code}</TableCell>
                  <TableCell>
                    <Badge variant={statusBadgeVariant(p.status)}>
                      {p.status?.toLowerCase()}
                    </Badge>
                  </TableCell>
                  <TableCell>
                    <Badge>{p.source?.toLowerCase()}</Badge>
                  </TableCell>
                  <TableCell className="text-right">
                    <Link to={`/products/${p.id}`}>
                      <Button variant="outline" className="h-8 text-xs px-3">Edit</Button>
                    </Link>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        )}
      </Card>
    </div>
  );
}

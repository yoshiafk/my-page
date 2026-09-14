import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Search, Plus } from 'lucide-react';
import { Button, Input, Card, CardContent, Badge, Table, TableHeader, TableRow, TableHead, TableBody, TableCell } from '../components/ui';
import { useProducts, usePublishProduct } from '../hooks/useProducts';

function statusVariant(status: string): 'default' | 'success' | 'warning' {
  const s = status?.toLowerCase();
  if (s === 'active')   return 'success';
  if (s === 'draft')    return 'warning';
  return 'default';
}

export default function ProductList() {
  const [search, setSearch]         = useState('');
  const [debouncedSearch, setDebounced] = useState('');
  const [source, setSource]         = useState('');
  const [status, setStatus]         = useState('');

  // 300ms debounce
  useEffect(() => {
    const t = setTimeout(() => setDebounced(search), 300);
    return () => clearTimeout(t);
  }, [search]);

  const filters: Record<string, string> = {};
  if (debouncedSearch) filters.search = debouncedSearch;
  if (source)          filters.source = source;
  if (status)          filters.status = status;

  const { data, isLoading } = useProducts(Object.keys(filters).length ? filters : undefined);
  const publishMutation = usePublishProduct();

  const products: any[] = data ?? [];

  const handlePublish = async (id: string, name: string) => {
    if (!window.confirm(`Publish "${name}"? This will make it live for customers.`)) return;
    try {
      await publishMutation.mutateAsync(id);
    } catch {
      alert('Failed to publish product. Please try again.');
    }
  };

  const selectClass = "border border-axa-border rounded-md px-3 h-10 text-sm bg-white text-axa-text focus:outline-none focus:ring-2 focus:ring-axa-blue transition-shadow hover:shadow-sm";

  return (
    <div className="space-y-6">
      {/* Header */}
      <div className="flex justify-between items-center">
        <h1 className="text-2xl font-bold text-axa-text">Products</h1>
        <Link to="/products/new">
          <Button className="flex items-center gap-2">
            <Plus className="w-4 h-4" /> Add New Product
          </Button>
        </Link>
      </div>

      <Card className="overflow-hidden">
        {/* Filters */}
        <div className="flex flex-wrap gap-3 px-6 py-4 border-b border-axa-border bg-axa-surface/30">
          <div className="relative flex-1 min-w-[200px] max-w-sm">
            <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-axa-muted" />
            <Input
              className="pl-9 transition-shadow hover:shadow-sm"
              placeholder="Search products…"
              value={search}
              onChange={e => setSearch(e.target.value)}
            />
          </div>
          <select
            className={selectClass}
            value={source}
            onChange={e => setSource(e.target.value)}
          >
            <option value="">All Sources</option>
            <option value="platform">Platform</option>
            <option value="liferay">Liferay</option>
          </select>
          <select
            className={selectClass}
            value={status}
            onChange={e => setStatus(e.target.value)}
          >
            <option value="">All Status</option>
            <option value="active">Active</option>
            <option value="draft">Draft</option>
            <option value="inactive">Inactive</option>
          </select>
        </div>

        {/* Table */}
        {isLoading ? (
          <div className="flex items-center justify-center py-16">
            <div className="w-8 h-8 border-4 border-axa-blue border-t-transparent rounded-full animate-spin" />
          </div>
        ) : products.length === 0 ? (
          <CardContent className="flex flex-col items-center justify-center py-16">
            <p className="text-axa-muted text-sm mb-4">No products found matching your filters.</p>
            <Link to="/products/new">
              <Button variant="outline">Create New Product</Button>
            </Link>
          </CardContent>
        ) : (
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Name</TableHead>
                <TableHead>Code</TableHead>
                <TableHead>Type</TableHead>
                <TableHead>Source</TableHead>
                <TableHead>Status</TableHead>
                <TableHead>Updated</TableHead>
                <TableHead className="text-right">Actions</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {products.map((p: any) => {
                const isPlatformDraft =
                  p.source?.toLowerCase() === 'platform' &&
                  p.status?.toLowerCase() === 'draft';

                return (
                  <TableRow key={p.id}>
                    <TableCell className="font-medium text-axa-text">{p.name}</TableCell>
                    <TableCell className="text-axa-muted font-mono text-xs">{p.code}</TableCell>
                    <TableCell className="text-axa-muted">{p.type ?? '—'}</TableCell>
                    <TableCell>
                      <Badge variant={p.source?.toLowerCase() === 'liferay' ? 'warning' : 'default'}>
                        {p.source?.toLowerCase()}
                      </Badge>
                    </TableCell>
                    <TableCell>
                      <Badge variant={statusVariant(p.status)}>
                        {p.status?.toLowerCase()}
                      </Badge>
                    </TableCell>
                    <TableCell className="text-axa-muted text-xs whitespace-nowrap">
                      {p.updatedAt
                        ? new Date(p.updatedAt).toLocaleDateString()
                        : '—'}
                    </TableCell>
                    <TableCell className="text-right">
                      <div className="flex items-center justify-end gap-2">
                        <Link to={`/products/${p.id}`}>
                          <Button variant="outline" className="h-8 text-xs px-3">Edit</Button>
                        </Link>
                        {isPlatformDraft && (
                          <Button
                            className="h-8 text-xs px-3"
                            onClick={() => handlePublish(p.id, p.name)}
                            disabled={publishMutation.isPending}
                          >
                            Publish
                          </Button>
                        )}
                      </div>
                    </TableCell>
                  </TableRow>
                );
              })}
            </TableBody>
          </Table>
        )}
      </Card>
    </div>
  );
}

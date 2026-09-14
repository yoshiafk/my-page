import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AppLayout from './components/AppLayout';
import ProtectedRoute from './components/ProtectedRoute';
import Dashboard from './pages/Dashboard';
import ProductList from './pages/ProductList';
import ProductCreate from './pages/ProductCreate';
import ProductEdit from './pages/ProductEdit';
import Login from './pages/Login';
import AuthCallback from './pages/AuthCallback';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/login/callback" element={<AuthCallback />} />
        <Route element={<ProtectedRoute><AppLayout /></ProtectedRoute>}>
          <Route path="/" element={<Dashboard />} />
          <Route path="/products" element={<ProductList />} />
          <Route path="/products/new" element={<ProductCreate />} />
          <Route path="/products/:id" element={<ProductEdit />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

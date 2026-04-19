import { useAuth } from '../context/AuthContext';

/**
 * Hook para verificar permisos según el rol del usuario.
 * Uso: const { isAdmin, canDelete, canManageEmpleados } = useRole();
 */
export function useRole() {
  const { user } = useAuth();
  const isAdmin = user?.rol === 'ADMIN';

  return {
    isAdmin,
    canCreate: true,          // todos pueden crear
    canEdit:   true,          // todos pueden editar
    canDelete: isAdmin,       // solo ADMIN puede eliminar
    canManageEmpleados: isAdmin, // solo ADMIN ve/gestiona empleados
  };
}

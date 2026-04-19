import axios from 'axios';

const api = axios.create({
  // En producción usa ruta relativa (mismo servidor Spring Boot)
  // En desarrollo usa el proxy de Vite que redirige a localhost:8080
  baseURL: '/api',
  headers: { 'Content-Type': 'application/json' },
});

api.interceptors.request.use(config => {
  const token = sessionStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

api.interceptors.response.use(
  res => res,
  err => {
    console.error('API Error:', err.response?.status, err.config?.url);
    return Promise.reject(err);
  }
);

export default api;

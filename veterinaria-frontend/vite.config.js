import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  build: {
    // El build va directo a static de Spring Boot
    outDir: '../src/main/resources/static',
    emptyOutDir: true,
  },
  server: {
    proxy: {
      // En desarrollo, las peticiones /api van al backend
      '/api': 'http://localhost:8080'
    }
  }
})

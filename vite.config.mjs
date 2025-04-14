import { defineConfig } from 'vite'
import { readdirSync } from 'fs'
import { resolve } from 'path'
import tailwindcss from '@tailwindcss/vite'

//const kotlinOutputDir = resolve(__dirname, './build/compileSync/js/main/developmentExecutable/kotlin')
//
//// Grab all JS files from the Kotlin build output
//const kotlinJsFiles = readdirSync(kotlinOutputDir)
//  .filter(file => file.endsWith('.js'))
//  .map(file => resolve(kotlinOutputDir, file))

const kotlinEntry = resolve(__dirname, '/build/kotlin-webpack/js/developmentExecutable/app.js')

export default defineConfig({
  root: '.', // or wherever your `index.html` lives
  server: {
    port: 5173,
  },
  plugins: [
    tailwindcss(),
  ],
//  publicDir: kotlinOutputDir,
  build: {
    outDir: 'dist',
    rollupOptions: {
      input: ['index.html',kotlinEntry],
    }
  }
})

/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: ["class"],
  content: [
    './index.html',
    './src/**/*.{ts,tsx}'
  ],
  theme: {
    extend: {
      colors: {
        axa: {
          blue: '#00008F',
          dark: '#000067',
          light: '#E6E6F5',
          accent: '#4976BA',
          red: '#FF1721',
          success: '#1CC54E',
          error: '#C91432',
          surface: '#F5F5F5',
          border: '#CCCCCC',
          text: '#333333',
          muted: '#5F5F5F',
        },
        border: "hsl(var(--border))",
        input: "hsl(var(--input))",
        ring: "hsl(var(--ring))",
        background: "hsl(var(--background))",
        foreground: "hsl(var(--foreground))",
      },
      borderRadius: {
        lg: "var(--radius)",
        md: "calc(var(--radius) - 2px)",
        sm: "calc(var(--radius) - 4px)",
        pill: "50px",
      },
      boxShadow: {
        card: "0 2px 12px rgba(0,0,0,0.08)",
        hover: "0 6px 24px rgba(0,0,143,0.15)",
      },
      fontFamily: {
        sans: ["Inter", "sans-serif"],
      },
    },
  },
  plugins: [require("tailwindcss-animate")],
}

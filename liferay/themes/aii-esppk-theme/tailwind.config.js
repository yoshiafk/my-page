/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/**/*.ftl',
    '../../modules/**/*.{jsp,js}',
  ],
theme: {
  extend: {
    boxShadow: {
      'axa-shadow-focus-light': 'inset 5em 5em 5em 5em rgb(255, 255, 255, .1), 0 0 0 .2rem #b3b3b3',
      'axa-shadow-active-light': 'inset 5em 5em 5em 5em rgba(255, 255, 255, .2)',
      'axa-shadow-hover-light': 'inset 5em 5em 5em 5em #ededed',
      'axa-shadow-light': 'inset 0 -3px 0 rgba(0, 0, 0, .2)',
      'axa-shadow-click': '0 0 0 .1rem #b3b3b3'
    },
    fontFamily: {
      'publico': ['Publico'],
      'sourcesans': ['SourceSans']
    },
    colors: {
      'axa-blue': {
        100: '#5C5CB7',
        300: '#1F1F9C',
        400: '#00008F'
      },
      'axa-grey': {
        200: '#F0F0F0',
        300: '#E5E5E5',
        400: '#CCCCCC',
        500: '#D9D9D9',
        600: '#757575',
        700: '#999999',
        800: '#343C3D'
      },
      'axa-sienna': {
        200: '#DD7358',
        300: '#D75D3D',
        400: '#D24723', 
        600: '#8A290E'
      },
      'axa-red': {
        'error': '#C91432'
      },
      'axa-ocean': {
        100: '#7698CB',
        200: '#4976BA'
      },
      'axa-black': {
        'modal': '#6D6D6D'
      },
      'axa-green': {
        '500': '#138636'
      },
      'axa-apache': {
        '300': '#6E5C28'
      },
      'axa-teal': {
        '100': '#41949F'
      },
      'axa-slate': {
        '700': '#5F5F5F'
      }
    },
    animation: {
      'vertical_slide': 'vertical_slide 1s ease-out'
    },
    keyframes: {
      'vertical_slide': {
        '0%': { transform: 'translateY(-125%)' },
        '50%': { transform: 'translateY(15%)' },
        '100%': { transform: 'translateY(0)' }
      }
    }
  },
},
variants: {},
plugins: [],
}


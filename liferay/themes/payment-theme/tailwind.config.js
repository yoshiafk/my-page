/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.ftl'],
  theme: {
    extend: {
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
				'axa-bluesky': {
					900: '#274168'
				},
				'axa-grey': {
					200: '#F0F0F0',
					300: '#ECECEC',
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
					300: '#5D5D5D',
					400: '#343C3D',
					'modal': '#6D6D6D'
				},
				'axa-green': {
					500: '#138636'
				},
				'axa-apache': {
					300: '#6E5C28'
				},
				'axa-teal': {
					100: '#41949F'
				},
				'axa-slate': {
					700: '#5F5F5F'
				}
			}
    },
  },
  plugins: [],
}


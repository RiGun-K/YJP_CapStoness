module.exports = {
	env: {
		browser: true,
		es2021: true,
	},
	extends: ['plugin:vue/essential', 'standard'],
	parserOptions: {
		ecmaVersion: 12,
		parser: '@typescript-eslint/parser',
		sourceType: 'module',
	},
	plugins: ['vue', '@typescript-eslint'],
	rules: {
		'vue/multi-word-component-names': 'off',
		'vue/no-multiple-template-root': 0,
		'generator-star-spacing': 'off',
		'no-tabs': 'off',
		'no-mixed-spaces-and-tabs': [0],
		quotes: ['off', 'single'],
		'space-before-function-paren': ['error', 'ignore'],
		// or
		'comma-dangle': ['error', 'always'],
		'space-before-function-paren': [
			'error',
			{
				anonymous: 'ignore',
				named: 'ignore',
				asyncArrow: 'ignore',
			},
		],
		indent: 'off',
	},
};

const vuePlugin = require("esbuild-plugin-vue3")

require('esbuild').build({
    entryPoints: ['./app/main.js'],
    bundle: true,
    outfile: 'src/main/resources/static/index.js',
    plugins: [vuePlugin()],
    define: {
        "process.env.NODE_ENV": JSON.stringify("development"),
    },
});


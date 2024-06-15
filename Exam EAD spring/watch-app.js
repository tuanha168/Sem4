const vuePlugin = require("esbuild-plugin-vue3")
const esbuild = require('esbuild')

const watch = async () => {
    const ctx = await esbuild.context({
        entryPoints: ['./app/main.js'],
        bundle: true,
        outfile: 'src/main/resources/static/index.js',
        plugins: [vuePlugin()],
        define: {
            "process.env.NODE_ENV": JSON.stringify("development"),
        },
    });
    await ctx.watch()
}

watch()

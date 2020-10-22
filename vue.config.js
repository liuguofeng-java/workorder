module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://elm.cangdu.org/v1/',
                // 允许跨域
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}
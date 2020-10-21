module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://musicapi.leanapp.cn/',
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
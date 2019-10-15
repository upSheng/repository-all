module.exports = {

    lintOnSave: false, // 是否开启eslint保存检测, 有效值: true || false || 'error'
    devServer: {

        proxy: {
            // 配置跨域
            '/api': {
                target: 'http://onetu.top:8081/',
                ws: true,
                changOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
};

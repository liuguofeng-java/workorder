import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from './router'

// ajax
import { post, get, patch, put } from './util/http'
Vue.prototype.$post = post;
Vue.prototype.$get = get;
Vue.prototype.$patch = patch;
Vue.prototype.$put = put;

//高德地图
import AMap from 'vue-amap';
Vue.use(AMap);

// 初始化vue-amap
AMap.initAMapApiLoader({
    // 高德key
    key: '8bee6bced477d7984c3cb0ef7732b39c',
    // 插件集合 （插件按需引入）
    plugin: ['AMap.Geolocation', 'AMap.CitySearch']
});

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
    router,
    render: function(h) { return h(App) }
}).$mount('#app')
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

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
    router,
    render: function (h) { return h(App) }
}).$mount('#app')
import Vue from 'vue'
import VueRouter from 'vue-router'
const City = r => require.ensure([], () => r(require('../page/city/City.vue')), 'city')
const Address = r => require.ensure([], () => r(require('../page/address/Address.vue')), 'address')


Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: 'City',
    component: City,
    meta: {
        title: '选择城市'
    },
}, {
    path: '/address/:cityId',
    name: 'Address',
    component: Address,
    meta: {
        title: '选择地址'
    }
}]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
        document.title = to.meta.title
    }
    next()
})

export default router
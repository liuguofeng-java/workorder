import Vue from 'vue'
import VueRouter from 'vue-router'
const Home = r => require.ensure([], () => r(require('../page/home/Home.vue')), 'home')


Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: 'Home',
    component: Home
}, ]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
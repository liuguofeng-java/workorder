import Vue from "vue";
import VueRouter from "vue-router";
let Login = () => import('../views/Login.vue');
let Home = () => import('../views/Home.vue');


let error404 = () => import('../views/404.vue');
// 要告诉 vue 使用 vueRouter
Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: { title: '登录' }
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    meta: { title: '主页' }
  },
  {
    path: '*',
    component: error404,
    meta: { title: '找不到页面' }
  }
]

var router = new VueRouter({
  routes,
  mode: "history"
})

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next();
})

export default router;

import Vue from "vue";
import VueRouter from "vue-router";


// 要告诉 vue 使用 vueRouter
Vue.use(VueRouter);

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  }
]

var router = new VueRouter({
  routes,
  mode: "history"
})
export default router;

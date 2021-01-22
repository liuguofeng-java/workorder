import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import { post, get } from './utils/request'


const app = createApp({})
get('/index').then((res)=>{
  console.log(res);
})
app.config.globalProperties.post = post;
app.config.globalProperties.get = get;

createApp(App).use(store).use(router).mount('#app')

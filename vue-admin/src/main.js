import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


import movie from './components/movie.vue'
import novel from './components/novel.vue'
import webMenu from './components/webMenu.vue'

import login from './components/login.vue'
import main from './components/Main.vue'



Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(ElementUI);
Vue.use(VueAxios, axios)


//添加jwt
axios.defaults.headers.common['Authorization'] = "Bearer " + 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjaHMiLCJleHAiOjE1NzU1NjgwMDF9.jyWRk_44KP0uH4keXbQz5oS3UTejnTTbgw_htj6kJfMFv-OdWnzy-DL5_E-7ZCg5yay93rgO-7ROja1lEcwudg';


const routes = [

    {path: '/login', component: login},

    {
        path: '/', component: main, children: [
            {path: 'movie', component: movie},
            {path: 'novel', component: novel},
            {path: 'webMenu', component: webMenu}]
    },

]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
  mode: 'history',  //h5模式
  routes // (缩写) 相当于 routes: routes
})

new Vue({
  render: h => h(App),
    router
}).$mount('#app')


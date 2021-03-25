import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


import movie from './components/movie.vue'
import homepage from './components/homepage.vue'
import order from "./components/order";
import webMenu from './components/webMenu.vue'

import login from './components/login.vue'
import myMain from './components/myMain.vue'


Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(ElementUI);
Vue.use(VueAxios, axios)


axios.defaults.baseURL='http://1w7255a684.51mypc.cn/'

//添加jwt
//axios.defaults.headers.common['Authorization'] = "Bearer " + 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjaHMiLCJleHAiOjE1NzU1NjgwMDF9.jyWRk_44KP0uH4keXbQz5oS3UTejnTTbgw_htj6kJfMFv-OdWnzy-DL5_E-7ZCg5yay93rgO-7ROja1lEcwudg';


const routes = [

    {path: '/login', component: login},

    {
        path: '/', component: myMain, children: [
            {path: '', component: homepage},
            {path: 'movie/:id', component: movie},
            {path: 'order', component: order},
            {path: 'webMenu', component: webMenu}]
    },

]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
    // mode: 'history',  //h5模式
    routes // (缩写) 相当于 routes: routes
})


//请求拦截
// axios.interceptors.request.use(config => {
//
//     var jwtToken = localStorage.getItem('jwtToken');
//     //设置请求头
//     if (jwtToken != null) {
//         axios.defaults.headers.common['Authorization'] = "Bearer " + jwtToken;
//     } else {
//         router.push('/login');
//     }
//     return config
// }, error => {
//     return Promise.reject(error)
// })


//响应拦截
// axios.interceptors.response.use(response => {
//
//     if(response.status =='000'){
//         console.log(response);
//         debugger;
//         router.push('/login');
//
//     }
//     return response;
//
// }, error => {
//
//     return Promise.reject(error);
// })

//路由拦截
// router.beforeEach((to, from, next) => {
//
//
//     let jwtToken = localStorage.getItem('jwtToken');
//
//     if (jwtToken) {
//         next();
//     } else {
//
//         if (to.path == '/login') {
//             next()
//         } else {
//             next({
//                 path: '/login'
//             });
//         }
//     }
//
//     if (!jwtToken) return next({path: "/login"});
//     next();
// });

new Vue({
    render: h => h(App),
    router
}).$mount('#app')


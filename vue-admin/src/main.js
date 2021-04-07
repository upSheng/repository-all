import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


import homepage from './components/frontend/homepage.vue'
import order from "./components/frontend/order";
import login from './components/admin/login.vue'
import myMain from './components/frontend/myMain.vue'

import adminMain from "./components/admin/adminMain";
import adminOrder from "./components/admin/adminOrder";
import adminHomepage from "./components/admin/adminHomepage";
import adminProduct from "./components/admin/adminProduct";


import {commonInit} from "./assets/js/common.js"


Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(ElementUI);
Vue.use(VueAxios, axios)

axios.defaults.baseURL = 'http://localhost:8080/'


const routes = [

    {path: '/login', component: login},
    {
        path: '/admin', component: adminMain, children: [
            {path: '', component: adminHomepage},
            {path: 'order', component: adminOrder},
            {path: 'product', component: adminProduct},
        ]
    },

    {
        path: '/', component: myMain, children: [
            {path: '', component: homepage},
            {path: 'order', component: order},
        ]
    },

]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
    // mode: 'history',  //h5模式
    routes // (缩写) 相当于 routes: routes
})


//请求拦截
axios.interceptors.request.use(config => {

    const token = localStorage.getItem('token');
    //设置请求头
    if ( token && token != ''){
        config.headers.common['token'] = token;
    }else {
        config.headers.common['token'] = '';
    }
    return config
}, error => {
    return Promise.reject(error)
})

// //响应拦截
axios.interceptors.response.use(response => {

    if(response.data.code ==401){
        router.push('/login');
    }
    return response;

}, error => {

    return Promise.reject(error);
})

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


commonInit();

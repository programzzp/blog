// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
// use
Vue.use(mavonEditor)


Vue.use(element)
Vue.use(VueAxios,axios)

axios.defaults.baseURL='http://39.101.1.197:8081'
import './assets/css/assets.css'

Vue.config.productionTip = false


axios.interceptors.request.use(config => {
  // 给请求头赋值
    config.headers.Authorization = window.sessionStorage.getItem('token');
    return config;
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h=>h(App),
  components: { App },
  template: '<App/>'
})

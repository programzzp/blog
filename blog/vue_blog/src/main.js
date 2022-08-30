// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/css/assets.css'
import element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
// use
Vue.use(mavonEditor)
Vue.use(VueAxios,axios)

axios.defaults.baseURL='http://47.105.34.128:8081'

Vue.config.productionTip = false

Vue.use(element)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h=>h(App),
  components: { App },
  template: '<App/>'
})

import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import First from '@/components/First'
import Personalprofile from '@/components/Personalprofile'
import article from '@/components/article'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      children:[
        {
          path: '/first',
          component: First
        },{
          path: '/personalprofile',
          component: Personalprofile
        },
        {
          path: '/article',
          component: article
        }
      ]
    }
  ]
})

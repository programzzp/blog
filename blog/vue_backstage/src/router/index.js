import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Index from '@/components/Index'
import ShowBlog from '@/components/ShowBlog'
import article from '@/components/article'
import CreationBlog from '@/components/CreationBlog'
import Settings from '@/components/Settings'
import Project from '@/components/Project'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },{
      path: '/index',
      name: '',
      component: Index,
      children:[
        {
          path: '/show',
          name: '',
          component: ShowBlog
        },
        {
          path: '/article',
          component: article
        },{
          path: '/creation',
          component: CreationBlog
        },{
          path: '/settings',
          component: Settings
        },{
          path: '/project',
          component: Project
        }
      ]
    }
  ]
})

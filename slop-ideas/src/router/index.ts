import { createRouter, createWebHistory } from 'vue-router'
import GroupView from '@/views/GroupView.vue'
import PairView from '@/views/PairView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: GroupView,
    },
    {
      path: '/pairs',
      name:'pairs',
      component: PairView
    },
  ],
})

export default router

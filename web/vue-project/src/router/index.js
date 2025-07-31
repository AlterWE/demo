import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/', redirect: '/login'},
    { path:'/login', name: 'Login', component: () => import('../views/Login.vue') },
    { path:'/welcome', name: 'Welcome', component: () => import('../views/Welcome.vue') },
  ],
})

export default router

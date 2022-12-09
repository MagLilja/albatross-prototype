import {createRouter, createWebHistory} from "vue-router";
import home from "../views/home.vue";

const router = createRouter({
    history: createWebHistory('/'),
    routes: [
        {
            path: '/',
            category: 'home',
            component: home,
        },
        {
            path: '/shop',
            category: 'shop',
            component: () => import('../views/shop.vue'),
        },
        {
            path: '/categories',
            category: 'categories',
            component: () => import('../views/categories.vue'),
        }
    ]
})

export default router
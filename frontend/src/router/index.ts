import {createRouter, createWebHistory} from "vue-router";
import home from "../views/home.vue";

const router = createRouter({
    history: createWebHistory('/'),
    routes: [
        {
            path: '/',
            name: 'home',
            component: home,
        },
        {
            path: '/shop',
            name: 'shop',
            component: () => import('../views/shop.vue'),
        },
        {
            path: '/categories',
            name: 'categories',
            component: () => import('../views/categories.vue'),
        },
        {
            path: '/admin',
            name: 'admin',
            component: () => import('../views/admin.vue'),
            children: [
                {
                    path: '/add-product',
                    name: 'add-product',
                    component: () => import('../views/admin/add-product.vue'),
                }
                ]

        }
    ]
})

export default router
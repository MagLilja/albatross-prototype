<script setup lang="ts">


import {useAuthStore} from "../../stores/authStore";

const props = defineProps<{
    atTop: boolean
}>()

const auth = useAuthStore()


</script>


<template>
    <ul class="nav-links flex gap-2 text-white" :class="{'text-black':props.atTop}">
        <li class="font-bold">
            Admin menu:
        </li>        <li>
            <router-link to="/admin/add-product">Add product</router-link>
        </li>
        <li>
            <router-link to="/admin/show-products">Show products</router-link>
        </li>
        <li>
            <a @click.prevent="auth.logout()"> - Logout</a>
        </li>

    </ul>
</template>

<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}
</style>
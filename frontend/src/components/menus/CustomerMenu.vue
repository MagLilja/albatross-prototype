<script setup lang="ts">


const props = defineProps<{
    atTop: boolean
}>()

</script>


<template>
    <ul class="nav-links flex gap-2 text-white" :class="{'text-black':props.atTop}">
        <li>
            <router-link to="/">Home</router-link>
        </li>
        <li>
            <router-link to="/shop">Shop</router-link>
        </li>
        <li>
            <router-link to="/about">About</router-link>
        </li>
        <li>
            <router-link to="/impressions">Impressions</router-link>
        </li>
    </ul>
</template>

<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}
</style>
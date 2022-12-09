<script setup lang="ts">
import {useRoute} from "vue-router";
import {defineProps, ref, watchEffect} from 'vue'

const props = defineProps(['atTop'])

const route = useRoute()

const isAdmin = ref(false)

watchEffect(() => {
    if (route.path.includes('admin')) {
        isAdmin.value = true
    } else {
        isAdmin.value = false
    }
})

</script>

<template>
    <div class="bg-[#4a4a4b] fixed top-0 left-0 w-full flex justify-between items-center px-12 z-40"
         :class="{'bg-transparent':props.atTop}">
        <div>
            <router-link to="/"><img class="w-3/5 p-2 invert-1" :class="{'invert':props.atTop}"
                                     src="../assets/logo.webp" alt=""></router-link>
        </div>
        <div v-if="!isAdmin">
            <ul class="nav-links flex gap-2 text-white" :class="{'text-black':props.atTop}">
                <li>
                    <router-link to="/">Home{{isAdmin}}</router-link>
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
        </div>
        <div>
            <ul class="flex gap-4 items-center ">
                <li><a href="https://www.facebook.com/albatross.sportswear">
                    <img src="../assets/facebook.svg"
                         class="pt-1 invert"
                         :class="{'invert-0':props.atTop}"
                         alt="facebook"></a></li>
                <li><a href="https://www.instagram.com/albatross_sportswear/">
                    <img src="../assets/insta.svg"
                         class="pt-1 invert"
                         :class="{'invert-0':props.atTop}"
                         alt="instagram"></a></li>
                <li>
                    <img src="../assets/basket.svg"
                         class="-ml-1 invert"
                         :class="{'invert-0':props.atTop}"
                         alt="basket">
                </li>
            </ul>
        </div>
    </div>
</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}
</style>
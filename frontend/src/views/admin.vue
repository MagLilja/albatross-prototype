<script setup lang="ts">
import {useRoute} from "vue-router";
import {Ref, ref, watchEffect} from "vue";
import {ProductType} from "../interface/interfaces";

const route = useRoute()

//get the type from the query parameter
const type: Ref<ProductType> = ref(route.query.type as ProductType)
watchEffect(() => {
    type.value = route.path as unknown as ProductType
})







</script>

<template>
    <div>
        <div class="text-4xl m-14 ">{{type}}</div>
        <router-view></router-view>
    </div>
</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
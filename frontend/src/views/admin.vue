<script setup lang="ts">
import {useRoute} from "vue-router";
import ApiService from "../services/apiService";
import {onMounted, Ref, ref} from "vue";
import {Product, ProductType} from "../interface/interfaces";
import ProductsComponent from "../components/ProductsComponent.vue";

const route = useRoute()

//get the type from the query parameter
const type = route.path as unknown as ProductType

//fetch the products of the type from the api
// onMounted(async () => {
//     products.value = await ApiService.getDataFrom("products/type?type=" + type.toString().toUpperCase()) as Product[];
// })

// create a ref to hold the list of products of the type
const products: Ref<Product[]> = ref([])




</script>

<template>
    <div>
        <div class="text-4xl m-14 ">Administration {{type}}</div>
        <router-view></router-view>
    </div>
</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
<script setup lang="ts">
import {onMounted, ref, Ref} from "vue";
import {Product} from "../../interface/interfaces";
import ApiService from "../../services/apiService";

// create a ref to hold the list of products of the type
const products: Ref<Product[]> = ref([])

onMounted(async () => {
    // get the products from the api
    let promise = await ApiService.getDataFrom("products")
    products.value = await promise.json()
})
</script>

<template>
    <div class="px-16">

        {{products}}
    </div>
</template>


<style scoped>

</style>
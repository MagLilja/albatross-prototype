<script setup lang="ts">
import {onMounted, ref, Ref} from "vue";
import {Product} from "../../interface/interfaces";
import ApiService from "../../services/apiService";

// create a ref to hold the list of products of the type
const products: Ref<Product[]> = ref([])
const stocks: Ref<number[]> = ref([])

onMounted(async () => {
    // get the products from the api
    let promise = await ApiService.getDataFrom("products")
    products.value = await promise.json()

    let stockPromise = await ApiService.getDataFrom("admin/stock")
    stock.value = await stockPromise.json()
    console.log(stock);

    products.value.forEach(product => {
        product.stock = stock[product.id]
    })
})


</script>

<template>
    <div class="px-16">

        {{products}}
    </div>
</template>


<style scoped>

</style>
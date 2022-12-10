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
    <div class="px-16 grid gap-x-4 grid-cols-[max-content_max-content_max-content_max-content_max-content_max-content_max-content]">

        <div class="font-bold mb-2">Art. Nr.</div>
        <div class="font-bold mb-2">Type</div>
        <div class="font-bold mb-2">Model</div>
        <div class="font-bold mb-2">Color</div>
        <div class="font-bold mb-2">Price</div>
        <div class="font-bold mb-2"></div>
        <div class="font-bold mb-2"></div>

        <div class="font-bold border-b-2 mb-2 col-span-7"></div>

        <template v-for="product in products" >
            <div class="x">{{ product.artNum }}</div>
            <div class="x">{{ product.type }}</div>
            <div class="x whitespace-nowrap">{{ product.model }}</div>
            <div class="x">{{ product.color }}</div>
            <div class="x">{{ product.price }},00 SEK</div>
            <div class="text-[20px]">&#x1f5d1;</div>
            <div class="text-[20px]">&#x1f58b;</div>
        </template>
    </div>
</template>


<style scoped>

</style>
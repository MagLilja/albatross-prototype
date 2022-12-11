<script setup lang="ts">
import {onMounted, ref, Ref, watchEffect} from "vue";
import {Product, ProductType} from "../../interface/interfaces";
import ApiService from "../../services/apiService";
import {productTypes} from "../../enums/enums.js";

// create a ref to hold the list of products of the type
const productsAllData: Ref<Product[]> = ref([])
const products: Ref<Product[]> = ref([])
const stocks: Ref<number[]> = ref([])


const type: Ref<ProductType> = ref(ProductType.ALL);

onMounted(async () => {
    // get the products from the api
    let promise = await ApiService.getDataFrom("products");
    productsAllData.value = await promise.json() as Product[]
    products.value = productsAllData.value


    // products.value = productsList.filter(product => product.type === type.value.toUpperCase())

    console.log(products.value);

})

watchEffect(() => {
    if (type.value !== ProductType.ALL.toUpperCase()) {
        products.value = productsAllData.value.filter(product => product.type === type.value.toUpperCase())
    }
    else{
        console.log("va?");
        products.value = productsAllData.value
    }

})

</script>

<template>
    <div class="grid">
        <div class="x">Filer type: <select v-model="type">
            <option v-for="type in productTypes" :value="type.toUpperCase()">{{ type }}</option>
        </select></div>
        <div
            class="px-16 grid gap-x-4 grid-cols-[max-content_max-content_max-content_max-content_max-content_max-content_max-content_max-content]">

            <div class="font-bold mb-2">Art. Nr.</div>
            <div class="font-bold mb-2">Type</div>
            <div class="font-bold mb-2">Model</div>
            <div class="font-bold mb-2">Color</div>
            <div class="font-bold mb-2">Price</div>
            <div class="font-bold mb-2">Stock</div>
            <div class="font-bold mb-2"></div>
            <div class="font-bold mb-2"></div>

            <div class="font-bold border-b-2 mb-2 col-span-8"></div>

            <template v-for="product in products">
                <div class="x">{{ product.artNum }}</div>
                <div class="x">{{ product.type.toLowerCase() }}</div>
                <div class="x whitespace-nowrap">{{ product.model }}</div>
                <div class="x">{{ product.color }}</div>
                <div class="x">{{ product.price }},00 SEK</div>
                <div class="x">{{ product.stock?.amountInStock ? product.stock.amountInStock : 0 }}</div>
                <div class="text-[20px]">&#x1f5d1;</div>
                <div class="text-[20px]">&#x1f58b;</div>
            </template>
        </div>
    </div>
</template>


<style scoped>

</style>
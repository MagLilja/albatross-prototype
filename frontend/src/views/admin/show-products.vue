<script setup lang="ts">
import {onMounted, ref, Ref, watchEffect} from "vue";
import {Product, ProductType} from "../../interface/interfaces";
import ApiService from "../../services/apiService";
import {productTypes} from "../../enums/enums.js";
import ProductListComponent from "./ProductListComponent.vue";

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

})

watchEffect(() => {
    if (type.value.toUpperCase() !== ProductType.ALL.toUpperCase()) {
        products.value = productsAllData.value.filter(product => product.type === type.value.toUpperCase())
    } else {
        products.value = productsAllData.value
    }

})

</script>

<template>
    <div class="">
        <div class="flex justify-center m-6 gap-6 items-center">Filter type:

            <select v-model="type">
                <option v-for="type in productTypes" :value="type.toUpperCase()">{{ type }}</option>
            </select>
        </div>
        <ProductListComponent :product-list="products"/>
    </div>
</template>



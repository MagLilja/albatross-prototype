<script setup lang="ts">

import {Ref, ref} from "vue";
import {Product, ProductSize} from "../../interface/interfaces";
import ApiService from "../../services/apiService";
import {productTypes} from "../../enums/enums.js";

const productSizes: Ref<ProductSize[]> = ref([ProductSize.XS, ProductSize.S, ProductSize.M, ProductSize.L, ProductSize.XL])

const newProduct: Ref<Product> = ref({
    artNum: "",
    color: "",
    model: "",
    price: 0,
    size: undefined,
    type: undefined,
})

const stock = ref(0)
const status = ref("")

interface ProductPayload {
    product: Product,
    amountInStock: number,
    photos: string[]
}

function resetProductInput() {
    newProduct.value = {
        artNum: "",
        color: "",
        model: "",
        price: 0,
        size: undefined,
        type: undefined,
    }
    stock.value = 0
}

async function registerProduct() {
    const payload: ProductPayload = {
        product: newProduct.value,
        amountInStock: stock.value,
        photos: ["test3454", "test345"]
    }

    console.log(JSON.stringify(payload));
    const payloa2d = 2;

    let promise = await ApiService.post("/api/admin/products", payload)
    status.value = promise.status < 300 ? "Product added" : promise
    resetProductInput();
}



</script>

<template>
    <div class="px-16">

        <form>
            <div class="grid grid-cols-[max-content_200px] items-center text-right">
                <div class="x">artNum:</div>
                <input type="text" v-model="newProduct.artNum">

                <div class="x">type:</div>
                <select v-model="newProduct.type">
                    <option v-for="type in productTypes" :value="type.toUpperCase()">{{ type }}</option>
                </select>
                <div class="x">model:</div>
                <input type="text" v-model="newProduct.model">

                <div class="x">size:</div>
                <select v-model="newProduct.size">
                    <option v-for="sizes in productSizes">{{ sizes }}</option>
                </select>

                <div class="x">color:</div>
                <input type="text" v-model="newProduct.color">

                <div class="x">price:</div>
                <input type="number" v-model="newProduct.price">

                <div class="x">amount in stock:</div>
                <input type="number" v-model="stock">

                <div class="col-span-2  mt-6">
                    <div class="x">
                        <button @click.prevent="registerProduct()">Registrera produkt</button>
                    </div>
                    <div class="mt-4">
                        {{ status }}
                    </div>
                </div>

            </div>
        </form>

    </div>
</template>


<style scoped>


.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
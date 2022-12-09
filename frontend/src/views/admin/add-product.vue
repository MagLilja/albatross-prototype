<script setup lang="ts">

import {Ref, ref} from "vue";
import {Product, ProductSize, ProductType} from "../../interface/interfaces";
import ApiService from "../../services/apiService";

const productSizes: Ref<ProductSize[]> = ref([ProductSize.XS, ProductSize.S, ProductSize.M, ProductSize.L, ProductSize.XL])
const productTypes: Ref<ProductType[]> = ref([ProductType.PANTS, ProductType.JACKETS, ProductType.ACCESSORIES, ProductType.VESTS, ProductType.RAINCOATS, ProductType.WINDSTOPPERS])

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

async function registerProduct() {
    console.log(newProduct.value)
    let promise = await ApiService.postDataTo("admin/products/" + stock.value, newProduct.value);
    status.value = promise.status == 200 ? "Product added" : "Error"
    console.log(stock);
    console.log(promise);
    newProduct.value = {
        artNum: "",
        color: "",
        model: "",
        price: 0,
        size: undefined,
        type: undefined,
    }
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
                        <button @click.prevent="registerProduct()">Registera produkt</button>
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

select {
    border: 1px solid black;
    border-radius: 5px;
    padding: 5px;
    margin: 5px;

}

input {
    border: 1px solid black;
    border-radius: 5px;
    padding: 5px;
    margin: 5px;
}

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
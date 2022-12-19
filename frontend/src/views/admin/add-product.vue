<script setup lang="ts">

import {onMounted, Ref, ref, watch, watchEffect} from "vue";
import {ProductInterface, ProductSize} from "../../interface/interfaces";
import ApiService from "../../services/apiService";
import {productTypes} from "../../enums/enums.js";
import router from "../../router";
import {useRoute} from "vue-router";


const props = defineProps<{
    productToUpdate: ProductInterface
}>()

const route = useRoute()


const productSizes: Ref<ProductSize[]> = ref([ProductSize.XS, ProductSize.S, ProductSize.M, ProductSize.L, ProductSize.XL])
const isEdit: Ref<boolean> = ref(false)
const newProduct: Ref<ProductInterface> = ref({
    artNum: "",
    color: "",
    model: "",
    price: 0,
    size: undefined,
    type: undefined,
})

// if (route.query.id) {
//     let promise = await ApiService.get("/api/admin/products/"+route.query.id)
// };

watchEffect(async () => {
    if (route.query.id) {
        isEdit.value = true
        console.log(route.query.id);
        let promise = await ApiService.get("/api/products/" + route.query.id)
        console.log(promise);
        newProduct.value = promise
    } else {
        // resetProductInput()
        isEdit.value = false
    }
})

watch (isEdit, (newProduct:boolean) => {
    resetProductInput()
    status.value = ""
})


const stock = ref(0)
const status = ref("")

interface ProductPayload {
    product: ProductInterface,
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

    let promise = await ApiService.post("/api/admin/products", payload)
    status.value = await promise.artNum ? "Product added" : promise
    resetProductInput();
}

async function updateProduct() {
    const payload: ProductPayload = {
        product: newProduct.value,
        amountInStock: stock.value,
        photos: ["test3454", "test345"]
    }

    let promise = await ApiService.put("/api/admin/products/" + newProduct.value.artNum, payload)
    status.value = await promise.artNum ? "Product updated" : promise
    // resetProductInput();
}


</script>

<template>
    <div class="px-16">

        <form>
            <div class="grid grid-cols-[max-content_200px] items-center text-right">
                <div class="x" v-if="!isEdit">artNum:</div>
                <input v-if="!isEdit" type="text" v-model="newProduct.artNum">
                <div class="col-span-2 font-bold pr-2 text-xl" v-if="isEdit">Art. Nr.: {{newProduct.artNum}}</div>
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
                    <div v-if="isEdit" class="x">
                        <button @click.prevent="updateProduct()">Uppdatera produkt</button>
                    </div>
                    <div v-else class="x">
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
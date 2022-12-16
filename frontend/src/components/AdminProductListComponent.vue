<script setup lang="ts">
import {Product} from "../interface/interfaces";
import router from "../router";

const props = defineProps<{
    productList: Product[] }>()

const deleteEmitName = 'deleteProduct';
const emits = defineEmits<{
    (e: typeof deleteEmitName, id: Product, active: boolean): void,

}>();

const deleteProduct = (product: Product) => {
    emits(deleteEmitName, product, true)
}

function updateProduct(product: Product) {
    router.push({name: 'add-product', query: {id: product.artNum}})
}
</script>


<template>

    <div
        class="px-16 grid gap-x-4 grid-cols-[max-content_max-content_max-content_max-content_max-content_max-content_max-content_max-content_max-content]">

        <div class="font-bold mb-2">Art. Nr.</div>
        <div class="font-bold mb-2">Type</div>
        <div class="font-bold mb-2">Model</div>
        <div class="font-bold mb-2">Size</div>
        <div class="font-bold mb-2">Color</div>
        <div class="font-bold mb-2">Price</div>
        <div class="font-bold mb-2">Stock</div>
        <div class="font-bold mb-2"></div>
        <div class="font-bold mb-2"></div>

        <div class="font-bold border-b-2 mb-2 col-span-9"></div>
        <!--            {{ products }}-->
        <template v-for="product in props.productList">
            <div class="x">{{ product.artNum }}</div>
            <div class="x">{{ product.type?.toLowerCase() }}</div>
            <div class="x">{{ product.model }}</div>
            <div class="x">{{ product.size }}</div>
            <div class="x">{{ product.color }}</div>
            <div class="x">{{ product.price }},00 SEK</div>
            <div class="x">{{ product.stock?.amountInStock ? product.stock.amountInStock : 0 }}</div>
            <div class="text-[20px] cursor-pointer" @click="deleteProduct(product)" :product="product">&#x1f5d1;</div>
            <div class="text-[20px] cursor-pointer" @click="updateProduct(product)">&#x1f58b;</div>
        </template>
    </div>

</template>

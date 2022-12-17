<script setup lang="ts">
import {onMounted, Ref, ref} from "vue";
import ApiService from "../services/apiService";
import {Product, ProductSize} from "../interface/interfaces";

const props = defineProps({
    // Props are defined here
    // They are passed in from the parent component
    // and are immutable
    // They are accessed using the `props` object
    // e.g. props.category
    category: {
        type: String,
        default: "All"
    },
})

const products: Ref<Product[]> = ref([])

onMounted(async () => {
    // This is called when the component is mounted
    // This is where you would make API calls
    // to fetch data
    if (props.category === "All") {
        // fetch all products
        const loadedProducts = await ApiService.get("/api/products") as Product[];
        products.value = loadedProducts.filter(prod => {
            console.log(prod, (prod.size === ProductSize.M));
            return prod.size === ProductSize.M
        })
    } else {
        // fetch products of the category
        products.value = await ApiService.get("/api/products/type?type=" + props.category.toString().toUpperCase()) as Product[];
    }
})

function getProdImg(product: Product) {
    return null
}


function urlForProductImage(product: Product): string {

    return product.photoList[0] ? product.photoList[0].filename : "windbreakerHunneboUnisexOffwhite.webp"

    // TODO get image from api

}

</script>

<template>

    <div class="flex flex-wrap gap-8 mx-auto -z-20 w-2/3">
        <div v-for="product in products"
             class="cursor-pointer bg-center bg-cover w-[250px]  flex flex-col justify-start gap-1  hover:bg-gray-50">
            <img class="object-scale-down h-[290px]]" src="" alt=""
                 :srcset="'src/assets/products/' + urlForProductImage(product)">
            <div class="flex gap-1">
                    <span class="capitalize font-bold">{{
                            product.type.toLocaleLowerCase().substring(0, product.type.length - 1)
                        }} {{ product.model }}</span>
            </div>
            <span>{{ product.color }}</span>
            <div>{{ product.price }},00 SEK</div>
        </div>
    </div>

</template>

<style scoped>
.read-the-docs {
    color: #888;
}
</style>

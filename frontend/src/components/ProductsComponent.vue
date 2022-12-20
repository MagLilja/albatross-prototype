<script setup lang="ts">
import {onMounted, Ref, ref} from "vue";
import ApiService from "../services/apiService";
import {ProductInterface, ProductSize} from "../interface/interfaces";
import router from "../router";

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

const products: Ref<ProductInterface[]> = ref([])

onMounted(async () => {
    // This is called when the component is mounted
    // This is where you would make API calls
    // to fetch data
    if (props.category === "All") {
        // fetch all products
        const loadedProducts = await ApiService.get("/api/products") as ProductInterface[];
        products.value = loadedProducts.filter(prod => {
            return prod.size === ProductSize.XS
        })
    } else {
        // fetch products of the category
        const loadedProducts = await ApiService.get("/api/products/type?type=" + props.category.toString().toUpperCase()) as ProductInterface[];
        products.value = loadedProducts.filter(prod => {
            return prod.size === ProductSize.XS
        })
    }
})

function getProdImg(product: ProductInterface) {
    return null
}


function urlForProductImage(product: ProductInterface): string {
    return product.photoList[0] ? product.photoList[0].filename : "windbreakerHunneboUnisexOffwhite.webp"
}

function goToProduct(product: ProductInterface) {
    router.push({name: "productPage", params: {artNr: product.artNum}})
}

</script>


<template>

    <div class="flex flex-wrap gap-8 mx-auto mt-44 w-2/3 justify-center">

        <div class="text-4xl ml-24  my-6 basis-full">Products <div class="text-xs "><router-link to="shop">Shop</router-link> / {{ props.category }}</div></div>
                <div v-for="product in products"
             class="cursor-pointer bg-center bg-cover w-[250px]  flex flex-col justify-start gap-1  hover:bg-[#f2f2f4] p-2" @click.prevent="goToProduct(product)">
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

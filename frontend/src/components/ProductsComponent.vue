<script setup lang="ts">
import {computed, onMounted, Ref, ref, toRefs} from "vue";
import ApiService from "../services/apiService";
import {Product} from "../interface/interfaces";
import { useScroll } from '@vueuse/core'

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
        products.value = await ApiService.getDataFrom("products") as Product[];
    } else {
        // fetch products of the category
        products.value = await ApiService.getDataFrom("products/type?type=" + props.category.toString().toUpperCase()) as Product[];
    }
})



function urlForProductImage(product: Product): string {
    return "src/assets/products/smogen.png"

    // TODO get image from api

}

</script>

<template>

    <div class="flex flex-wrap gap-8 mx-14 -z-20">
        <div v-for="product in products"
             class="cursor-pointer bg-center bg-cover w-[200px] h-[80px] flex flex-col justify-start gap-1  relative hover:bg-amber-100">
            <img src="" alt="" :srcset="urlForProductImage(product)">
            <div class="flex gap-1">
                    <span class="capitalize">{{
                            product.type.toLocaleLowerCase().substring(0, product.type.length - 1)
                        }}</span>
                <span>{{ product.model }}</span>
                <span>{{ product.color }}</span></div>
            <div>{{ product.price }},00 €</div>
        </div>
    </div>

</template>

<style scoped>
.read-the-docs {
    color: #888;
}
</style>

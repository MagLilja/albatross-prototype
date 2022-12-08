<script setup lang="ts">
import {useRoute} from "vue-router";
import {getDataFrom} from "../services/apiService";
import {onMounted, Ref, ref} from "vue";
import {Product} from "../interface/model-interface";

const route = useRoute()

//get the type from the query parameter
const type = route.query.type as string

//fetch the products of the type from the api
onMounted(async () => {
    products.value = await getDataFrom("products/type?type=" + type.toUpperCase()) as Product[];
})

// create a ref to hold the list of products of the type
const products: Ref<Product[]> = ref([])

function urlForProductImage(product: Product): string {
    return "src/assets/products/smogen.png"

    // TODO get image from api
    // return "url('src/assets/" + product. + "')";

}


</script>

<template>
    <div>
        <div class="text-xs mb-4">Shop / {{ type }}</div>
        <div class="text-4xl mb-14">{{ type }}</div>

        <div class="flex flex-wrap gap-8 justify-center">
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
    </div>
</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
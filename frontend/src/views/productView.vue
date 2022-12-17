<script setup lang="ts">
import {useRoute} from "vue-router";
import {onBeforeMount, onMounted, Ref, ref} from "vue";
import ApiService from "../services/apiService";
import {ProductInterface} from "../interface/interfaces";

const route = useRoute()

const product: Ref<ProductInterface> = ref({} as ProductInterface)

//get the type from the query parameter

const artNr = route.params.artNr
//fetch the product of the id from the api
onBeforeMount(async () => {
    product.value = await ApiService.get(`/api/products/${artNr}`) as ProductInterface;

})


function urlForProductImage(): string {
    // console.log(product.value.photoList);
    return product.value.photoList[0] ? product.value.photoList[0].filename : "windbreakerHunneboUnisexOffwhite.webp"
}

</script>

<template>
    <div class="w-2/3 mt-44 mx-auto p-2 flex">


        <div class="basis-1/2 p-2"><img :src="'/src/assets/products/' + urlForProductImage(product)" alt="" srcset="">
        </div>
        <div class="basis-1/2 px-6 py-8 grid content-start">
            <div class="text-4xl font-light">{{ product.model }}</div>
            <div class="text-4xl font-light">{{ product.color }}</div>
            <div class="text-xl font-bold mt-6">{{ product.price }},00 SEK</div>
            <div class="text-sm ">incl. VAT. </div>
            <div class="text-sm ">expected delivery time 5-7 weeks. </div>
        </div>

    </div>
</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
<script setup lang="ts">
import {useRouter} from "vue-router";
import ProductsComponent from "../components/ProductsComponent.vue";


const router = useRouter()

interface ClothingType {
    type: string;
    image: string;
}

const clothing_types: ClothingType[] = [
    {
        type: "Windbreakers",
        image: "url('src/assets/windbreakers.png')"
    },
    {
        type: "Raincoats",
        image: "url('src/assets/raincoats.png')"
    },
    {
        type: "Jackets",
        image: "url('src/assets/jackets.png')"
    },
    {
        type: "Pants",
        image: "url('src/assets/pants.png')"
    },
    {
        type: "Vests",
        image: "url('src/assets/vests.png')"
    },
    {
        type: "Accessories",
        image: "url('src/assets/accessories.png')"
    }
]
function goToProduct(clothing_type : string) {
    router.push({ path: 'categories', query: { type: clothing_type }})
}



</script>

<template>
    <div class="flex flex-wrap gap-8 text-center text-white  justify-center">
        <div  @click="goToProduct(type.type)" :style="{'background-image': type.image}" v-for="type in clothing_types" class="cursor-pointer  bg-center bg-cover w-[200px] h-[80px] flex justify-center items-center relative hover:border-2 hover:border-black -z-20">
            {{ type.type }}
        </div>
    </div>
    <div class="text-4xl m-14">Products</div>
    <ProductsComponent></ProductsComponent>


</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

.bg {
    background-image: url('../assets/img.png');
}
</style>
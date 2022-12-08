<script setup lang="ts">
import Testar from "../components/Testar.vue"
import router from "../router";

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
    router.push({ path: 'product', query: { plan: clothing_type }})
}



</script>

<template>
    <testar></testar>
    <div class="flex flex-wrap gap-8 text-center text-white  justify-center">
        <div :style="{'background-image': type.image}" v-for="type in clothing_types" class="bg-center bg-cover w-[200px] h-[80px] flex justify-center items-center relative">
<!--            <div class="bg-white/30 w-full h-full absolute"></div>-->
            <a @click="goToProduct(type.type)">{{ type.type }}</a>
        </div>
    </div>

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
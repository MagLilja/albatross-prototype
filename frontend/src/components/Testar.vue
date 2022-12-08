<script setup lang="ts">
import {Ref, ref} from 'vue'
import {Product} from "../interface/model-interface";

const count = ref(0)


const data: Ref<Product[]> = ref()

const fetchData = async () => {
    const promise = await fetch('/api/products');
    data.value = await promise.json()
}

</script>

<template>

    <div class="card mt-[200px]">
        <button type="button" @click="fetchData()">Visa alla produkter</button>
    </div>
    <ul>
        <li v-for="product in data">
            {{ product.model }} - {{ product.price }} kr
        </li>
    </ul>

</template>

<style scoped>
.read-the-docs {
    color: #888;
}
</style>

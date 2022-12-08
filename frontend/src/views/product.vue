<script setup lang="ts">
import Testar from "../components/Testar.vue"
import router from "../router";


</script>

<template>
    <div>

        {{ $route.query.plan }}
    </div>
</template>


<style scoped>

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
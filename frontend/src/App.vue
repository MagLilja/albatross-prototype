<script setup lang="ts">
import TopNavigation from "./components/TopNavigationComponent.vue";
</script>

<template>
    <nav>
        <top-navigation/>
    </nav>

    <div class="mb-0 mt-24 content-center justify-center mx-24">
        <router-view class=""/>
    </div>
</template>

<style scoped>
.logo {
    height: 6em;
    padding: 1.5em;
    will-change: filter;
}

.logo:hover {
    filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
    filter: drop-shadow(0 0 2em #42b883aa);
}
</style>

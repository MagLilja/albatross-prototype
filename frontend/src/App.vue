<script setup lang="ts">
import TopNavigation from "./components/TopNavigationComponent.vue";
import {computed, ref, toRefs} from 'vue'
import {useScroll} from '@vueuse/core'

const el = ref<HTMLElement | null>(null)
const smooth = ref(false)
const behavior = computed(() => smooth.value ? 'smooth' : 'auto')
const {arrivedState} = useScroll(el, {behavior})
const {top} = toRefs(arrivedState)


</script>

<template>
    <div  class="x">
        <div ref="el" class="w-screen h-screen m-auto overflow-scroll scroll-smooth">
            <nav>
                <top-navigation :atTop="top"/>
            </nav>
            <div class="mb-0 mt-24 content-center justify-center mx-24">
                <router-view class=""/>
            </div>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </div>
    </div>
</template>

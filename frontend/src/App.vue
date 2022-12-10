<script setup lang="ts">
import TopNavigation from "./components/TopNavigationComponent.vue";
import {computed, ref, toRefs} from 'vue'
import {useScroll} from '@vueuse/core'
import BooleanDisplay from "./components/BooleanDisplay.vue";
import scroll from "./components/scroll.vue";

const el = ref<HTMLElement | null>(null)
const smooth = ref(false)
const behavior = computed(() => smooth.value ? 'smooth' : 'auto')
const {x, y, isScrolling, arrivedState, directions} = useScroll(el, {behavior})
const {left, right, top, bottom} = toRefs(arrivedState)
const {left: toLeft, right: toRight, top: toTop, bottom: toBottom} = toRefs(directions)
// Format the numbers with toFixed() to make them
// nicer to displayœ
const displayX = computed({
    get() {
        return x.value.toFixed(1)
    },
    set(val) {
        x.value = parseFloat(val)
    },
})
const displayY = computed({
    get() {
        return y.value.toFixed(1)
    },
    set(val) {
        y.value = parseFloat(val)
    },
})

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

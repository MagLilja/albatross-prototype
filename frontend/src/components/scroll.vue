<script setup lang="ts">
import {computed, ref, toRefs} from 'vue'
import {useScroll} from '@vueuse/core'
import BooleanDisplay from "./BooleanDisplay.vue";

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
    <div class="flex">
        <div ref="el" class="w-[300px] h-[300px] m-auto overflow-scroll bg-gray-500/5 rounded">
            <div class="w-[500px] h-[400px] relative">
                <div position="absolute left-0 top-0" bg="gray-500/5" p="x-2 y-1">
                    TopLeft
                </div>
                <div position="absolute left-0 bottom-0" bg="gray-500/5" p="x-2 y-1">
                    BottomLeft
                </div>
                <div class="m-auto w-280px pl-4">

                    <div text="right" opacity="75">
                        Top Arrived
                    </div>
                    <BooleanDisplay :value="top"/>

                </div>
                <div position="absolute right-0 top-0" bg="gray-500/5" p="x-2 y-1">
                    TopRight
                </div>
                <div position="absolute right-0 bottom-0" bg="gray-500/5" p="x-2 y-1">
                    BottomRight
                </div>
                <div position="absolute left-1/3 top-1/3" bg="gray-500/5" p="x-2 y-1">
                    Scroll Me
                </div>
            </div>
        </div>

    </div>
</template>
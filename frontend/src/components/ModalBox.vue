<script setup lang="ts">
import {ref, watch, watchEffect} from "vue";

let props = defineProps<{
    title: string,
    active: boolean
}>()

const emits = defineEmits<{
    (event: 'call-on-answer', answer: boolean): void
}>()

const showModal = ref(false)

// watch effect on props.active
watch(() => props.active, (newValue) => {
    showModal.value = newValue
})

watchEffect(() => {
    showModal.value = props.active
})


function cancel() {
    emits('call-on-answer', false)
    showModal.value = false
}

function deleteProduct() {
    emits('call-on-answer', true)
    showModal.value = false
}


</script>

<template>

    <div>
        <div v-if="showModal" class="w-screen h-screen fade bg-gray-600/20 absolute top-0 left-0 outline-none overflow-x-hidden overflow-y-auto" style="backdrop-filter: blur(2px);">
            <div v-if="showModal" class="text-center w-[200px] h-[160px] border-2 p-6 absolute top-1/2 left-1/2 bg-gray-500 text-white">{{ props.title }}
                <button class="text-black mx-1" @click="deleteProduct()">Yes</button>
                <button class="text-black mx-1" @click="cancel()">No</button>
            </div>
        </div>
        
    </div>


</template>
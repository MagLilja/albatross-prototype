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
}

function deleteProduct() {
    emits('call-on-answer', true)
}


</script>

<template>

    <div>
        <div v-if="showModal" class="w-screen h-screen fade bg-gray-600/20 absolute top-0 left-0 outline-none overflow-x-hidden overflow-y-auto" style="backdrop-filter: blur(2px);">{{ props.title }}
            <div v-if="showModal" class="w-[200px] h-[200px] border-2 p-6 absolute top-0">{{ props.title }}
                <button @click="deleteProduct()">Yes</button>
                <button @click="cancel()">No</button>
            </div>
        </div>
        {{ props.active }}
        {{ showModal }}
    </div>


</template>
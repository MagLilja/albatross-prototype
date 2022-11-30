<script setup lang="ts">
import { ref } from 'vue'

defineProps<{ msg: string }>()

const count = ref(0)

// fetch from api
const apai = ref("/api/pants");
const api = ref("/api/pants");
const data = ref([]);
const error = ref(null);
const loading = ref(false);

async function fetchData() {
  loading.value = true;
  error.value = null;

    var myHeaders = new Headers();
    myHeaders.append("cache", "no-cache");
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

  try {
    const response = await fetch(api.value, requestOptions);
      console.log(response);
      if (!response.ok) {
      throw Error("No data available");
    }
    data.value = await response.json();
      console.log(data);
  } catch (err) {
    error.value = err.message;
  } finally {
    loading.value = false;
  }
}

</script>

<template>
  <h1>{{ msg }}</h1>

  <div class="card">
    <button type="button" @click="fetchData()">count is {{ count }}</button>
    <p>
        {{ data }}
    </p>
  </div>

</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>

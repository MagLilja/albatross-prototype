<script setup lang="ts">


</script>

<template>
    <div class="px-16">
        <form >
            <div class="grid grid-cols-[max-content_200px] items-center text-right">
                <div class="x">artNum: </div>
                <input type="text">

                <div class="x">type: </div>
                <input type="text">

                <div class="x">model: </div>
                <input type="text">

                <div class="x">size: </div>
                <input type="text">


                <div class="x">color: </div>
                <input type="text">

                <div class="x">price: </div>
                <input type="text">

                <div class="x">amount in stock: </div>
                <input type="text">

            </div>


        </form>

    </div>
</template>


<style scoped>

input {
    border: 1px solid black;
    border-radius: 5px;
    padding: 5px;
    margin: 5px;
}

.nav-links > li:hover {
    text-decoration: underline;
    cursor: pointer;
}

</style>
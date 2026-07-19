<script setup>
import axios from "axios";
function getInfo(){
  axios.get("/").then(resp=>{
    console.log(resp.data)
  })
}
</script>

<template>
<button @click="getInfo">GET请求</button>
</template>

<style scoped>

</style>

<script setup lang="ts">
import {computed, reactive, ref, watch, watchEffect} from "vue";

let name="张三";

let car=reactive({
    brand:"奔驰",
    color:"红色",
    price:9999
})

//2.指令
let msg="<p style='color: #646cff'>你好</p>"

function buy(){
  alert("你购买了"+car.brand)
}
//事件绑定
const url=ref("https://www.baidu.com")

function changeUrl(){
  console.log(url)
  url.value="https://www.taobao.com"
}



let fruits=["苹果","香蕉","orange"]


//响应式特性
function addPrice() {
  car.price+=10000
}
function subPrice() {
  car.price-=10000
}
const num=ref(1);
const totalPrice=computed(()=>{
  return car.price*num.value
})
//监听函数watch
/*watch(num,(value, oldValue, onCleanup)=>{
  console.log("value:",value)
  console.log("oldValue:",oldValue)
  if(num.value >3){
    alert("最多购买3辆")
    num.value=3;
  }
})*/
watchEffect(()=>{
  if(num.value >3){
    alert("最多购买3辆")
    num.value=3;
  }

  if(car.price>10100){
    alert("太贵了");

  }
})
</script>

<template>
  <a v-bind:href="url">跳转{{url}}</a><br>

  <a :href="url">跳转</a><br>
  <button @click="changeUrl">改变地址</button>
<h2>姓名:{{name}}</h2>
  <h2>总价格:{{totalPrice}}</h2>
  <h2>车品牌:{{car.brand}}</h2>
  <h2>车颜色:{{car.color}}</h2>
  <h2>车价格:{{car.price}}</h2>
  <h2>数量:{{num}}</h2>
  <button @click="addPrice">加价</button>
  <button @click="num++">加量</button>
  <button @click="num--">减量</button>
  <button @click="subPrice">降价</button>
  <button v-on:click="buy">购买{{totalPrice}}</button>
  <br>
  <button @click="buy">购买</button>
  <div v-html="msg"></div>
  <div v-text="msg"></div>
  <span style="color: green" v-if="car.price <100000">很便宜</span>
  <span style="color: red" v-else>太贵了</span>
  <br>
<li v-for="item in fruits">{{item}}</li>

</template>

<style scoped>

</style>
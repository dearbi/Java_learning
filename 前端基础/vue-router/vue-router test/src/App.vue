<script setup>

</script>

<template>

  <router-link to="/">首页</router-link>
  <router-link to="/Hello">hello</router-link>
  <router-link to="/Haha">haha</router-link>
  <hr>
  <router-view></router-view>
<!--1.整合vue-router-->
<!-- 2.配置路由出口
    配置路由表
    创建路由器-->
<!-- 3.Vue实例使用router -->
  <!-- 4.配置router-link和router-view -->
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>

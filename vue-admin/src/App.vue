<template>
  <div class="app">


    <router-view></router-view> <!--路由出口 -->
  </div>
</template>

<script>


  export default {
    name: "app"
  };
</script>

<style scoped>
.app{
  height: 100%;
  margin: 0;
  padding: 0;
}

</style>

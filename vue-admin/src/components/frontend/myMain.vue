<template>
  <div style="height: 100%" >
    <el-container >
      <el-header>
        <navMenu></navMenu>
      </el-header>
      <el-main>
        <router-view></router-view> <!--路由出口 -->
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import navMenu from "./navMenu.vue";

  export default {
    name: "myMain",
    components: {
      navMenu
    }
  };
</script>

<style scoped>

  html,body,.el-container{
    height: 100%;
    margin: 0;
    padding: 0;
  }

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    height: 10%;
    margin: 0;
    padding: 0;

  }

  .el-main {
    background-color: #FFF;
    color: #333;
    height: 80%;
    margin: 0;
    padding: 0;


  }

</style>

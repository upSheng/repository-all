<template>
  <div style="height: 100%" >
    <el-container >
      <el-header>
        <NavMenu></NavMenu>
      </el-header>
      <el-main>
        <router-view></router-view> <!--路由出口 -->
      </el-main>
<!--      <el-footer>Footer <a href="tencent://message/?uin=646188530">在线客服①</a></el-footer>-->
    </el-container>
  </div>
</template>

<script>
  import NavMenu from "./NavMenu.vue";

  export default {
    name: "myMain",
    components: {
      NavMenu
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

<template>
  <div style="height: 100%" >

    <el-container>
      <el-aside width="200px">
        <admin-menu></admin-menu>
      </el-aside>
      <el-container>
<!--        <el-header>Header</el-header>-->
        <el-main>
          <router-view></router-view> <!--路由出口 -->
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
  import adminMenu from "./adminMenu";

  export default {
    name: "adminMain",
    components: {
      adminMenu
    }
  };
</script>

<style>

  html,body,.el-container{
    height: 100%;
    margin: 0;
    padding: 0;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    height: 100%;
    margin: 0;
    padding: 0;


  }

  .el-aside {
    /*background-color: #D3DCE6;*/
    color: #333;
    text-align: center;
    line-height: 200px;
  }

</style>

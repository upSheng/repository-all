<template>
  <div style="height: 100%" >

    <el-container>
      <el-aside width="15%">
        <admin-menu></admin-menu>
      </el-aside>
      <el-container>
        <el-header>
            <admin-header></admin-header>
        </el-header>
        <el-main>
          <router-view></router-view> <!--路由出口 -->
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
  import adminMenu from "./adminMenu";
  import adminHeader from "./adminHeader";

  export default {
    name: "adminMain",
    components: {
        adminHeader,
      adminMenu
    }
  };
</script>

<style scoped>

    html,body,.el-container{
        height: 100%;
        margin: 0;
        padding: 0;
    }

    .el-aside {
      background-color: #FFF;
      color: #333;
      text-align: center;
      height: 100%;
    }

    .el-header {

        color: #333;
        text-align: center;
        line-height: 60px;
        border-bottom: solid 1px #e6e6e6;
    }

    .el-main {
      background-color: #FFF;
      color: #333;
      text-align: center;
    }

</style>

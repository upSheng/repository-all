<template>
    <div id="NavMenu">
        <el-menu
                :default-active="activeIndex"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                router
        >
            <!--
            <el-menu-item index="1">电影</el-menu-item>
            <el-menu-item index="2">小说</el-menu-item>
            <el-submenu index="3">
              <template slot="title">我的工作台</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
              <el-menu-item index="3-3">选项3</el-menu-item>
              <el-submenu index="3-4">
                <template slot="title">选项4</template>
                <el-menu-item index="3-4-1">选项1</el-menu-item>
                <el-menu-item index="3-4-2">选项2</el-menu-item>
                <el-menu-item index="3-4-3">选项3</el-menu-item>
              </el-submenu>
            </el-submenu>
            -->

            <template v-for="item in navMenuData">
                <el-menu-item :index="item.index" v-if="item.child.length==0">{{item.name}}</el-menu-item>

                <el-submenu :index="item.index" v-if="item.child.length != 0">
                    <template slot="title">{{item.name}}</template>
                    <template v-for="item2 in item.child">
                        <el-menu-item :index="item2.index">{{item2.name}}</el-menu-item>
                    </template>
                </el-submenu>


            </template>
            <el-menu-item @click="logout"> 退出</el-menu-item>
        </el-menu>


    </div>
</template>

<script>
    export default {
        name: "NavMenu",
        data() {
            return {
                activeIndex: "movie",
                navMenuData: [
                    { index: "webMenu", name: "菜单", child:[] },
                    { index: "movie", name: "电影", child:[] },
                    { index: "novel", name: "小说",child:[] },
                    {
                        index: "2",
                        name: "我的工作台",
                        child: [
                            { index: "2-1", name: "选项1",  child:[] },
                            { index: "2-2", name: "选项2",  child:[] },
                            { index: "2-3", name: "选项3",  child:[] }
                            ]
                    },

                ]
            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
                this.activeIndex = key;

            },
            logout(){
                this.axios.post('/api/logout').then((response) => {
                    console.log(response.data)
                    if(response.data.status == 100){ // 退出码值
                        localStorage.removeItem("jwtToken");
                        this.$router.push('/login');
                    }


                })
            }

        },
        mounted(){
            console.log(this.activeIndex)
            console.log(this.$route.path)
            this.activeIndex = this.$route.path.substring(1,this.$route.path.length);

        }
    };
</script>

<style scoped>
</style>

<template>
    <div id="NavMenu">
        <el-menu
                :default-active="activeIndex"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                router
        >

            <el-menu-item index="/">首页</el-menu-item>
<!--            <el-menu-item index="/order">我的游戏</el-menu-item>-->
            <el-menu-item index="/hot">热游</el-menu-item>
            <el-menu-item index="/help">帮助中心</el-menu-item>



            <el-menu-item style="float: right"  v-show="login">
                <el-dropdown>
                      <span class="el-dropdown-link">
                        {{name}}
                      </span>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item @click="exit">退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </el-menu-item>

            <el-menu-item @click="toLogin" style="float: right"  v-show="!login">
                登入
            </el-menu-item>


        </el-menu>


    </div>
</template>

<script>
    export default {
        name: "NavMenu",
        data() {
            return {
                activeIndex: "/",
                name:"",
                login:false

            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
                this.activeIndex = key;

            },

            exit(){
                localStorage.removeItem("token");
                this.login = false;
                window.location.reload();
            },
            toLogin(){

                this.$router.push('/login');
            },
            checkUser(){

                const token = localStorage.getItem('token');
                if (token == null){
                    this.login = false;
                    return;

                }
                this.axios.get('/checkToken?token=' + token).then((response) => {

                    if (response.data.code == 200 && response.data.data != null) {

                        this.name = response.data.data.name;
                        this.login = true;
                    }else {
                        this.login = false;
                        this.name = "";
                        localStorage.removeItem("token");
                        localStorage.removeItem("userId");
                    }
                })

            }

        },
        mounted(){
            console.log("aaaaa")
            this.checkUser();
        },
        watch: {
            $route(){
                this.checkUser();
            }
        }
    };
</script>

<style scoped>
</style>

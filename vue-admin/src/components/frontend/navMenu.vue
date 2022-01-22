<template>
    <div class="header">
        <div class="header-content">

            <div @click="goPath('/')">
                <i class="el-icon-s-home"></i>首页
            </div>

<!--            <div @click="goPath('/hot')">-->
<!--                <i class="el-icon-s-data"></i>游戏中心-->
<!--            </div>-->

            <div @click="goPath('/gameUser')">
                <i class="el-icon-s-order"></i>我的收藏
            </div>


<!--            <div @click="goPath('/')">-->
<!--                <i class="el-icon-ship"></i>-->
<!--                会员中心-->
<!--            </div>-->

<!--            <div @click="kf">-->
<!--                    <i class="el-icon-headset"></i>联系客服-->

<!--            </div>-->

            <div>

                <div @click="dialogLogin = true" v-show="!login">
                    <i class="el-icon-s-custom"></i>登录
<!--                    <div class="game">免费领取游戏</div>-->
                </div>

                <div @click="exit" v-show="login">

                    {{user.phone}}
                    <i class="el-icon-s-custom"></i>退出

                </div>

            </div>

        </div>

        <!--        dialog-->
        <div>

            <el-dialog width="350px" v-model="dialogLogin">
                <div class="login-content">

                    <div>
                        <div class="title">
                            登入
                        </div>


                        <div>
                            <el-form>
                                <el-input placeholder="请输入手机号" v-model="user.phone">
                                    <template #prepend>+86</template>
                                </el-input>

                                <el-input placeholder="验证码" v-model="user.code">
                                    <template #append>
                                        <el-button @click="getCode">获取验证码</el-button>
                                    </template>
                                </el-input>

                                <el-button @click="loginByCode" type="primary">登入</el-button>

                            </el-form>


                        </div>

                    </div>

                </div>

            </el-dialog>

        </div>


    </div>
</template>

<script>
    import {ElMessage} from 'element-plus'

    export default {
        name: "navMenu",
        data() {
            return {

                user: {code: "", phone: ""},
                login: false,
                dialogLogin: false

            };
        },
        methods: {

            kf(){
                window.open('https://cschat-ccs.aliyun.com/index.htm?tntInstId=_2SHE8Ns&scene=SCE00010820');
            }
            ,
            loginByCode() {

                ElMessage("暂未接入");

                // this.axios.post('/loginByCode', this.user).then((response) => {
                //
                //     if (response.data.code == 200) {
                //
                //         localStorage.setItem("token", response.data.data.token)
                //         localStorage.setItem("userId", response.data.data.userId)
                //         localStorage.setItem("phone", response.data.data.phone)
                //         this.login = true;
                //         this.dialogLogin = false;
                //
                //     } else {
                //         ElMessage(response.data.msg);
                //     }
                // })

            }
            ,

            exit() {
                localStorage.removeItem("token");
                localStorage.removeItem("userId");
                localStorage.removeItem("phone");
                this.login = false;
                window.location.reload();
            },

            goPath(path) {
                if (!this.login){
                    if (path == '/gameUser'){
                        this.dialogLogin = true;
                        return;
                    }
                }
                //path = '/game'+path;
                this.$router.push(path);
            },
            getCode(){

                if (this.user.phone == null || this.user.phone==""){
                    ElMessage("请填写手机号码");
                    return;
                }

                this.axios.get('/getCode?phone='+this.user.phone).then((response) => {

                    if (response.data.code == 200) {
                        //ElMessage("短信发送成功");
                        ElMessage("暂未接入");
                    } else {
                        ElMessage(response.data.msg);
                    }
                })
            },
            checkUser() {

                const token = localStorage.getItem('token');
                if (token == null) {
                    this.login = false;
                    return;

                }
                this.axios.get('/checkToken?token=' + token).then((response) => {



                    if (response.data.code == 200 && response.data.data != null) {
                        console.log(response.data)

                        this.user.phone = response.data.data.phone;
                        this.login = true;
                    } else {
                        this.login = false;
                        this.phone = "";
                        localStorage.removeItem("token");
                        localStorage.removeItem("phone");
                    }
                })

            }

        },
        mounted() {

             this.checkUser();
        },
        watch: {
            // $route() {
            //     this.checkUser();
            // }
        }
    };
</script>

<style scoped>

    .header {

        display: flex;
        align-items: center;
        justify-content: center;
        height: 60px;
        padding: 0 80px;
        background: #2a2a2a;
        color: white;
    }

    .header .header-content {
        display: flex;
        align-items: center;
        justify-content: space-between;
        width: 1220px;
        height: 100%;
    }


    .header-content > div {
        cursor: pointer;
    }


    /*login*/

    .login-content .title {
        font-size: 20px;
        font-weight: 600;
        text-align: center;
        margin-bottom: 20px;
    }


</style>

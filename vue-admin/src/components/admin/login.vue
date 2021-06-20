<template>
    <div class="login-container">

        <el-form class="login-form">

            <el-form-item>
                <div style="text-align: center; font-size: 26px;color: white">
                    系统登录
                </div>
            </el-form-item>
            <el-form-item >
                <el-input  prefix-icon="el-icon-user"  type="text" v-model="phone"></el-input>
            </el-form-item>

            <el-form-item >
                <el-input prefix-icon="el-icon-unlock" type="password" v-model="password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button style="width: 100%"  type="primary" @click="login">登入</el-button>

            </el-form-item>
<!--            <el-form-item>-->

<!--                <el-button style="width: 100%"  type="primary" @click="register">注册</el-button>-->

<!--            </el-form-item>-->
        </el-form>


    </div>
</template>

<script>
    export default {
        name: 'login',
        data() {
            return {
                phone: '',
                password: ''
            };
        },
        methods: {

            login() {

                let param = {"phone":this.phone,"password":this.password};
                this.axios.post('/loginByPassword', param).then((response) => {

                    if (response.data.code == 200) {
                        localStorage.setItem("token", response.data.data.token);
                        localStorage.setItem("phone", response.data.data.phone);
                        this.$router.push('/admin');
                        //window.location.reload();
                    }else {
                        this.$message({
                            message: response.data.msg,
                            duration: 1000,
                            showClose: true,
                            type: 'error'
                        });
                    }
                })
            },
            register(){
                let param = {"name":this.name,"password":this.password};
                this.axios.post('/register', param).then((response) => {

                    if (response.data.code == 200) {
                        this.$message({
                            message: "注册成功",
                            duration: 1000,
                            showClose: true,
                            type: 'success'
                        });
                    }else {
                        this.$message({
                            message: response.data.msg,
                            duration: 1000,
                            showClose: true,
                            type: 'error'
                        });
                    }
                })
            }
        }
    };
</script>


<style scoped>

    .login-container {
        width: 100%;
        height: 100%;
        background-color: #2d3a4b;
    }
    .login-form {
        width: 520px;
        margin: 0 auto;
        padding: 160px 35px 0;
    }


</style>
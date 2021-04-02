<template>
    <div class="login-container">

        <el-form class="login-form">

            <el-form-item>
                <div style="text-align: center; font-size: 26px;color: white">
                    系统登录
                </div>
            </el-form-item>
            <el-form-item >
                <el-input  prefix-icon="el-icon-user"  type="text" v-model="name"></el-input>
            </el-form-item>

            <el-form-item >
                <el-input prefix-icon="el-icon-unlock" type="password" v-model="password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button style="width: 100%"  type="primary" @click="login">登入</el-button>

                <!--<el-button @click="check">check</el-button>-->
            </el-form-item>
        </el-form>


    </div>
</template>

<script>
    export default {
        name: 'login',
        data() {
            return {
                name: '',
                password: ''
            };
        },
        methods: {

            login() {

                let param = new URLSearchParams()
                param.append("name", this.name)
                param.append("password", this.password)

                this.axios.post('/login', param).then((response) => {
                    console.log(response.data)
                    if (response.data.status == 200) {
                        localStorage.setItem("token", response.data.token);
                        this.$router.push('/admin');
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
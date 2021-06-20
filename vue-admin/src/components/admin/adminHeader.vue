<template>
    <div class="user">

        {{phone}}
        <el-button @click="exit">退出</el-button>

    </div>
</template>

<script>


    export default {
        name: "adminHeader",
        data() {
            return {
                phone:''
            };
        },
        methods: {

            checkUser(){
                const token = localStorage.getItem('token');
                if (token == null){
                    this.$router.push('/login');
                }
                this.axios.get('/checkToken?token=' + token).then((response) => {

                    if (response.data.code == 200 && response.data.data != null) {
                        this.phone = response.data.data.phone;
                    }else {
                        this.$router.push('/login');
                    }
                })

            },

            exit(){
                localStorage.removeItem("token");
                localStorage.removeItem("phone");
                this.$router.push('/login');
            }
        },
        mounted() {
            this.checkUser();
        }
    };


</script>

<style scoped>

    .user {
        text-align: right;
    }


</style>

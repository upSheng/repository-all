<template>
    <div style="text-align: right">

        {{name}}
        <el-button @click="exit">退出</el-button>

    </div>
</template>

<script>


    export default {
        name: "adminHeader",
        data() {
            return {
                name:''
            };
        },
        methods: {

            checkUser(){
                const token = localStorage.getItem('token');
                if (token == null){
                    this.$router.push('/login');
                }
                this.axios.get('/checkToken?token=' + token).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200 && response.data.data != null) {
                        this.name = response.data.data.name;
                    }else {
                        this.$router.push('/login');
                    }
                })

            },

            exit(){
                localStorage.removeItem("token");
                this.$router.push('/login');
            }
        },
        mounted() {
            this.checkUser();
        }
    };


</script>

<style scoped>



</style>

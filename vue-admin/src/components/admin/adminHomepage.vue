<template>
    <div>
        后台管理首页
        <el-button @click="btn">接口测试</el-button>
    </div>
</template>

<script>
    export default {
        name: 'adminHomepage',
        data() {
            return {
                productList: [],
                show: false,
                outTradeNo: "",
                qrCode: "",
                payJsOrderId: "",
            };
        },
        methods: {
            btn(){
                this.axios.get('/wheel').then((response) => {
                    console.log(response.data);
                })
            },
            exit(){
                localStorage.removeItem("token");
            }
        },
        mounted() {

        }
    }
</script>
<style scoped>

</style>
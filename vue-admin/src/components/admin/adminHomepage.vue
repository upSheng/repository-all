<template>
    <div>
        后台管理首页

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

        },
        mounted() {

        }
    }
</script>
<style scoped>

</style>
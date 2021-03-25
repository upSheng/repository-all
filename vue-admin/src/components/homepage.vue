<template>
    <div>

        <el-row  v-for="product in productList">

            <el-col :span="6">
                <img  :src=product.img />
            </el-col>

            <el-col :span="6">
                <div>
                    {{product.name}}
                </div>
                <div>
                    {{product.describe}}
                </div>
            </el-col>
            <el-col :span="6">
                <div style="color:#ff6700">
                    {{product.price}}
                </div>
            </el-col>

            <el-col :span="6">

                <el-button @click="open(product.id)">购买</el-button>
            </el-col>
        </el-row>


        <el-dialog :visible.sync="show">
            <img :src="qrCode">
        </el-dialog>



    </div>
</template>

<script>
    export default {
        name: 'homepage',
        data() {
            return {
                productList: [],
                show:false,
                outTradeNo:"",
                qrCode:""
            };
        },
        methods: {

            open(id){
                this.axios.post('/placeOrder?id='+id).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.qrCode = response.data.data.qrCode;
                        this.outTradeNo = response.data.data.outTradeNo;
                        this.show = true;
                        this.lunxun(this.outTradeNo);
                    }
                })

            },
            init(){
                this.axios.get('/listProduct').then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.productList = response.data.data;
                    }
                })
            },

            lunxun(outTradeNo){
                var l;
                l = setInterval(() =>{
                    if (!this.show){
                        clearInterval(l);
                    }
                    this.axios.get('/findOrder?id='+outTradeNo).then((response) => {
                        if (response.data.code == 200) {
                            if(response.data.data.status ==1){
                                console.log("支付成功")

                                var orderList = JSON.parse(localStorage.getItem("orderIdList"));
                                if (orderList == null){
                                    orderList = [];
                                }
                                orderList.push({"id":response.data.data.transactionId});
                                localStorage.setItem("orderIdList",JSON.stringify(orderList));
                                this.show = false;
                                clearInterval(l);
                                this.$router.push('/order');


                            }
                        }
                    })
                },6000)
            }

        },
        mounted() {
            this.init();

        }
    }
</script>
<style scoped>

</style>
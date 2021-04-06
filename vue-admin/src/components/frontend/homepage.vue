<template>
    <div>

        <el-row style="margin-top: 30px; margin-left: 300px; margin-right: 300px" align="middle" type="flex" v-for="index of Math.ceil(productList.length/3)">

            <el-col :span="8" v-for="product in productList.slice((index-1)*3,index*3)">

                <div style="margin: 10px;">
                    <div>
                        <a target="_blank"  :href="product.steamUrl">
                        <img style="border-radius: 10px 10px 0 0; width: 100%; display: block" :src=product.img />
                        </a>
                    </div>

                    <div style="background-color: rgb(42, 46, 51);color: white; border-radius: 0 0 10px 10px; padding: 10px">

                        <div style="text-align: left;">
                            {{product.name}}
                        </div>
                        <div style="text-align: left; height: 105px">
                            {{product.describe}}

                        </div>
                        <div style="margin-top: 10px">
                            <div style="display: inline-block; background-color: #22ac38; margin-left: 20px; width: 100px; border-radius:5px">-11%</div>
                            <div style="display: inline-block; text-decoration: line-through; margin-left: 20px; width: 100px; ">￥158</div>
                            <div style="display: inline-block; font-size: 30px ; margin-left: 50px; width: 100px; ">
                                <el-button @click="open(product.id)">￥{{product.price/100}}购买</el-button>
                            </div>

                        </div>
                    </div>
                </div>

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
                show: false,
                outTradeNo: "",
                qrCode: "",
                payJsOrderId: "",
            };
        },
        methods: {

            open(id) {
                this.axios.post('/placeOrder?id=' + id).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.qrCode = response.data.data.qrCode;
                        this.outTradeNo = response.data.data.outTradeNo;
                        this.payJsOrderId = response.data.data.payJsOrderId;
                        this.show = true;
                        this.lunxun(this.payJsOrderId);
                    }
                })

            },
            loadProduct() {
                this.axios.post('/searchProduct', {"pageSize":100}).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.productList = response.data.data.content;

                    }
                })
            }
            ,

            lunxun(payJsOrderId) {
                var l;
                l = setInterval(() => {
                    if (!this.show) {
                        clearInterval(l);
                    }
                    this.axios.get('/findOrderByPayJsOrderId?payJsOrderId=' + payJsOrderId).then((response) => {
                        if (response.data.code == 200) {
                            if (response.data.data.status == 1) {
                                console.log("支付成功")

                                var orderList = JSON.parse(localStorage.getItem("orderList"));
                                if (orderList == null) {
                                    orderList = [];
                                }
                                orderList.push({"transactionId": response.data.data.transactionId});
                                localStorage.setItem("orderList", JSON.stringify(orderList));
                                this.show = false;
                                clearInterval(l);
                                this.$router.push('/order');
                            }
                        }
                    })
                }, 6000)
            }

        },
        mounted() {
            this.loadProduct();
        }
    }
</script>
<style scoped>

</style>
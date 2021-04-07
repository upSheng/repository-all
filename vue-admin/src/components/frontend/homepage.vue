<template>
    <div>

        <el-row style="margin-left: 300px; margin-right: 300px">

            <el-col style="padding: 10px" :span="6">
                    <el-input
                            placeholder="请输入内容"
                            prefix-icon="el-icon-search"
                            v-model="param.keys"
                    >
                    </el-input>

            </el-col>

            <el-col style="padding: 10px" :span="1">
                <el-button  @click="search">搜索</el-button>
            </el-col>

        </el-row>
        <el-row style="margin-left: 300px; margin-right: 300px;">
            <el-col style="margin-left: 10px; text-align: left" :span="6">
                    <el-radio-group @change="labelChange"  v-model="param.label" size="small">
                        <el-radio-button label="1">热门新游</el-radio-button>
                        <el-radio-button label="2">经典大作</el-radio-button>
                        <el-radio-button label="">全部游戏</el-radio-button>
                    </el-radio-group>

            </el-col>
        </el-row>
        <el-row style="margin-left: 300px; margin-right: 300px; margin-top: 10px">
            <el-col style="margin-left: 10px; text-align: left" :span="1">
                <a href="tencent://message/?uin=646188530">
                    <img style="" src="http://demo.lanrenzhijia.com/2014/service1031/images/online.png" alt="点击这里给我发消息" title="点击这里给我发消息"/>
                </a>
            </el-col>

        </el-row>
        <el-row style="margin-top: 10px; margin-left: 300px; margin-right: 300px"  v-for="index of Math.ceil(productList.length/3)">
            <el-col style="padding: 10px" :span="8" v-for="product in productList.slice((index-1)*3,index*3)">

                    <div>
                        <a target="_blank"  :href="product.steamUrl">
                        <img style="border-radius: 10px 10px 0 0; width: 100%; display: block" :src=product.img />
                        </a>
                    </div>

                    <div style="background-color: rgb(42, 46, 51);color: white; border-radius: 0 0 10px 10px; padding: 10px">

                        <div style="text-align: left;">
                            {{product.name}}
                        </div>
                        <div style="text-align: left; height: 90px">
                            {{product.describe}}

                        </div>
                        <div style="margin-top: 10px">
                            <div style="display: inline-block; background-color: #22ac38; width: 100px; border-radius:5px;">-{{(product.oriPrice-product.price)/product.oriPrice * 100}}%</div>
                            <div style="display: inline-block; text-decoration: line-through; margin-left: 10px; width: 100px; ">￥{{product.oriPrice/100}}</div>
                            <div style="display: inline-block; font-size: 30px ; margin-left: 50px; width: 100px; ">
                                <el-button @click="open(product.id)">￥{{product.price/100}}购买</el-button>
                            </div>
                        </div>
                    </div>


            </el-col>
        </el-row>




        <el-dialog :visible.sync="show">

            <img :src="qrCode">

            <div>微信支付</div>
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
                key:"",
                param:{"pageSize":100,"pageNum":1,label:"",keys:""}
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
                this.axios.post('/searchProduct', this.param).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.productList = response.data.data.content;
                    }
                })
            },
            labelChange(){
                this.loadProduct();
            },

            search(){
                this.loadProduct();
            },

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
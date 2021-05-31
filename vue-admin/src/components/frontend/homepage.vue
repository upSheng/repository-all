<template>
    <div class="homepage" >

        <el-row>

            <el-col :span="8">
                    <el-input
                            placeholder="请输入内容"
                            prefix-icon="el-icon-search"
                            v-model="param.keys"
                    >
                    </el-input>

            </el-col>

            <el-col :span="8">
                <el-button  @click="search">搜索</el-button>
            </el-col>


        </el-row>
        <el-row>
            <el-col :span="10">
                    <el-radio-group @change="labelChange"  v-model="param.label" size="small">
                        <el-radio-button label="3">本周免费</el-radio-button>
                        <el-radio-button label="1">热门新游</el-radio-button>
                        <el-radio-button label="2">经典大作</el-radio-button>
                        <el-radio-button label="">全部游戏</el-radio-button>
                    </el-radio-group>

            </el-col>
        </el-row>
        <el-row>
            <el-col :span="10">
                <el-radio-group @change="labelChange"  v-model="param.own" size="small">
                    <el-radio-button label="1">已拥有</el-radio-button>
                    <el-radio-button label="0">未拥有</el-radio-button>
                </el-radio-group>

            </el-col>
        </el-row>
        <el-row>
            <el-col :span="1">
                <a href="tencent://message/?uin=646188530">
                    <img style="" src="http://demo.lanrenzhijia.com/2014/service1031/images/online.png" alt="点击这里给我发消息" title="点击这里给我发消息"/>
                </a>
            </el-col>

        </el-row>
        <el-row :gutter="20">
            <el-col class="product"  :span="8" v-for="product in productList" :key="product">

                    <div >
                        <a target="_blank"  :href="product.steamUrl">
                        <img class="img"  :src=product.img />
                        </a>
                    </div>

                    <div class="describe">

                        <div>
                            {{product.name}}
                        </div>

                        <div style="margin-top: 10px">
                            <div style="display: inline-block; background-color: #22ac38; width: 100px; border-radius:5px;">-{{((product.oriPrice-product.price)/product.oriPrice * 100).toFixed(2)}}%</div>
                            <div style="display: inline-block; text-decoration: line-through; margin-left: 10px; width: 100px; ">￥{{product.oriPrice/100}}</div>
                            <div style="display: inline-block; font-size: 30px ;width: 50px; ">
                                <el-button v-if="actionShow(product) == 0" @click="freeShow(product.id)">查看</el-button>
                                <el-button v-if="actionShow(product) == 1" @click="freeShow(product.id)">免费获取</el-button>
                                <el-button v-if="actionShow(product) == 2" @click="open(product.id)">￥{{product.price/100}}购买</el-button>
                            </div>
                        </div>
                    </div>
            </el-col>
        </el-row>




        <el-dialog v-model="show">

            <div style="text-align: center">
                <img :src="qrCode">
                <div>微信支付</div>
            </div>

        </el-dialog>

        <el-dialog v-model="account.show">

            <div style="margin: 0 auto;width: 500px;">
                账号: {{account.account}} <br>
                密码: {{account.password}}
            </div>



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
                param:{"pageSize":100,"pageNum":1,label:"",keys:"",own:0},
                account:{show:false}
            };
        },
        methods: {


            open: function (id) {

                let token = localStorage.getItem("token");
                if (token == null){
                    this.$router.push('/login');
                    return
                }
                let userId = localStorage.getItem("userId");
                this.axios.post('/placeOrder?id=' + id + '&userId=' + userId).then((response) => {

                    if (response.data.code == 200) {
                        this.qrCode = response.data.data.qrCode;
                        this.outTradeNo = response.data.data.outTradeNo;
                        this.payJsOrderId = response.data.data.payJsOrderId;
                        this.show = true;
                        this.lunxun(this.payJsOrderId);
                    }
                })

            },

            freeShow(id) {



                var param = "id=" + id;
                var userId = localStorage.getItem("userId");
                if (userId != null){
                    param = param + '&userId=' + userId;
                }

                this.axios.post('/searchGameAccount?'+ param).then((response) => {

                    if (response.data.code == 200) {

                        this.account.account  = response.data.data.account;
                        this.account.password  = response.data.data.password;
                        this.account.show = true;
                    }
                })

            },
            loadProduct() {
                let userId = localStorage.getItem("userId");
                this.param.userId = userId;
                this.axios.post('/searchProduct', this.param).then((response) => {

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
                                window.location.reload();
                            }
                        }
                    })
                }, 6000)
            },
            actionShow(product) {
                const token = localStorage.getItem('token');

                // 查看
                if (token != null && product.own == 1){
                    return 0;
                }

                // 免费获取
                if (product.label ==3){
                    return 1;
                }

                // 购买
                return 2;
            }
        },
        mounted() {
            this.loadProduct();
        }
    }
</script>
<style scoped>

    .homepage {
        width: 80%;
        margin: 0 auto;
    }

    .homepage>.el-row {
        margin-top: 10px;
    }

    .product {
        margin-top: 20px;
        height: 300px;
    }

    .img {
        border-radius: 10px 10px 0 0;
        width: 100%;
        display: block
    }

    .describe {
        background-color: rgb(42, 46, 51);
        color: white;
        border-radius: 0 0 10px 10px;
        padding: 10px
    }





</style>
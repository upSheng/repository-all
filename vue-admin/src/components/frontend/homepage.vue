<template>
    <div class="homepage" >

        <div class="productBox">
            <div class="product"  v-for="game in gameList" :key="game">
                <div >
                    <a target="_blank"  :href="game.steamUrl">
                        <img class="img"  :src=game.steamImg />
                    </a>
                </div>
                <div class="desc">
                    <div>
                        {{game.name}}
                    </div>

                    <div>
                        {{game.price/100}}
                    </div>

                    <div>
                        <el-button @click="open(game.id)">购买</el-button>
                    </div>
                </div>
            </div>
        </div>





        <el-dialog v-model="show">

            <div>
                <img :src="qrCode">
                <div>
                    <el-input v-model="placeOrderParam.phone"></el-input>
                    <el-button @click="phoneOk">确定</el-button>
                </div>

            </div>

        </el-dialog>




    </div>
</template>

<script>
    export default {
        name: 'homepage',
        data() {
            return {

                gameList: [],
                param:{"pageSize":100,"pageNum":1},
                placeOrderParam:{phone:"",gameId:""},
                qrCode: "",
                orderId:"",
                show: false,
            };
        },
        methods: {

            phoneOk(){

                if (this.placeOrderParam.phone == null || this.placeOrderParam.phone==""){
                    return;
                }

                this.axios.post('/placeOrder',this.placeOrderParam).then((response) => {

                    if (response.data.code == 200) {
                        this.qrCode = response.data.data.qrCode;
                        this.orderId = response.data.data.orderId;
                        this.lunxun(this.orderId);
                    }
                })
            }

            ,
            open: function (id) {

                this.qrCode = "";
                this.placeOrderParam.gameId = id;

                let phone = localStorage.getItem("phone");
                if (phone != null && phone != ""){
                    this.placeOrderParam.phone = phone;
                }
                this.show = true;
            },

            loadProduct() {

                this.axios.post('/searchGame', this.param).then((response) => {

                    if (response.data.code == 200) {
                        this.gameList = response.data.data.content;
                    }
                })
            },



            lunxun(orderId) {
                var l;
                l = setInterval(() => {
                    if (!this.show) {
                        clearInterval(l);
                    }
                    this.axios.get('/findByOrderId?orderId=' + orderId).then((response) => {
                        if (response.data.code == 200) {
                            if (response.data.data.status == 1) {
                                console.log("支付成功")

                                // var orderList = JSON.parse(localStorage.getItem("orderList"));
                                // if (orderList == null) {
                                //     orderList = [];
                                // }
                                // orderList.push({"transactionId": response.data.data.transactionId});
                                // localStorage.setItem("orderList", JSON.stringify(orderList));
                                this.show = false;
                                clearInterval(l);
                                // window.location.reload();
                            }
                        }
                    })
                }, 6000)
            },

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

    .productBox {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .productBox .product {

        width: 32%;
        margin-top: 10px;

    }

    .product .img {
        border-radius: 10px 10px 0 0;
        width: 100%;
        display: block
    }

    .desc {
        display: flex;
        justify-content: space-between;
    }

    /*.homepage>.el-row {*/
    /*    margin-top: 10px;*/
    /*}*/

    /*.product {*/
    /*    margin-top: 20px;*/
    /*    height: 300px;*/
    /*}*/



    /*.describe {*/
    /*    background-color: rgb(42, 46, 51);*/
    /*    color: white;*/
    /*    border-radius: 0 0 10px 10px;*/
    /*    padding: 10px*/
    /*}*/





</style>
<template>
    <div class="detail" >


        <div style="margin-bottom: 50px;font-size: 30px; text-align: center">
            详情页
        </div>

        {{game}}

    </div>
</template>

<script>
    export default {
        name: 'detail',
        data() {
            return {

                game:{},
                gameList: [],
                param:{"pageSize":100,"pageNum":1,id:1},
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
            },

            loadProduct() {

                this.param.id  = this.$route.params.id;

                this.axios.post('/searchGame', this.param).then((response) => {

                    if (response.data.code == 200) {
                        this.gameList = response.data.data.content;

                        this.game = this.gameList[0];

                    }
                })
            },



        },


        mounted() {

            this.loadProduct();
            // console.log(this.$route.params)
        }
    }
</script>
<style scoped>






</style>
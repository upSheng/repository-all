<template>
    <div>

        <el-row>
            <el-col :span="6">
                <el-input placeholder="微信支付交易号" v-model="transactionId"></el-input>
                <div>
                    {{orderAward.account}}
                    {{orderAward.password}}
                </div>

                <div>
                    {{content}}
                </div>

            </el-col>
            <el-col :span="1">
                <el-button @click="search">查询</el-button>
                历史订单
                <div v-for="order in orderList ">
                    {{order.transactionId}}
                </div>
            </el-col>
            <el-col :span="12">

            </el-col>
        </el-row>


    </div>
</template>

<script>
    export default {
        name: 'order',
        data() {
            return {

                orderAward: {},
                transactionId: "",
                content: "",
                orderList: []
            };
        },
        methods: {

            search() {

                this.axios.post('/findAward?transactionId=' + this.transactionId).then((response) => {
                    console.log(response.data)
                    if (response.data.data != null && response.data.code == 200) {
                        this.orderAward = response.data.data;
                        this.content = "";

                    } else {
                        this.orderAward = {};
                        this.content = "无此订单";
                    }
                })

            },

        },
        mounted() {

            this.orderList = JSON.parse(localStorage.getItem("orderList"));
            console.log(this.orderList);

            if (this.orderList != null && this.orderList.length > 0) {
                this.transactionId = this.orderList[this.orderList.length - 1].transactionId;
                this.search();
            }
        }
    }
</script>
<style scoped>

</style>
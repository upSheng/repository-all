<template>
    <div>

        <el-row>
            <el-col :span="6">
                <el-input placeholder="微信支付交易号" v-model="orderId"></el-input>
                <div>
                    {{productName}}
                </div>

                <div>
                    {{content}}
                </div>

            </el-col>
            <el-col :span="1">
                <el-button @click="search">查询</el-button>
                历史订单
                <div v-for="orderId in orderIdList ">
                    {{orderId.id}}
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
                orderId:"",
                productName:"",
                content:"",
                orderIdList:[]
            };
        },
        methods: {

            search() {

                this.axios.get('/findOrder?id=' + this.orderId).then((response) => {
                    console.log(response.data)
                    if (response.data.data != null && response.data.code == 200) {
                            if (response.data.data.status==1){
                                this.productName = response.data.data.productName;
                                this.content="老板发财";
                            }
                    }else {
                        this.productName = "无此订单";
                        this.content="";
                    }
                })

            },

        },
        mounted(){

            this.orderIdList = JSON.parse(localStorage.getItem("orderIdList"));
            console.log(this.orderIdList);

            if (this.orderIdList != null && this.orderIdList.length>0){
                this.orderId = this.orderIdList[this.orderIdList.length-1].id;
                this.search();
            }
        }
    }
</script>
<style scoped>

</style>
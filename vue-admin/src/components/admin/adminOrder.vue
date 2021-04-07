<template>
    <div>

        <div style="margin: 10px;text-align: left">
            <el-input placeholder="名称" style="width: 300px" v-model="param.productName"></el-input> <el-button @click="search">搜索</el-button>

        </div>




        <div style="margin: 10px">
            <el-table
                    :data="orderData"
                    border
                    style="width: 100%">

                <el-table-column
                        prop="createTime"
                        label="创建时间"
                        :formatter="((row,column)=>{return new Date(row.createTime).Format('yyyy-MM-dd hh:mm:ss')})"
                >
                </el-table-column>

                <el-table-column
                        prop="transactionId"
                        label="微信支付号"
                >
                </el-table-column>
                <el-table-column
                        prop="productId"
                        label="商品id"
                >
                </el-table-column>
                <el-table-column
                        prop="productName"
                        label="名称"
                >

                </el-table-column>

                <el-table-column
                        prop="totalFee"
                        label="价格"
                        :formatter="((row,column)=>{return row.totalFee/100})"
                >
                </el-table-column>
                <el-table-column
                        prop="status"
                        label="状态"
                        :formatter="((row,column)=>{return row.status==1?'支付成功':'未支付'})"
                >
                </el-table-column>

            </el-table>
        </div>



        <div style="margin: 10px">
            <el-pagination
                    background
                    layout="prev, pager, next"
                    @current-change="curChange"
                    :current-page="param.pageNum"
                    :total="total"
                    :page-size="param.pageSize">
            </el-pagination>
        </div>


    </div>
</template>

<script>
    export default {
        name: 'adminOrder',
        data() {
            return {
                orderData:[],
                total:100,
                param:{"pageSize":5,"pageNum":1,"productName":""},
            };
        },
        methods: {

            search(){
                this.param.pageNum =1;
                this.loadOrder();
            },

            loadOrder() {
                this.axios.post('/listOrder', this.param).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.orderData = response.data.data.content;
                        this.total = response.data.data.count;

                    }
                })
            },
            curChange(pageNum){
                this.param.pageNum = pageNum;
                this.loadOrder();
            },

        },
        mounted() {
            this.loadOrder();
        }
    }
</script>
<style scoped>

</style>
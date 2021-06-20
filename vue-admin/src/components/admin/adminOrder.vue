<template>
    <div class="order">

        <div >
            <el-input class="search" placeholder="订单号/名称/电话"  v-model="param.name"></el-input> <el-button @click="search">搜索</el-button>

        </div>

        <div>
            <el-table
                    :data="orderData"
                    border
                    height="500"
                    style="width: 100%">


                <el-table-column
                        prop="orderId"
                        label="订单号"
                >
                </el-table-column>

                <el-table-column
                        prop="phone"
                        label="电话"
                >
                </el-table-column>

                <el-table-column
                        prop="transactionId"
                        label="微信支付号"
                >
                </el-table-column>
                <el-table-column
                        prop="gameId"
                        label="游戏Id"
                >
                </el-table-column>
                <el-table-column
                        prop="gameName"
                        label="名称"
                >

                </el-table-column>

                <el-table-column
                        prop="totalFee"
                        label="价格(元)"
                        :formatter="((row,column)=>{return row.totalFee/100})"
                >
                </el-table-column>
                <el-table-column
                        prop="status"
                        label="状态"
                        :formatter="((row,column)=>{return row.status==1?'支付成功':'未支付'})"
                >
                </el-table-column>

                <el-table-column
                        prop="timeEnd"
                        label="支付时间"
                        :formatter="((row,column)=>{return new Date(row.timeEnd).Format('yyyy-MM-dd hh:mm:ss')})"
                >
                </el-table-column>

                <el-table-column
                        prop="createTime"
                        label="创建时间"
                        :formatter="((row,column)=>{return new Date(row.createTime).Format('yyyy-MM-dd hh:mm:ss')})"
                >
                </el-table-column>

            </el-table>
        </div>



        <div>
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
                param:{"pageSize":10,"pageNum":1,"name":""},
            };
        },
        methods: {

            search(){
                this.param.pageNum =1;
                this.loadOrder();
            },

            loadOrder() {
                this.axios.post('/listOrder', this.param).then((response) => {

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

    .order {

        text-align: left
    }

    .order>div {
        margin-top: 10px;
    }

    .search {
       width: 300px;
    }

    .el-pagination {
        text-align: center;
    }

</style>
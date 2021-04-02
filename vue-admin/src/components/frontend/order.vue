<template>
    <div>

        <el-table
                :data="orderAwardList"
                style="width: 100%">
            <el-table-column
                    prop="createTime"
                    label="订单时间"
            ></el-table-column>
            <el-table-column
                    prop="transactionId"
                    label="单号"
            >
            </el-table-column>

            <el-table-column
                    prop="name"
                    label="物品"
            ></el-table-column>

            <el-table-column
                    prop="account"
                    label="账号"
            >
            </el-table-column>
            <el-table-column
                    prop="password"
                    label="密码">
            </el-table-column>
        </el-table>


    </div>
</template>

<script>
    export default {
        name: 'order',
        data() {
            return {
                orderAwardList: []
            };
        },
        methods: {


            findAwardList() {

                const orderList = JSON.parse(localStorage.getItem("orderList"));
                const transactionIdList = [];
                for (var i = 0; i < orderList.length; i++) {
                    transactionIdList.push(orderList[i].transactionId);
                }

                let param = new URLSearchParams()
                param.append("transactionIdList", transactionIdList)

                this.axios.post('/findAwardList', transactionIdList).then((response) => {
                    console.log(response.data)
                    if (response.data.data != null && response.data.code == 200) {
                        this.orderAwardList = response.data.data;
                    } else {
                        this.orderAwardList = [];
                    }
                })
            }

        },
        mounted() {
            this.findAwardList();
        }
    }
</script>
<style scoped>

</style>
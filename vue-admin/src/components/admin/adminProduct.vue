<template>
    <div>

            <div style="margin: 10px;text-align: left">
                <el-input placeholder="名称" style="width: 300px" v-model="param.name"></el-input> <el-button @click="search">搜索</el-button>
                <br><br>

                <el-button @click="newOpen"  size="small" type="primary" icon="el-icon-circle-plus-outline">添加</el-button>

            </div>




            <div style="margin: 10px">
                <el-table
                        :data="productData"
                        border
                        style="width: 100%">

                    <el-table-column
                            prop="createTime"
                            label="创建时间"
                    >
                    </el-table-column>

                    <el-table-column
                            prop="name"
                            label="名称"
                    >
                    </el-table-column>
                    <el-table-column
                            prop="describe"
                            label="描述"
                    >

                    </el-table-column>

                    <el-table-column
                            prop="price"
                            label="价格"
                    >
                    </el-table-column>
                    <el-table-column
                            prop="quantity"
                            label="销量"
                    >
                    </el-table-column>


                    <el-table-column
                            prop="steamUrl"
                            label="steam链接"
                    >
                    </el-table-column>
                    <el-table-column
                            prop="account"
                            label="账号"
                    >
                    </el-table-column>
                    <el-table-column
                            prop="password"
                            label="密码"
                    >
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="操作"
                            width="100">
                        <template slot-scope="scope">
                            <el-button @click="editOpen(scope.$index)" type="text" size="small">编辑</el-button>
                            <el-button @click="deleteProduct(scope.row.id)" type="text" size="small">删除</el-button>
                        </template>
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


            <el-dialog
                    title="编辑"
                    :visible.sync="editShow"
                    width="80%"
                    center>

                <el-form label-position="right" label-width="100px" :model="productEdit">
                    <el-form-item label="名称">
                        <el-input v-model="productEdit.name"></el-input>
                    </el-form-item>
                    <el-form-item label="描述">
                        <el-input v-model="productEdit.describe"></el-input>
                    </el-form-item>
                    <el-form-item label="价格">
                        <el-input v-model="productEdit.price"></el-input>
                    </el-form-item>
                    <el-form-item label="销量">
                        <el-input v-model="productEdit.quantity"></el-input>
                    </el-form-item>
                    <el-form-item label="steam链接">
                        <el-input v-model="productEdit.steamUrl"></el-input>
                    </el-form-item>

                    <el-form-item label="账号">
                        <el-input v-model="productEdit.account"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="productEdit.password"></el-input>
                    </el-form-item>
                </el-form>

                <span slot="footer" class="dialog-footer">
                    <el-button @click="editShow = false">取 消</el-button>
                    <el-button type="primary" @click="saveProduct">确 定</el-button>
                </span>
            </el-dialog>

    </div>
</template>

<script>
    export default {
        name: 'adminProduct',
        data() {
            return {
                productData:[],
                total:100,
                param:{"pageSize":5,"pageNum":1,"name":""},
                productEdit:{},
                editShow:false
            };
        },
        methods: {

            search(){
                this.param.pageNum =1;
                this.loadProduct();
            },

            loadProduct() {
                this.axios.post('/listProduct', this.param).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.productData = response.data.data.content;
                        this.total = response.data.data.count;

                    }
                })
            },
            deleteProduct(id) {
                this.axios.get('/deleteProduct?id='+id).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.$message({
                            message: '删除成功',
                            duration: 1000,
                            showClose: true,
                            type: 'success'
                        });
                        this.search();
                    }
                })
            },
            saveProduct() {

                if (this.productEdit == null){

                    this.$message({
                        message: '参数填写不全',
                        duration: 1000,
                        showClose: true,
                        type: 'error'
                    });
                    return;
                }
                this.axios.post('/saveProduct', this.productEdit).then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.editShow = false;
                        this.$message({
                            message: '保存成功',
                            duration: 1000,
                            showClose: true,
                            type: 'success'
                        });
                        this.loadProduct();

                    }
                })
            },
            handleClick(row){
                console.log(row);
            },

            curChange(pageNum){
                this.param.pageNum = pageNum;
                this.loadProduct();
            },
            editOpen(index){
                this.editShow = true;
                this.productEdit = this.productData[index];
            },

            newOpen(){
                this.editShow = true;
                this.productEdit = {};
            },


        },
        mounted() {
            this.loadProduct();
        }
    }
</script>
<style scoped>

</style>
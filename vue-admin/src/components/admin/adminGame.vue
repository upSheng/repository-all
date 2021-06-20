<template>
    <div class="game">

            <div>
                <el-input class="search" placeholder="名称/appId" v-model="param.name"></el-input> <el-button  @click="search">搜索</el-button>
            </div>
            <div>
                <el-button @click="newOpen"  size="small" type="primary" icon="el-icon-circle-plus-outline">添加</el-button>
            </div>

            <div>
                <el-table
                        :data="gameData"
                        border
                        height="400"
                        style="width: 100%">



                    <el-table-column
                            prop="appId"
                            label="appId"
                    >
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            label="名称"
                    >
                    </el-table-column>
                    <el-table-column
                            prop="nameEn"
                            label="英文名称"
                    >
                    </el-table-column>

                    <el-table-column
                            prop="oriPrice"
                            label="原价(分)"
                    >
                    </el-table-column>

                    <el-table-column
                            prop="price"
                            label="价格(分)"
                    >
                    </el-table-column>

                    <el-table-column
                            prop="weight"
                            label="权重"
                    >
                    </el-table-column>
<!--                    <el-table-column-->
<!--                            prop="label"-->
<!--                            label="标签"-->
<!--                            :formatter="((row,column)=>{-->
<!--                                if (row.label == 1){-->
<!--                                    return '热门新游';-->
<!--                                }-->
<!--                                if (row.label == 2){-->
<!--                                    return '经典大作';-->
<!--                                }-->
<!--                                if (row.label == 3){-->
<!--                                    return '免费';-->
<!--                                }-->
<!--                                return '';-->
<!--                            })"-->
<!--                    >-->
<!--                    </el-table-column>-->

                    <el-table-column
                            show-overflow-tooltip
                            prop="steamImg"
                            label="图片"
                    >

                        <template #default="scope" >
                            <a target="_blank"  :href="scope.row.steamUrl">
                                <img :src="scope.row.steamImg" style="width: 100px" alt="">
                            </a>
                        </template>
                    </el-table-column>

                    <el-table-column
                            prop="createTime"
                            label="创建时间"
                            :formatter="((row,column)=>{return new Date(row.createTime).Format('yyyy-MM-dd hh:mm:ss')})"
                    >
                    </el-table-column>

                    <el-table-column
                            fixed="right"
                            label="操作"
                            width="100">
                        <template #default="scope">
                            <el-button @click="editOpen(scope.$index)" type="text" size="small">编辑</el-button>
                            <el-button @click="deleteProduct(scope.row.id)" type="text" size="small">删除</el-button>
                        </template>
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


            <el-dialog
                    title="编辑"
                    v-model="editShow"
                    width="80%"
                    center>

                <el-form label-position="right" label-width="100px" :model="gameEdit">
                    <el-form-item label="appId">
                        <el-input v-model="gameEdit.appId"></el-input>
                    </el-form-item>

                    <el-form-item label="价格(分)">
                        <el-input v-model="gameEdit.price"></el-input>
                    </el-form-item>

                    <el-form-item label="名称">
                        <el-input v-model="gameEdit.name"></el-input>
                    </el-form-item>

                    <el-form-item label="英文名称">
                        <el-input v-model="gameEdit.nameEn"></el-input>
                    </el-form-item>
                    <el-form-item label="游戏信息">
                        <el-input type="textarea" autosize v-model="gameEdit.info"></el-input>
                    </el-form-item>

                    <el-form-item label="原价(分)">
                        <el-input v-model="gameEdit.oriPrice"></el-input>
                    </el-form-item>

                    <el-form-item label="权重">
                        <el-input v-model="gameEdit.weight"></el-input>
                    </el-form-item>

<!--                    <el-form-item label="标签">-->
<!--                        <el-radio-group   v-model="productEdit.label" size="small">-->
<!--                            <el-radio-button label="0">无</el-radio-button>-->
<!--                            <el-radio-button label="1">热门新游</el-radio-button>-->
<!--                            <el-radio-button label="2">经典大作</el-radio-button>-->
<!--                            <el-radio-button label="3">免费</el-radio-button>-->
<!--                        </el-radio-group>-->
<!--                    </el-form-item>-->





                </el-form>

                <span class="dialog-footer">
                    <el-button @click="editShow = false">取 消</el-button>
                    <el-button type="primary" @click="saveGame">确 定</el-button>
                </span>
            </el-dialog>

    </div>
</template>

<script>
    export default {
        name: 'adminGame',
        data() {
            return {
                gameData:[],
                total:100,
                param:{"pageSize":10,"pageNum":1,"name":""},
                gameEdit:{},
                editShow:false
            };
        },
        methods: {

            search(){
                this.param.pageNum =1;
                this.loadGame();
            },

            loadGame() {
                this.axios.post('/listGame', this.param).then((response) => {

                    if (response.data.code == 200) {

                        this.gameData = response.data.data.content;
                        this.total = response.data.data.count;

                    }
                })
            },
            deleteGame(id) {
                this.axios.get('/deleteGame?id='+id).then((response) => {

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
            saveGame() {

                if (this.gameEdit == null){

                    this.$message({
                        message: '参数填写不全',
                        duration: 1000,
                        showClose: true,
                        type: 'error'
                    });
                    return;
                }
                this.axios.post('/saveGame', this.gameEdit).then((response) => {

                    if (response.data.code == 200) {
                        this.editShow = false;
                        this.$message({
                            message: '保存成功',
                            duration: 1000,
                            showClose: true,
                            type: 'success'
                        });
                        this.loadGame();

                    }
                })
            },
            handleClick(row){
                console.log(row);
            },

            curChange(pageNum){
                this.param.pageNum = pageNum;
                this.loadGame();
            },
            editOpen(index){
                this.editShow = true;
                this.gameEdit = this.gameData[index];
            },

            newOpen(){
                this.editShow = true;
                this.gameEdit = {};
            },

            dateFormat(fmt, date) {
                let ret;
                const opt = {
                    "Y+": date.getFullYear().toString(),        // 年
                    "m+": (date.getMonth() + 1).toString(),     // 月
                    "d+": date.getDate().toString(),            // 日
                    "H+": date.getHours().toString(),           // 时
                    "M+": date.getMinutes().toString(),         // 分
                    "S+": date.getSeconds().toString()          // 秒
                    // 有其他格式化字符需求可以继续添加，必须转化成字符串
                };
                for (let k in opt) {
                    ret = new RegExp("(" + k + ")").exec(fmt);
                    if (ret) {
                        fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
                    }
                }
                return fmt;
            }


        },
        mounted() {
            this.loadGame();
        }
    }
</script>
<style scoped>

    .product {
        text-align: left;
        margin-left: 10px
    }

    .product>div {
         margin-top: 10px
    }

    .search {
        width: 300px;
    }
    .el-pagination {
        text-align: center;
    }
</style>
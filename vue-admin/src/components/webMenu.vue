<template>
    <div>

        <el-row>
            <el-col :span="6">
                <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>

                <el-button @click="addWebMenu">添加树</el-button>
                <el-button @click="addWebMenu">添加节点</el-button>
                <el-button @click="addWebMenu">删除</el-button>

            </el-col>
            <el-col :span="18">
                <el-row>
                    <el-col :span="6">
                        <el-input><template slot="prepend">ID</template></el-input>
                    </el-col>
                    <el-col :span="6">
                        <el-input><template slot="prepend">NAME</template></el-input>
                    </el-col>

                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-input><template slot="prepend">URL</template></el-input>
                    </el-col>
                </el-row>
                <el-row>
                    <el-button>保存</el-button>
                </el-row>

            </el-col>
        </el-row>


    </div>


</template>

<script>
    export default {
        name:'webMenu',
        data() {
            return {
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1',
                        children: [{
                            label: '三级 1-1-1'
                        }]
                    }]
                }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1',
                        children: [{
                            label: '三级 2-1-1'
                        }]
                    }, {
                        label: '二级 2-2',
                        children: [{
                            label: '三级 2-2-1'
                        }]
                    }]
                }, {
                    label: '一级 3',
                    children: [{
                        label: '二级 3-1',
                        children: [{
                            label: '三级 3-1-1'
                        }]
                    }, {
                        label: '二级 3-2',
                        children: [{
                            label: '三级 3-2-1'
                        }]
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                selectedMene:{
                    label:'',
                    children:[]
                }
            };
        },
        methods: {
            handleNodeClick(data) {
                console.log(data);
                this.selectedMene.label = data.label;
                this.selectedMene.children = data.children;
            },
            addWebMenu(){
                console.log('vvv');
                //this.data.push(this.selectedMene);
                this.axios.get('/api/helloWorld').then((response) => {
                    console.log(response.data)
                })

                this.axios.get('/api/').then((response) => {
                    console.log(response.data)
                })
            }
        }
    };
</script>


<style scoped>

</style>
<template>
    <div>

        <el-row>
            <el-col :span="6">
                <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick" >


                    <span class="custom-tree-node" slot-scope="{ node, data }">
                    <span>{{ node.label }}</span>
                    <span v-show="true" style="margin-left: 30px">
                      <el-button
                              type="text"
                              size="mini"
                              @click="() => append(data)">
                        Append
                      </el-button>
                      <el-button
                              type="text"
                              size="mini"
                              @click="() => remove(node, data)">
                        Delete
                      </el-button>
                    </span>
                  </span>
                </el-tree>

                <!--<el-button @click="addWebMenu">添加树</el-button>-->
                <!--<el-button @click="addWebMenu">添加节点</el-button>-->
                <!--<el-button @click="addWebMenu">删除</el-button>-->

            </el-col>
            <el-col :span="18">
                <el-row>
                    <el-col :span="6">
                        <el-input v-model="selectedMene.id" ><template slot="prepend">ID</template></el-input>
                    </el-col>
                    <el-col :span="6">
                        <el-input v-model="selectedMene.name" ><template slot="prepend">NAME</template></el-input>
                    </el-col>

                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-input v-model="selectedMene.url" ><template slot="prepend">URL</template></el-input>
                    </el-col>
                </el-row>
                <el-row>
                    <el-button @click="save()">保存</el-button>
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
                data: [],
                defaultProps: {
                    children: 'children',
                    label: 'name'
                },
                selectedMene:{
                    id:'',
                    name:'',
                    children:[]
                }

            };
        },
        methods: {
            handleNodeClick(data) {
                console.log(data);
                this.selectedMene.name = data.name;
                this.selectedMene.children = data.children;
            },
            addWebMenu(){
                console.log('vvv');

                var node = {
                    label: '一级 1',
                        url:'ccc',
                    children: [{
                    label: '二级 1-1',
                    children: [{
                        label: '三级 1-1-1'
                    }]
                }]
                }
                //this.data.push(this.selectedMene);
                this.axios.get('/api/helloWorld').then((response) => {
                    console.log(response.data)
                })

                this.axios.get('/api/').then((response) => {
                    console.log(response.data)
                })
            },

            loadData(){
                console.log('load data');

                this.data = [{
                    name: '一级 1',
                    url:'ccc',
                    children: [{
                        name: '二级 1-1',
                        children: [{
                            name: '三级 1-1-1'
                        }]
                    }]
                }, {
                    name: '一级 2',
                    children: [{
                        name: '二级 2-1',
                        children: [{
                            name: '三级 2-1-1'
                        }]
                    }, {
                        name: '二级 2-2',
                        children: [{
                            name: '三级 2-2-1'
                        }]
                    }]
                }, {
                    name: '一级 3',
                    children: [{
                        name: '二级 3-1',
                        children: [{
                            name: '三级 3-1-1'
                        }]
                    }, {
                        name: '二级 3-2',
                        children: [{
                            name: '三级 3-2-1'
                        }]
                    }]
                }]
            },

            append(data){
                console.log('append')

            },
            remove(data){
                console.log('remove')
            },

            save(){

                console.log(this.selectedMene);
            }



        },
        mounted() {
            this.loadData();
        }
    };
</script>


<style scoped>

</style>
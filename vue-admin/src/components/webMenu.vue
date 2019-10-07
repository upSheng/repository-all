<template>
    <div>
        <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>

        <el-button @click="addWebMenu">增加子菜单</el-button>
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
                this.data.push(this.selectedMene);
            }
        }
    };
</script>


<style scoped>

</style>
<template>
    <div id="NavMenu">
        <el-menu
                :default-active="activeIndex"
                class="el-menu-demo"
                @select="handleSelect"
                router
        >

            <el-menu-item index="/admin">首页</el-menu-item>
            <el-menu-item index="/admin/product">商品</el-menu-item>
            <el-menu-item index="/admin/order">订单</el-menu-item>
            <el-menu-item index="/">前端首页</el-menu-item>
        </el-menu>



    </div>
</template>

<script>
    export default {
        name: "adminMenu",
        data() {
            return {
                activeIndex: "/",

            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
                this.activeIndex = key;

            },

        },
        mounted(){

        }
    };
</script>

<style scoped>
</style>

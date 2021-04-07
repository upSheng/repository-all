<template>
    <div id="NavMenu">
        <el-menu
                :default-active="activeIndex"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                router
        >

            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="/order">我的订单</el-menu-item>
            <el-menu-item index="/instruction">帮助中心</el-menu-item>
        </el-menu>




    </div>
</template>

<script>
    export default {
        name: "NavMenu",
        data() {
            return {
                activeIndex: "movie",

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

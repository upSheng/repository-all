<template>
    <div>

        <el-row  v-for="index of Math.ceil(productList.length/rowNum)">

            <el-col v-for="product in productList.slice((index-1)*rowNum,index*rowNum)"  :span="parseInt(24/rowNum)">
                <div>
                    <img  :src=product.imgMain />

                    <div>
                        {{product.name}}
                    </div>
                    <div>
                        {{product.describe}}
                    </div>
                    <div style="color:#ff6700">
                        {{product.price}}
                    </div>
                </div>
            </el-col>

        </el-row>


    </div>
</template>

<script>
    export default {
        name: 'homepage',
        data() {
            return {
                productList: [],
                rowNum:4,
                src:''
            };
        },
        methods: {
            init(){

                this.axios.get('/listProduct').then((response) => {
                    console.log(response.data)
                    if (response.data.code == 200) {
                        this.productList = response.data.data;
                    }
                })

                // this.productList = [
                //     {
                //         "id":"1",
                //         "name":"运动鞋1",
                //         "img":"http://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d0b1119165c481376399aab53330e015.jpg?thumb=1&w=200&h=200&f=webp&q=90",
                //         "price":5,
                //         "describe":"描述"
                //     },
                //     {
                //         "id":"2",
                //         "name":"运动鞋2",
                //         "img":"http://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d0b1119165c481376399aab53330e015.jpg?thumb=1&w=200&h=200&f=webp&q=90",
                //         "price":5,
                //         "describe":"描述"
                //     },
                //     {
                //         "id":"3",
                //         "name":"运动鞋3",
                //         "img":"http://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d0b1119165c481376399aab53330e015.jpg?thumb=1&w=200&h=200&f=webp&q=90",
                //         "price":5,
                //         "describe":"描述"
                //     },
                //     {
                //         "id":"4",
                //         "name":"运动鞋4",
                //         "img":"http://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d0b1119165c481376399aab53330e015.jpg?thumb=1&w=200&h=200&f=webp&q=90",
                //         "price":5,
                //         "describe":"描述"
                //     },
                //     {
                //         "id":"5",
                //         "name":"运动鞋5",
                //         "img":"http://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d0b1119165c481376399aab53330e015.jpg?thumb=1&w=200&h=200&f=webp&q=90",
                //         "price":5,
                //         "describe":"描述"
                //     }
                //
                // ];

            }
        },
        mounted() {
            this.init();
        }
    }
</script>
<style scoped>

</style>
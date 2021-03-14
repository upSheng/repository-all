<template>
    <div style="margin-top: 20px">
        <el-row>
            <el-col :span="18">
                <video style="width: 90%"  controls="autoplay"  :src=src />
            </el-col>

            <el-col :span="6">

                <div v-for="video in videoList" :key="video.num">
                    <el-button style="width: 80%" @click="btn(video.src)">{{video.num}}</el-button>
                </div>

            </el-col>

        </el-row>
    </div>

</template>

<script>
    export default {
        name: 'movie',
        data() {
            return {
                videoList: [],
                src:''
            };
        },
        methods: {

            btn(src) {
                this.src = src;
            },

            init(){
                console.log(this.$route.params.id);

                this.videoList = [
                    {
                        "num":1,
                        "src":"https://vip.w.xk.miui.com/924a97bd5908561d96e94bb10f02207b"
                    },
                    {
                        "num":2,
                        "src":"https://vip.w.xk.miui.com/96a5b82402e5e65d25df95b6cd014e42"
                    },
                    {
                        "num":3,
                        "src":"https://vip.w.xk.miui.com/96a5b82402e5e65d25df95b6cd014e42"
                    },
                    {
                        "num":4,
                        "src":"https://vip.w.xk.miui.com/96a5b82402e5e65d25df95b6cd014e42"
                    }

                ];

                this.btn(this.videoList[0].src);
            }
        },
        mounted() {
            this.init();
        }
    };


</script>


<style scoped>

</style>
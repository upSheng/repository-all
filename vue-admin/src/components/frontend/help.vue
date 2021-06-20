<template>
    <div>


            <div style="margin: 50px 300px 0 300px; text-align: left;">

                <div style="margin: 10px 0; font-weight: 500;font-size: 30px  ">
                    steam热门游戏推荐

                </div>
            </div>




    </div>
</template>

<script>
    export default {
        name: 'help',
        data() {
            return {
                orderAwardList: []
            };
        },
        methods: {


            findAwardList() {

                this.axios.post('/findAwardList', {}).then((response) => {

                    if (response.data.data != null && response.data.code == 200) {
                        this.orderAwardList = response.data.data;
                    } else {
                        this.orderAwardList = [];
                    }
                })
            }

        },
        mounted() {

        }
    }
</script>
<style scoped>

</style>
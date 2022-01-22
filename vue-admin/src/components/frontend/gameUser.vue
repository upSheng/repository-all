<template>
    <div class="gameUser" >


        <div style="margin-bottom: 50px;font-size: 30px; text-align: center">
            我的游戏
        </div>


        {{gameList}}
        
    </div>
</template>

<script>
    export default {
        name: 'gameUser',
        data() {
            return {


                gameList: [],

            };
        },
        methods: {


            loadGameUser() {

                let phone = localStorage.getItem("phone");

                this.axios.get('/getGameByPhone?phone='+phone).then((response) => {

                    if (response.data.code == 200) {
                        this.gameList = response.data.data;

                    }
                })
            },



        },


        mounted() {

            this.loadGameUser();
        }
    }
</script>
<style scoped>






</style>
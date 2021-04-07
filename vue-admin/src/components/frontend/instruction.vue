<template>
    <div >



            asdas


    </div>
</template>

<script>
    export default {
        name: 'instruction',
        data() {
            return {
                orderAwardList: []
            };
        },
        methods: {


            findAwardList() {

                this.axios.post('/findAwardList', {}).then((response) => {
                    console.log(response.data)
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
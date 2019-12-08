<template>
    <div>
        <input type="text" v-model="username"></input>
        <input type="text" v-model="password"></input>
        <br>
        <button @click="login">ok</button>
        <button @click="check">check</button>
    </div>
</template>

<script>
    export default {
        name:'login',
        data() {
            return {
                username: '',
                password: ''
            };
        },
        methods: {

            login(){
                console.log('vvv');
                let param = new URLSearchParams()
                param.append("username", this.username)
                param.append("password", this.password)

                this.axios.post('/api/login',param).then((response) => {
                    console.log(response.data)
                    if(response.data.status == 200){
                        localStorage.setItem("jwtToken",response.data.jwtToken);
                        this.$router.push('/movie');
                    }


                })
            },
            check(){

                var jwtToken = localStorage.getItem('jwtToken');
                console.log(jwtToken);
            }
        }
    };
</script>


<style scoped>

</style>
<template>
    <div>
        <el-card>
            <div v-html="code"></div>
        </el-card>
    </div>
</template>

<script>
export default {
    data(){
        return{
            code: '',
            title: ''
        }
    },
    created(){
        this.title=this.$route.query.id;
        this.getCode();
    },
    methods:{
        getCode(){
            this.axios({
                method:'get',
                url:'/code/'+this.title,
            }).then((res)=>{
                this.code=res.data.data

            });
        }
    }
}
</script>
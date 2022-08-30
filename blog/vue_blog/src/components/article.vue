
<!-- 展示博客
 -->
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
        //由First传递过来的参数
        this.title=this.$route.query.id;
        this.getCode();
    },
    methods:{
        //向后端获取博客数据
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
<template>
    <div>
        <el-card>
            <el-form>
                <el-form-item label="博客标题">
                    <el-input v-model="blog.title" ></el-input>
                </el-form-item>
                <el-form-item label="博客介绍">
                    <el-input v-model="blog.introduce" ></el-input>
                </el-form-item>
                <el-form-item label="活动区域">
                    <el-select v-model="blog.classification" placeholder="请选择活动区域">
                        <el-option label="java" value="java"></el-option>
                        <el-option label="c语言" value="c语言"></el-option>
                        <el-option label="ARM汇编" value="ARM汇编"></el-option>
                        <el-option label="c++" value="c++"></el-option>
                        <el-option label="X86汇编" value="X86汇编"></el-option>
                        <el-option label="js" value="js"></el-option>
                        <el-option label="web前端框架" value="web前端框架"></el-option>
                        <el-option label="web后端框架" value="web后端框架"></el-option>
                        <el-option label="数学" value="数学"></el-option>
                        <el-option label="前端" value="前端"></el-option>
                        <el-option label="python" value="python"></el-option>
                        <el-option label="嵌入式" value="嵌入式"></el-option>
                        <el-option label="其他" value="其他"></el-option>
                    </el-select>
                </el-form-item>
                 <el-form-item>
                     <div id="main">
                        <mavon-editor ref="md" v-model="value"/>
                    </div>
                </el-form-item>
                <el-form-item>
                     <el-button type="primary" @click="submit_blog">提交</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script>
import Qs from 'qs';
export default {
    data(){
        return{
            value:'',
            blog:{
                id: 0,
                title: '',
                introduce: '',
                classification: '',
                article: '',
                data: '',
            }
        }
    },
    methods:{
        submit_blog(){
            this.blog.article=this.$refs.md.d_render;
            this.axios({
                method:'post',
                url:'/insert_blog',
                data: Qs.stringify(this.blog)
            }).then((res)=>{
               this.$message({message:'提交成功',type:'success'})
               this.$router.push('/index');
            });
        }
    }
}
</script>
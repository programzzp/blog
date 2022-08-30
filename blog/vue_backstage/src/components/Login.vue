<template>
    <div class="login_box">
        <div class="login_main">
            <p class="head_worder">博客后台管理</p>
            <el-form :model="LoginUser" :rules="rules" ref="loginFromRef">
                <el-form-item prop="username">
                    <el-input v-model="LoginUser.username" placeholder="用户名" prefix-icon="el-icon-user-solid"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="LoginUser.password" placeholder="密码" prefix-icon="el-icon-key" show-password></el-input>
                </el-form-item>
                <el-form-item>
                   <div class="button_main">
                        <el-button type="primary" @click="LoginFunction">登录</el-button>
                        <el-button type="info" @click="Reset">重置</el-button>
                   </div>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            LoginUser:{
                username: '',
                password: ''
            },
            rules:{
                username:[{required: true,message:'请输入用户名',trigger: 'blur'},{min: 3, max: 30, message: '长度在 3 到 5 个字符', trigger: 'blur'}],
			    password:[{required: true,message:'请输入密码',trigger: 'blur'},{min: 3, max: 30, message: '长度在 3 到 5 个字符', trigger: 'blur'}]
            }
            
        }
    },
    methods:{
        LoginFunction(){
            this.$refs.loginFromRef.validate((vail)=>{
                if(!vail) return;

                this.axios({
                    method:'post',
                    url:'/login',
                    params: this.LoginUser  
                }).then((res)=>{
                    if(res.data.success){
                        window.sessionStorage.setItem('token',res.data.data);
                        window.sessionStorage.setItem('username',this.LoginUser.username);
                        this.$message({message:'登录成功',type:'success'})
                        this.$router.push('/index');
                    }else{
                        this.$message.error('密码或者账号错误');
                    }
                });
            })
        },
        Reset(){
            this.$refs.loginFromRef.resetFields();
        }
    },
    created(){

    }
}
</script>

<style scoped>
.login_box{
    height: 100%;
    background-color: rgb(180, 148, 212);
    /* background-image: url('../assets/01.jpg'); */
}
.login_main{
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
    width: 400px;
    height: 300px;
    background-color: white;
    opacity: 0.9;
    border-radius: 10px;
}
.el-form{
    margin-top: 30px;
    padding: 0 20px;
}
.head_worder{
    text-align: center;
    font-size: 20px;
    font-weight: 800;
}
</style>
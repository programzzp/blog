<template>
    <div>
        <el-container>
            <el-header>
                <el-menu
                router 
                :default-active="activeIndex" 
                class="el-menu-demo" 
                mode="horizontal" >
                <el-menu-item index="/show">首页</el-menu-item>
                <el-menu-item index="/creation">写博客</el-menu-item>
                <el-menu-item index="/project">个人项目</el-menu-item>
                <el-menu-item index="/settings">设置</el-menu-item>
                </el-menu>
            </el-header>

            <!-- 博客列表 -->
            <el-main>
                <router-view></router-view>
            </el-main>


        </el-container>
    </div>
</template>

<script>
export default {
    data(){
        return{
            activeIndex: "/first",
            activeIndex2: "1",
        }
    },
    created(){
        this.$router.push('/show')
    },methods:{
       
    }
}
</script>

<style scoped>
.el-header{
  padding: 0;
}
</style>
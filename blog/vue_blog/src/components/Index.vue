<template>
  <div>
    <el-container>

      <!-- 页面表头 -->
      <el-header>
        <el-menu
        router 
        :default-active="activeIndex" 
        class="el-menu-demo" 
        mode="horizontal"  
        @select="handleSelect">

          <el-menu-item index="/first">首页</el-menu-item>
          <el-menu-item index="/personalprofile">关于我</el-menu-item>

        </el-menu>
      </el-header>


      <el-container>
         <!-- 个人信息简洁 -->
        <el-aside width="25%">
          <Introduction class="info"></Introduction>
        </el-aside>

        <!-- 主要信息输出 -->
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Introduction from "./Introduction.vue";
export default {
    name: "HelloWorld",
    data() {
        return {
            msg: "Welcome to Your Vue.js App",
            activeIndex: "/first",
            activeIndex2: "1"
        };
    },
    created(){
      this.$router.push('/first');
    },
    methods: {
        handleSelect(key, keyPath) {
           // console.log(key, keyPath);
        }
    },
    components: { Introduction }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.el-header{
  padding: 0;
}

.el-main{
  padding-right: 100px;
  padding-left: 100px;
}

.el-aside{
  padding-left: 50px;
  padding-top: 100px;
}




</style>

<template>
    <div>
        <el-card>
            <el-image
            style="width: 200px; height: 200px"
            :src="url"></el-image>

            <p class="head_information">小培个人站</p>
            <p style="text-align: center;">一个喜欢编程,音乐,科技的少年</p>
            <div class="logo">
                <a href="https://space.bilibili.com/504637772?spm_id_from=333.1007.0.0"><img src="../assets/bilibili.jpg" alt=""></a>
                <a href="https://gitee.com/zhou-zhanpei"><img src="../assets/gitee.jpg" alt=""></a>
                <a href="https://github.com/programzzp"><img src="../assets/github.jpg" alt=""></a>
                <a href="https://blog.csdn.net/ProgramBoy001?spm=1000.2115.3001.5343"><img src="../assets/csdn.jpg" alt=""></a>
            </div>
        </el-card>
    </div>
</template>

<script>

export default {
    data(){
        return{
            fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
            url: 'http://47.105.34.128/images.jpg' 
        }
    }
}
</script>

<style scoped>
.el-card{
    height: 500px;
}

.el-image{
    border-radius: 50%;
    margin-left: 22%; 
}

.head_information{
    font-size: 25px;
    font-weight: 900;
    text-align: center;
}

.logo img{
    width: 50px;
    height: 50px;
    border-style: solid;
    border-color: aliceblue;
    border-width: 1px;
    border-radius: 50%;
    padding: 3px 3px 3px 3px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    margin-top: 10%;
    margin-left: 30px;
    cursor: pointer;
}

.el-card{
    border-width: 3px;
}
</style>
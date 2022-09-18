<template>
    <div>
       <el-card>


        <el-descriptions title="个人信息">
            <el-descriptions-item label="姓名">{{personalInformation.name}}</el-descriptions-item>
            <el-descriptions-item label="手机号">{{personalInformation.phone}}</el-descriptions-item>
            <el-descriptions-item label="电子邮件">{{personalInformation.mail}}</el-descriptions-item>
            <el-descriptions-item label="学历">
                <el-tag size="small">{{personalInformation.education}}</el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="学校">
                <el-tag size="small">{{personalInformation.school}}</el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="家庭住址">{{personalInformation.address}}</el-descriptions-item>
        </el-descriptions>

           <p class="head_data">关于我</p>

           <div>
                <ul v-for="data in features" :key="data.title">
                    <li>{{data}}</li>
                </ul>
           </div>

           <div>
                <p class="project">我的项目</p>
                <hr />
           </div>
           <div>
                <ul v-for="data in project_data" :key="data.id">
                    <li>{{data.name}} : <a :href="data.address">{{data.address}}</a></li>
                </ul>
           </div>
        </el-card>
    </div>
</template>

<script>
export default {
    data(){
        return{
            features: [],
            project_data: [],
            personalInformation: {}
        }
    },
    created(){
        this.getFeatures();
        this.getProject_data();
        this.getPersonalInformationWeb();
    },
    methods:{
        getFeatures(){
            this.axios({
                method:'get',
                url:'/features',
            }).then((res)=>{
                this.features=res.data.data;
            });
        },getProject_data(){
            this.axios({
                method:'get',
                url:'/getAllProjectInformation',
            }).then((res)=>{
                this.project_data=res.data.data
            });
        },getPersonalInformationWeb(){
            this.axios({
                method:'get',
                url:'/getPersonalInformationController/2191142854',
            }).then((res)=>{
                this.personalInformation=res.data.data
            });
        },

    }
}
</script>

<style scoped>
.head_data{
    font-size: 30px;
    font-weight: 400;
}

ul li{
    font-size: 17px;
    margin-top: 10px;
    font-weight: 600;
}

.project{
    margin: 0 0;
    font-size: 30px;
    font-weight: 800;
    margin-top: 50px;
}
</style>
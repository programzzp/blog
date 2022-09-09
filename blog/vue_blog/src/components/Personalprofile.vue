<template>
    <div>
       <el-card>
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
        }
    },
    created(){
        this.getFeatures();
        this.getProject_data();
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
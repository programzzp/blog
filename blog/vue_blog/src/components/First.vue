<template>
    <div>

        <div>
            <el-row>
                <el-col :span="8">
                    <div class="head-screach">

                        <!-- 条件查询 -->
                        <el-select v-model="value" placeholder="请选择">
                            <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                        <el-button icon="el-icon-search" @click="Seach_data">搜索</el-button>
                    </div>
                </el-col>
                <el-col :span="4">
                </el-col>
            </el-row>
        </div>


        <!-- 展示所有博客的信息 -->
        <span v-for="data in content" :key="data.title">
            <div @click="getClickData(data.title)">
                <el-card class="box-card" >
                    <h1>{{data.title}}</h1>
                    <p>{{data.introduce}}</p>
                    <p class="style_data">发布博客  {{data.data}}</p>
                </el-card>
            </div>
        </span>

        <!-- 分页 -->
        <div>
            <el-pagination
                background
                layout="prev, pager, next"
                :total="total"
                @current-change="GetTeacherInfoPaging">
            </el-pagination>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            total: 0,
            content:[],
            //分页使用的数据结构
            ShowBlog:{
                page: 1, 
                size: 4
            },
            value: '',
            options: [{
                value: 'java',
                label: 'java'
            },{
                value: 'c语言',
                label: 'c语言'
            },{
                value: 'ARM汇编',
                label: 'ARM汇编'
            },{
                value: 'c++',
                label: 'c++'
            },{
                value: 'X86汇编',
                label: 'X86汇编'
            },{
                value: 'js',
                label: 'js'
            },{
                value: 'web前端框架',
                label: 'web前端框架'
            },{
                value: 'web后端框架',
                label: 'web后端框架'
            },{
                value: '数学',
                label: '数学'
            },{
                value: '前端',
                label: '前端'
            },{
                value: 'python',
                label: 'python'
            },{
                value: '嵌入式',
                label: '嵌入式'
            },
            {
                value: '其他',
                label: '其他'
            }]
        }
    },
    created(){
        this.PaginationShowData();
        this.getBlogNumber();
    },
    methods:{

        //获取所有博客(作废)
        getContent_data(){
            this.axios({
                method:'get',
                url:'/content',
            }).then((res)=>{
                this.content=res.data.data
                
            });
        },

        //发送参数给博客展示页面
        getClickData(data){
             this.$router.push({
                path: '/article',
                query: {
                    id: data
                }
             });
        },


        //条件查询
        Seach_data(){
            this.axios({
                method:'get',
                url:'/SeachCode/'+this.value,
            }).then((res)=>{
               this.content=res.data.data
            });


            this.value=''

        },


        //获取分页的信息
        GetTeacherInfoPaging(id){
            this.ShowBlog.page=id;
            this.PaginationShowData();
        },

        //获取有多少博客
        getBlogNumber(){
            this.axios({
                method:'get',
                url:'/getBlogNumber',
            }).then((res)=>{
                this.total=(res.data.data/this.ShowBlog.size)*10;
            });

        },

        //分页获取数据
        PaginationShowData(){
            this.axios({
                method:'get',
                url:'/paginationShowData',
                params: this.ShowBlog
            }).then((res)=>{
                this.content=res.data.data;
            });
        }
        
    }
}
</script>

<style scoped>
.el-card{
    cursor: pointer;
    height: 150px;
    margin-top: 30px;
}

.style_data{
    font-size: 15px;
    font-weight:900;
}



.el-pagination{
    margin-top: 30px;
}

.head-screach{
    display: flex;
}

</style>
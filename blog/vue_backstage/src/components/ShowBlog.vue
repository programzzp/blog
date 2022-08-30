<template>
    <div>
        <el-card>
        
            <el-table
            :data="content"
            style="width: 100%">
                <el-table-column
                    prop="title"
                    label="标题">
                </el-table-column>
                <el-table-column
                    prop="introduce"
                    label="介绍">
                </el-table-column>
                <el-table-column
                    prop="data"
                    label="时间">
                </el-table-column>
                <el-table-column
                    prop="classification"
                    label="分类">
                </el-table-column>
                <el-table-column prop="" label="操作"  width="160px">
                      <template class="tool_Button" slot-scope="scope">
                         <el-tooltip class="item" effect="dark" content="查看博客" placement="top">
                            <el-button type="primary" icon="el-icon-edit" size="mini" @click="showCode(scope.row.title)"></el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="dark" content="删除博客" placement="top">
                            <el-button type="primary" icon="el-icon-delete" size="mini" @click="deleteCode(scope.row.id)"></el-button>
                        </el-tooltip>
                      </template>
                </el-table-column>
            </el-table>
           
        </el-card>
    </div>
</template>

<script>
export default {
    data(){
        return{
            content:[]
        }
    },created(){
        this.getContent_data();
    },methods:{
        getContent_data(){
            this.axios({
                method:'get',
                url:'/content',
            }).then((res)=>{
                this.content=res.data.data

            });
        },
        showCode(data){
            this.$router.push({
                path: '/article',
                query: {
                    id: data
                }
            });
        },


        deleteCode(id){
            this.axios({
                method:'get',
                url:'/deleteCode/'+id,
            }).then((res)=>{
                if(res.data.success){
                    this.$message({message:'删除成功',type:'success'})
                    this.getContent_data();
                }
            });
        }
    }
}
</script>
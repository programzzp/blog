<template>
    <div>
        <el-card>

            <el-button type="primary"  icon="el-icon-circle-plus-outline"  @click="dialogVisible = true">添加项目</el-button>


            <el-dialog
            title="添加项目"
            :visible.sync="dialogVisible"
            width="30%">
                <span>
                    <el-form ref="form" :model="Project" label-width="80px">
                        <el-form-item label="项目名字">
                            <el-input v-model="Project.name"></el-input>
                        </el-form-item>
                        <el-form-item label="项目地址">
                            <el-input v-model="Project.address"></el-input>
                        </el-form-item>
                    </el-form>
                </span>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="setErrorProjectInfomation">取 消</el-button>
                    <el-button type="primary" @click="setProjectInfomation">确 定</el-button>
                </span>
            </el-dialog>



            <el-table
            height="600"
            :data="project_data"
            style="width: 100%">
                <el-table-column
                    width="600px"
                    prop="name"
                    label="项目名字">
                </el-table-column>
                <el-table-column
                    prop="address"
                    label="项目地址">
                </el-table-column>

                <el-table-column prop="" label="操作"  width="160px">
                      <template class="tool_Button" slot-scope="scope">
                         <el-tooltip class="item" effect="dark" content="修改" placement="top">
                            <el-button type="primary" class="el-icon-edit" size="mini" @click="getOneProjectInformation(scope.row.id)"></el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="dark" content="删除" placement="top">
                            <el-button type="primary" icon="el-icon-delete" size="mini" @click="deleteProject(scope.row.id)"></el-button>
                        </el-tooltip>
                      </template>
                </el-table-column>
            </el-table>


            <!-- 修改项目信息 -->
            <el-dialog
            title="修改项目"
            :visible.sync="upDataDialogVisible"
            width="30%">
                <span>
                    <el-form ref="form" :model="upDataProject" label-width="80px">
                        <el-form-item label="项目名字">
                            <el-input v-model="upDataProject.name"></el-input>
                        </el-form-item>
                        <el-form-item label="项目地址">
                            <el-input v-model="upDataProject.address"></el-input>
                        </el-form-item>
                    </el-form>
                </span>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="setUpDataErrorProjectInfomation">取 消</el-button>
                    <el-button type="primary" @click="upDataProjectWebGetData">确 定</el-button>
                </span>
            </el-dialog>
            


        </el-card>
    </div>
</template>


<script>
import Qs from 'qs';
export default {
    data(){
        return{
            dialogVisible: false,
            upDataDialogVisible: false,
            project_data: [],
            Project:{
                id: '',
                name: '',
                address: ''
            },
            upDataProject:{
                id: '',
                name: '',
                address: ''
            },
        }
    },created(){
        this.getProject_data()
    },methods:{
        getProject_data(){
            this.axios({
                method:'get',
                url:'/getAllProjectInformation',
            }).then((res)=>{
                this.project_data=res.data.data
            });
        },
        setErrorProjectInfomation(){
            this.Project.address=''
            this.Project.name=''
            this.dialogVisible=false
        },
        setProjectInfomation(){

            this.axios({
                method:'post',
                url:'/insertProject',
                data: Qs.stringify(this.Project)
            }).then((res)=>{
                if(res.data.success){
                    this.getProject_data()
                    this.success()
                    this.Project.address=''
                    this.Project.name=''
                    this.dialogVisible=false
                }else{
                    this.fail()
                    this.dialogVisible=true
                }
            });

        },
        success() {
            this.$message({
                message: '恭喜你，添加项目成功',
                type: 'success'
            });
        },
        fail() {
            this.$message.error('错了哦，添加项目失败');
        },
        deleteProject(id){
            
            this.axios({
                method:'get',
                url:'/deleteOneProject/'+id,
            }).then((res)=>{
                if(res.data.success){
                    this.$message({message:'删除成功',type:'success'})
                    this.getProject_data()
                }else{
                    this.$message.error('删除失败');
                }
            });
        },
        getOneProjectInformation(id){
            this.axios({
                method:'get',
                url:'/getOneProjectInformation/'+id,
            }).then((res)=>{
                if(res.data.success){
                    this.upDataProject=res.data.data;
                    this.upDataDialogVisible=true;
                }else{
                    this.upDataDialogVisible=false;
                }
            });
        },upDataProjectWebGetData(){

            this.axios({
                method:'post',
                url:'/upDataProject',
                data: Qs.stringify(this.upDataProject)
            }).then((res)=>{
                if(res.data.success){
                    this.getProject_data()
                    this.$message({message:'修改成功',type:'success'})
                    this.upDataProject.address=''
                    this.upDataProject.name=''
                    this.upDataDialogVisible=false
                }else{
                    this.$message.error('修改失败');
                    this.upDataDialogVisible=true
                }
            });

        },
        setUpDataErrorProjectInfomation(){
            this.upDataProject.address=''
            this.upDataProject.name=''
            this.upDataDialogVisible=false
        },
    }
}
</script>


<style scoped>
.el-table{
    margin-top: 20px;
}
</style>
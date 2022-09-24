<template>
    <div>
        <el-card>
        
            
            <el-avatar :size="150">
                <img :src=url @click="dialogVisible = true" />
            </el-avatar>

       


       



            <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%">
                <span>
                    <el-upload
                        action="http://39.101.1.197:8081/setAvatarPath"
                        list-type="picture-card"
                        :headers="headerObj"
                        :on-preview="handlePictureCardPreview"
                        :on-remove="handleRemove"
                        :on-success="Headsuccess">
                        <i class="el-icon-plus"></i>
                    </el-upload>
                </span>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
                </span>
            </el-dialog>







            <el-row>
                <el-col :span="7"><div class="left">
                    <el-form ref="form" label-width="80px">
                        <el-form-item label="旧密码">
                            <el-input placeholder="请输入旧密码" show-password></el-input>
                        </el-form-item>
                        <el-form-item label="新密码">
                            <el-input placeholder="请输入新密码" show-password></el-input>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary">提交</el-button>
                        </el-form-item>
                    </el-form>
                </div></el-col>
                <el-col :span="12"><div class="right"></div></el-col>
            </el-row>




            <h1>个人信息修改</h1>

            <el-row>
                <el-col :span="7"><div class="left">
                    <el-form ref="form" :model="personalInformation" label-width="80px">
                        <el-form-item label="姓名">
                            <el-input placeholder="姓名" v-model="personalInformation.name"  ></el-input>
                        </el-form-item>

                        <el-form-item label="学校">
                            <el-input placeholder="学校" v-model="personalInformation.school" ></el-input>
                        </el-form-item>


                        <el-form-item label="学历">
                            <el-radio v-model="personalInformation.education" label="本科">本科</el-radio>
                            <el-radio v-model="personalInformation.education" label="专科">专科</el-radio>
                        </el-form-item>

                        <el-form-item label="电话号码">
                            <el-input placeholder="电话号码" v-model="personalInformation.phone" ></el-input>
                        </el-form-item>

                        <el-form-item label="家庭住址">
                            <el-input placeholder="电话号码" v-model="personalInformation.address" ></el-input>
                        </el-form-item>


                        <el-form-item label="电子邮箱">
                            <el-input placeholder="电子邮箱" v-model="personalInformation.mail" ></el-input>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="revisePersonalInformationController">提交个人信息</el-button>
                        </el-form-item>
                    </el-form>
                </div></el-col>
                <el-col :span="12"><div class="right"></div></el-col>
            </el-row>






             <!-- 添加个人技能 -->
        <div class="tags"></div>
        <h1>设置技能</h1>
        <el-tag
        :key="tag"
        v-for="tag in dynamicTags"
        closable
        :disable-transitions="false"
        @close="handleClose(tag)">
            {{tag}}
        </el-tag>
        <el-input
        class="input-new-tag"
        v-if="inputVisible"
        v-model="inputValue"
        ref="saveTagInput"
        size="small"
        @keyup.enter.native="handleInputConfirm"
        @blur="handleInputConfirm"
        >
        </el-input>
            <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
            <div></div>
            <el-button type="primary" class="submitData" @click="setFeatures">提交数据</el-button>
        </el-card>



    </div>
</template>


<script>
import Qs from 'qs';
export default {
    data(){
        return{
            url: 'http://192.168.0.109/images.jpg',
            dialogVisible: false,
            headerObj: {
                Authorization: window.sessionStorage.getItem("username"),
            },
            dynamicTags: [],
            inputVisible: false,
            inputValue: '',
            Features: {
                username: '',
                features: ''
            },

            //个人信息
            personalInformation: {
                school: '',     //学校
                name: '',       //姓名
                education: '本科',   //学历
                mail: '',       //电子邮件地址
                phone: '',     //手机号
                address: ''   //家庭住址
            }
            
        }
    },
    created(){
        this.getAvatarPath()
        this.getFeatures()
        this.getPersonalInformationWeb()
    },
    methods: {
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
        Headsuccess(response, file, fileList){
            this.url=response.data;
            
        },
        getAvatarPath(){
            this.axios({
                method:'get',
                url:'/getAvatarPath',
            }).then((res)=>{
                this.url=res.data.data
            });
        },
        handleClose(tag) {
            this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
        },

        showInput() {
            this.inputVisible = true;
            this.$nextTick(_ => {
            this.$refs.saveTagInput.$refs.input.focus();
            });
        },

        handleInputConfirm() {
            let inputValue = this.inputValue;
            if (inputValue) {
            this.dynamicTags.push(inputValue);
            }
            this.inputVisible = false;
            this.inputValue = '';
        },

        getFeatures(){
            this.axios({
                method:'get',
                url:'/features',
            }).then((res)=>{
                this.dynamicTags=res.data.data
            });
        },


        setFeatures(){
            let data=this.dynamicTags
            let submitFeatures=''

            for(let i=0;i<data.length;i++){
                submitFeatures+=data[i]+'##'
            }

            this.Features.features=submitFeatures;
            this.Features.username=window.sessionStorage.getItem("username");

            this.axios({
                method:'post',
                url:'/setFeatures',
                data: Qs.stringify(this.Features)
            }).then((res)=>{
                if(res.data.success){
                    this.$message({message:'添加成功',type:'success'})
                }else{
                    this.$message.error('添加失败');
                }
            });
        },

        getPersonalInformationWeb(){
            this.axios({
                method:'get',
                url:'/getPersonalInformationController/'+window.sessionStorage.getItem('username'),
            }).then((res)=>{
                this.personalInformation=res.data.data
            });
        },

        revisePersonalInformationController(){
            this.axios({
                method:'post',
                url:'/revisePersonalInformation/2191142854',
                data: Qs.stringify(this.personalInformation)
            }).then((res)=>{
                if(res.data.success){
                    this.$message({message:res.data.message,type:'success'})
                }else{
                    this.$message.error(res.data.message);
                }
            });
        }
    }
}
</script>


<style scoped>

.el-row{
    margin-top: 20px;
}


img:hover{
    cursor:pointer;
}


.el-tag + .el-tag {
    margin-left: 10px;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
.tags{
    margin-top: 30px;
}

.el-tag{
    margin-top: 20px;
}

.submitData{
    margin-top: 30px;
}
</style>
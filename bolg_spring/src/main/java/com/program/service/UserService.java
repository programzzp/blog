package com.program.service;

import com.program.dao.BlogDao;
import com.program.dao.UserInformationDao;
import com.program.pojo.ContentData;
import com.program.pojo.IdWorker;
import com.program.pojo.LoginUser;
import com.program.pojo.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInformationDao userInformationDao;

    @Autowired
    private BlogDao blogDao;


    /**
     * 获取个人优势数据
     *
     *
     * 数据格式
     * 软件开发,个人开发者##
     * 熟悉编程语言: java,c语言,html,css,js,ARM汇编,sql,shell##
     * 熟悉框架: springboot vue springcloud mybatis##
     * 熟悉网站分布式，前后端分离开发流程##可以完成私有云平台环境搭建##
     * 熟悉数据结构与算法，计算机网络，操作系统等等##喜欢电子,与科技##
     * 对stm32,arm-gcc,makefile,openocd,嵌入式有一定了解##计算机网络: http tcp-ip##
     * 爱好音乐,吉他##熟悉开发工具 vscode idea##
     * @return
     */
    public List<String> get_features(){
        List<String> list=new ArrayList<>();


        String features = userInformationDao.get_features();
        String[] split = features.split("##");
        for (String s : split) {
            list.add(s);
        }

        return list;
    }


    /**
     * 添加个人优势
     * @param features
     * @return
     */
    public boolean add_features(String features){
        String data="";

        List<String> features_list=new ArrayList<>();

        String features_data = userInformationDao.get_features();
        String[] split = features_data.split("##");
        for (String s : split) {
            features_list.add(s);
        }

        features_list.add(features);

        for (String s : features_list) {
            data=data+s+"##";
        }

        userInformationDao.renew_features_data(data);

        return true;
    }


    /**
     * 添加博客内容
     * @param contentData
     * @return
     */
    public boolean set_insert_blog_content(ContentData contentData){
        /**
         * 设置博客ID
         */
        IdWorker idWorker=new IdWorker();
        String id = idWorker.nextId()+"";
        contentData.setId(id);

        //设置博客时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy.MM.dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String data = sdf.format(date);
        contentData.setData(data);


        int i = blogDao.insert_Blog(contentData);

        return true;
    }


    /**
     * 登录
     * @param user
     * @return
     */
    public boolean Login(LoginUser user){

        UserInfor login = userInformationDao.Login(user.getUsername());
        if(login!=null){
            if(user.getPassword().equals(login.getPassword())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

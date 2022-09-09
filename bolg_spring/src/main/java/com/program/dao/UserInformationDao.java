package com.program.dao;


import com.program.pojo.Features;
import com.program.pojo.LoginUser;
import com.program.pojo.UserInfor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface UserInformationDao {
    UserInfor getUserInfo();

    String get_features();

    int renew_features_data(String features);

    UserInfor Login(String username);


    /**
     * 获取头像路径
     * @return
     */
    String GetAvatarPath();

    int setAvatarPath(Map<String,String> map);


    int setFeatures(Features features);
}

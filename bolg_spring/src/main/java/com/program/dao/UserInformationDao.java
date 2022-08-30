package com.program.dao;


import com.program.pojo.LoginUser;
import com.program.pojo.UserInfor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInformationDao {
    UserInfor getUserInfo();

    String get_features();

    int renew_features_data(String features);

    UserInfor Login(String username);
}

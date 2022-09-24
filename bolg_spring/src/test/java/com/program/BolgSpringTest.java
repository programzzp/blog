package com.program;


import com.program.dao.BlogDao;
import com.program.dao.UserInformationDao;
import com.program.pojo.*;
import com.program.service.FileUpload;
import com.program.service.ProjectService;
import com.program.service.UserService;
import com.program.util.ImageFile;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BolgSpringTest {

    @Autowired
    private FileUpload fileUpload;

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserInformationDao userInformationDao;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Test
    public void test(){
        List<String> features = userService.get_features();
        for (String feature : features) {
            System.out.println(feature);
        }
    }

    @Test
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy.MM.dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
    }

    @Test
    public void test2(){
        Project project=new Project("","C语言http服务器","https://github.com/programzzp/C_Http_Server");
        boolean b = projectService.insertProject(project);
        System.out.println(b);
    }

}

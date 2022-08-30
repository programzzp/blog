package com.program.Controller;


import com.program.dao.BlogDao;
import com.program.pojo.*;
import com.program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserService userService;

    /**
     * 获取所有博客数据（已经不使用 ）
     * @return
     */
    @RequestMapping(path = "/content",method = RequestMethod.GET)
    public Result MqttEsp8266Data(){
        List<ContentData> content_data = blogDao.getContent_Data();
        return new Result(true, StatusCode.OK,"查询成功",content_data);
    }


    /**
     * 获取博客内容
     * @param title
     * @return
     */
    @RequestMapping(path = "/code/{title}" ,method = RequestMethod.GET)
    public Result Get_Code(@PathVariable(name = "title") String title){
        String code = blogDao.get_Code(title);
        return new Result(true, StatusCode.OK,"查询成功",code);
    }


    /**
     * 获取个人优势数据
     * @return
     */
    @RequestMapping(path = "/features" ,method = RequestMethod.GET)
    public Result Get_features(){
        List<String> features = userService.get_features();
        return new Result(true, StatusCode.OK,"查询成功",features);
    }


    /**
     * 添加博客数据
     * @param contentData
     * @return
     */
    @RequestMapping(path = "/insert_blog" ,method = RequestMethod.POST)
    public Result insert_blog(ContentData contentData){
        boolean b = userService.set_insert_blog_content(contentData);
        return new Result(true, StatusCode.OK,"查询成功","添加成功");
    }


    /**
     * 登录
     * @param loginUser
     * @return
     */
    @RequestMapping(path = "/login" ,method = RequestMethod.POST)
    public Result login(LoginUser loginUser){
        boolean login = userService.Login(loginUser);
        if(login){
            return new Result(true, StatusCode.OK,"查询成功","108370098");
        }else{
            return new Result(false, StatusCode.ERROR,"查询失败","108370098");
        }
    }


    /**
     * 删除博客
     * @param id
     * @return
     */
    @RequestMapping(path="/deleteCode/{id}",method = RequestMethod.GET)
    public Result deleteCode(@PathVariable(name = "id")String id){
        //System.out.println(id);
        int i = blogDao.deleteCode(id);
        return new Result(true, StatusCode.OK,"查询成功","成功");
    }


    /**
     * 搜索博客
     * @param value
     * @return
     */
    @RequestMapping(path="/SeachCode/{value}",method = RequestMethod.GET)
    public Result GetClassification(@PathVariable(name = "value")String value){
       List<ContentData> contentData = blogDao.GetClassification(value);
        return new Result(true, StatusCode.OK,"查询成功",contentData);
    }


    /**
     * 获取所有博客的个数
     * @return
     */
    @RequestMapping(path="/getBlogNumber",method = RequestMethod.GET)
    public Result GetClassification(){
        int i = blogDao.GetBlogNumber();
        return new Result(true, StatusCode.OK,"查询成功",i);
    }


    /**
     * 分页获取数据
     * @param showBlog
     * @return
     */
    @RequestMapping(path = "/paginationShowData",method = RequestMethod.GET)
    public Result PaginationShowDataController(ShowBlog showBlog){
        int page=(showBlog.getPage()-1)*4;
        ShowBlog show=new ShowBlog(page,showBlog.getSize());
        List<ContentData> contentData = blogDao.PaginationShowData(show);
        return new Result(true, StatusCode.OK,"查询成功",contentData);
    }

}

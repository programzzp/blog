package com.program.Controller;


import com.program.pojo.Project;
import com.program.pojo.Result;
import com.program.pojo.StatusCode;
import com.program.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping(path = "/insertProject" ,method = RequestMethod.POST)
    public Result insertProject(Project project){
        boolean result = projectService.insertProject(project);
        if (result){
            return new Result(true, StatusCode.OK,"添加成功","OK");
        }else{
            return new Result(false, StatusCode.ERROR,"添加失败","NO");
        }
    }


    @RequestMapping(path = "/deleteOneProject/{id}" ,method = RequestMethod.GET)
    public Result deleteOneProject(@PathVariable(name = "id") String id){
        boolean result = projectService.deleteOneProject(id);
        if (result){
            return new Result(true, StatusCode.OK,"删除成功","OK");
        }else{
            return new Result(false, StatusCode.ERROR,"删除失败","NO");
        }
    }

    @RequestMapping(path = "/upDataProject" ,method = RequestMethod.POST)
    public Result upDataProject(Project project){
        boolean result = projectService.upDataProject(project);
        if (result){
            return new Result(true, StatusCode.OK,"修改成功","OK");
        }else{
            return new Result(false, StatusCode.ERROR,"修改失败","NO");
        }
    }


    @RequestMapping(path = "/getOneProjectInformation/{id}" ,method = RequestMethod.GET)
    public Result getOneProjectInformation(@PathVariable(name = "id") String id){
        Project data = projectService.getOneProjectInformation(id);
        if (data!=null){
            return new Result(true, StatusCode.OK,"查询成功",data);
        }else{
            return new Result(false, StatusCode.ERROR,"查询失败",null);
        }
    }


    @RequestMapping(path = "/getAllProjectInformation" ,method = RequestMethod.GET)
    public Result getAllProjectInformation(){
        List<Project> data = projectService.getAllProjectInformation();
        if (data!=null){
            return new Result(true, StatusCode.OK,"查询成功",data);
        }else{
            return new Result(false, StatusCode.ERROR,"查询失败",null);
        }
    }

}

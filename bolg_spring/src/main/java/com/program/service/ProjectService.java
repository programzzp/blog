package com.program.service;

import com.program.dao.ProjectDao;
import com.program.pojo.IdWorker;
import com.program.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;


    /**
     * 添加项目
     * @param project
     * @return
     */
    public boolean insertProject(Project project){
        IdWorker idWorker=new IdWorker();
        project.setId(idWorker.nextId()+"");
        int i = projectDao.insertProject(project);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 修改项目
     * @param project
     * @return
     */
    public boolean upDataProject(Project project){
        int i = projectDao.upDataProject(project);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 获取指定的数据
     * @param id
     * @return
     */
    public Project getOneProjectInformation(String id){
        Project oneProjectInformation = projectDao.getOneProjectInformation(id);
        return oneProjectInformation;
    }


    /**
     * 获取所有数据
     * @return
     */
    public List<Project> getAllProjectInformation(){
        return projectDao.getAllProjectInformation();
    }


    /**
     * 删除信息
     * @param id
     * @return
     */
    public boolean deleteOneProject(String id){
        int i = projectDao.deleteOneProject(id);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }




}

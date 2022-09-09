package com.program.dao;

import com.program.pojo.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProjectDao {

    public int insertProject(Project project);

    public int upDataProject(Project project);

    public Project getOneProjectInformation(String id);

    public List<Project> getAllProjectInformation();

    public int deleteOneProject(String id);
}

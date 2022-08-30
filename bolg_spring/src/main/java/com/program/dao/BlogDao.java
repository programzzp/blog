package com.program.dao;

import com.program.pojo.ContentData;
import com.program.pojo.ShowBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogDao {
    List<ContentData> getContent_Data();

    String get_Code(String title);

    int insert_Blog(ContentData contentData);

    int deleteCode(String id);


    List<ContentData> GetClassification(String classification);

    int GetBlogNumber();

    List<ContentData> PaginationShowData(ShowBlog showBlog);
}

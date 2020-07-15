package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(String ids);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    List<News> selectAllNews(String title);

    int updateNewsOpen(@Param("id") int id, @Param("isopen") boolean isopen);
}
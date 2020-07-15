package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String  ids);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKeyWithBLOBs(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectAllTask(String title);

    int updateTaskState(@Param("taskstate") int taskstate, @Param("id") int id);
}
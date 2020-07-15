package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.TaskClass;

import java.util.List;

public interface TaskClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskClass record);

    int insertSelective(TaskClass record);

    TaskClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskClass record);

    int updateByPrimaryKey(TaskClass record);

    List<TaskClass> selectAllTaskClass();
}
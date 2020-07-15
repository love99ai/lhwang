package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.TaskClass;

import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: TaskClassService
 * @Description:
 * @date 2020/6/17
 */
public interface TaskClassService {

    List<TaskClass> selectAllTaskClass();
    String taskClassList();
    String addTaskClass(TaskClass taskClass);
    String updateTaskClass(TaskClass taskClass);
    String delTaskClass(int taskClassId);
}

package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.Task;

/**
 * @author zhaomaohui
 * @ClassName: TaskService
 * @Description:
 * @date 2020/6/19
 */
public interface TaskService {

    public String addTask(Task task);

    public String selectAllTask(String title);

    public String updateTaskState (int taskstate,int id);

    public String updateTask(Task task);

    public String deletTask(String taskIds);
}

package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.TaskClassMapper;
import com.kunguo.linghuawang.pojo.TaskClass;
import com.kunguo.linghuawang.service.TaskClassService;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: TaskClassServiceImpl
 * @Description:
 * @date 2020/6/17
 */
@Service
public class TaskClassServiceImpl implements TaskClassService {

    @Autowired
    TaskClassMapper taskClassMapper;
    @Override
    public List<TaskClass> selectAllTaskClass() {
        return taskClassMapper.selectAllTaskClass();
    }

    @Override
    public String taskClassList() {
        ResultJson resultJson = new ResultJson();
        List<TaskClass> list  = taskClassMapper.selectAllTaskClass();
        resultJson.setObj(list);
        resultJson.setCount(list.size());
        resultJson.setMsg("");
        return resultJson.getJson();
    }

    @Override
    public String addTaskClass(TaskClass taskClass) {

        ResultJson resultJson = new ResultJson();
        int result =   taskClassMapper.insert(taskClass);
        if (result==0){
            resultJson.setCode(401);
        }
        return resultJson.getJson();
    }

    @Override
    public String updateTaskClass(TaskClass taskClass) {
        ResultJson resultJson = new ResultJson();
        int result =   taskClassMapper.updateByPrimaryKey(taskClass);
        if (result==0){
            resultJson.setCode(401);
        }
        return resultJson.getJson();
    }

    @Override
    public String delTaskClass(int taskClassId) {
        ResultJson resultJson = new ResultJson();
        int result =   taskClassMapper.deleteByPrimaryKey(taskClassId);
        if (result==0){
            resultJson.setCode(401);
        }
        return resultJson.getJson();
    }
}

package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.TaskMapper;
import com.kunguo.linghuawang.pojo.Task;
import com.kunguo.linghuawang.service.TaskService;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: TaskServiceImpl
 * @Description:
 * @date 2020/6/19
 */
@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskMapper taskMapper;
    /**添加任务**/
    @Override
    public String addTask(Task task) {
        ResultJson resultJson = new ResultJson();
        //判断是否限制个数
        if (task.getIsnum()){
            task.setTasklastnum(task.getTasknum());
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式/
        task.setCreatetime(df.format(new Date()));
       int code =  taskMapper.insertSelective(task);
        if (code>0){
            resultJson.setMsg("任务添加成功");
        }else {
            resultJson.setCode(401);
            resultJson.setMsg("任务添加失败");
        }

        return resultJson.getJson();
    }

    /**查询所有任务*/
    @Override
    public String selectAllTask(String title) {
        ResultJson resultJson = new ResultJson();
        List<Task> list = taskMapper.selectAllTask(title);
        resultJson.setObj(list);
        resultJson.setCount(list.size());
        resultJson.setMsg("");
        return  resultJson.getJson() ;
    }

    @Override
    public String updateTaskState(int taskstate, int id) {
        ResultJson resultJson = new ResultJson();
        int result = taskMapper.updateTaskState(taskstate,id);
        if (result==0){
            resultJson.setCode(401);
        }
        return resultJson.getJson();
    }

    @Override
    public String updateTask(Task task) {
        ResultJson resultJson = new ResultJson();
        task.setTasklastnum(task.getTasknum());
        int result = taskMapper.updateByPrimaryKeySelective(task);
        if (result==0){
            resultJson.setCode(401);
            resultJson.setMsg("修改失败");
        }else {
            resultJson.setMsg("修改成功");
        }
        return resultJson.getJson();
    }

    @Override
    public String deletTask(String taskIds) {
        ResultJson resultJson = new ResultJson();
        int result = taskMapper.deleteByPrimaryKey(taskIds);
        if (result==0){
            resultJson.setCode(401);
        }else {
            resultJson.setMsg("删除成功");
        }
        return resultJson.getJson();
    }


}

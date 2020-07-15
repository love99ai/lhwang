package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Admin;
import com.kunguo.linghuawang.pojo.Task;
import com.kunguo.linghuawang.pojo.TaskClass;
import com.kunguo.linghuawang.service.TaskClassService;
import com.kunguo.linghuawang.service.TaskService;
import com.kunguo.linghuawang.utils.QiniuCloudUtil;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaomaohui
 * @ClassName: TaskAjaxController
 * @Description:
 * @date 2020/6/17
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class TaskAjaxController {

    @Autowired
    private TaskClassService taskClassService;
    @Autowired
    private TaskService taskService;


    //任务列表
    @RequestMapping(value = "/taskList")
    public String taskList(@RequestParam("title") String title){
        return  taskService.selectAllTask(title);
    }


    //新增任务
    @RequestMapping(value = "/taskAdd")
    public String taskAdd(@RequestBody Task task, HttpSession session){


        Admin admin = (Admin) session.getAttribute("admin");
        //判断超级管理员
        if (admin.getRoleid() !=-1){
            task.setTaskstate(2); // 设置任务待审核
        }else {
            task.setTaskstate(1); // 设置任务待审核
        }

        return taskService.addTask(task);
    }

    //上传图片
    @RequestMapping(value = "/uploadImg")
    public Map<String,String> uploadImg(@RequestParam("file") MultipartFile uploadFile) throws IOException {
        String url = QiniuCloudUtil.upload(uploadFile);
        //生成的文件会存在本地，我这里选择删除它
        Map map = new HashMap<String,String>();
        map.put("url",url);
        return map;
    }


    // 富文本框上传图片
    @RequestMapping(value = "/uploadImgEdit")
    public String uploadImgEdit(@RequestParam("file") MultipartFile uploadFile) throws IOException {
        String url = QiniuCloudUtil.upload(uploadFile);
        //生成的文件会存在本地，我这里选择删除它
        Map map = new HashMap<String,String>();
        map.put("src",url);
        map.put("thumb",url);
        ResultJson resultJson = new ResultJson();
        resultJson.setObj(map);
        return resultJson.getJson();
    }

    /**修改任务状态，启用。关闭，审核**/
    @RequestMapping(value = "/updateTaskState")
    public String updateTaskState(@RequestParam("taskid") int taskid,@RequestParam("taskState") int taskState){
        return taskService.updateTaskState(taskState,taskid);
    }

    //修改
    @RequestMapping(value = "/updateTask")
    public String updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    //删除
    @RequestMapping(value = "/deletTask")
    public String deletTask(@RequestParam("taskids") String taskids){
        return taskService.deletTask(taskids);
    }



    @RequestMapping(value = "/taskClassList")
    public String taskList(){
        return  taskClassService.taskClassList();
    }



    @RequestMapping(value = "/taskClassAdd")
    public String taskClassAdd(@RequestBody TaskClass taskClass){
        return  taskClassService.addTaskClass(taskClass);
    }

    @RequestMapping(value = "/taskClassUpdate")
    public String taskClassUpdate(@RequestBody TaskClass taskClass){
        return  taskClassService.updateTaskClass(taskClass);
    }

    @RequestMapping(value = "/taskClassDel")
    public String taskClassDel(@RequestParam("taskClassId") int taskClassId){
        return  taskClassService.delTaskClass(taskClassId);
    }

}

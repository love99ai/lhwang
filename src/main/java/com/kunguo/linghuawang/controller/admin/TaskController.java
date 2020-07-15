package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.service.TaskClassService;
import com.kunguo.linghuawang.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * //TODO  任务管理
 * @author zhaomaohui
 * @ClassName: TaskController
 * @Description:
 * @date 2020/6/16
 */

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class TaskController {


    @Autowired
    private TaskClassService taskClassService;

    @Autowired
    private TaskService taskService;

    //任务列表
    @RequestMapping(value = "/taskListInit")
    public String taskListInit(){
        return "adminpage/task/taskList.html";
    }

    //初始化添加任务
    @RequestMapping(value = "/taskAddInit")
    public String taskAddInit(Model model){
        //任务类型集合
        model.addAttribute("taskClassList", taskClassService.selectAllTaskClass());
        return "adminpage/task/taskAdd.html";
    }


    //任务分类列表
    @RequestMapping(value = "/taskClassListInit")
    public String taskClassListInit(){
        return "adminpage/task/taskClassList.html";
    }

    //初始化添加任务
    @RequestMapping(value = "/taskClassAddInit")
    public String taskClassAddInit(Model model){
        return "adminpage/task/taskClassAdd.html";
    }





}

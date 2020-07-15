package com.kunguo.linghuawang.controller.admin;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 公告
 * @author zhaomaohui
 * @ClassName: NoticeController
 * @Description:
 * @date 2020/6/30
 */

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class NoticeController {


    @RequestMapping(value = "/noticeListInit")
    public String noticeListInit(){
        return "adminpage/notice/noticeList.html";
    }

    //初始化添加任务
    @RequestMapping(value = "/noticeAddInit")
    public String noticeAddInit(Model model){
        return "adminpage/notice/noticeAdd.html";
    }
}

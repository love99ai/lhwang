package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Notice;
import com.kunguo.linghuawang.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaomaohui
 * @ClassName: NoticeAjaxController
 * @Description:
 * @date 2020/6/30
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class NoticeAjaxController {

    @Autowired
    private NoticeService noticeService;

    //公告列表
    @RequestMapping(value = "/noticeList")
    public String noticeList(@RequestParam("title") String title){
        return  noticeService.selectAllNotice(title);
    }

    //新增公告
    @RequestMapping(value = "/noticeAdd")
    public String noticeAdd(@RequestBody Notice notice){
        return noticeService.addNotice(notice);
    }

    //修改公告
    @RequestMapping(value = "/noticeUpdate")
    public String noticeUpdate(@RequestBody Notice news){
        return noticeService.updateNotice(news);
    }


    @RequestMapping(value = "/noticeDel")
    public String noticeDel(@RequestParam("newsIds") String newsIds){
        return  noticeService.delNotice(newsIds);
    }
}

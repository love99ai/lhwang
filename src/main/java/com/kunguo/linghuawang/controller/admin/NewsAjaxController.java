package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Admin;
import com.kunguo.linghuawang.pojo.News;
import com.kunguo.linghuawang.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhaomaohui
 * @ClassName: NewsAjaxController
 * @Description:
 * @date 2020/6/29
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class NewsAjaxController {

    @Autowired
    private NewsService newsService;


    //文章列表
    @RequestMapping(value = "/newsList")
    public String newsList(@RequestParam("title") String title){
        return  newsService.selectAllNews(title);
    }


    //新增文章
    @RequestMapping(value = "/newsAdd")
    public String newsAdd(@RequestBody News news){
        return newsService.addNews(news);
    }
    //修改文章
    @RequestMapping(value = "/newsUpdate")
    public String newsUpdate(@RequestBody News news){
        return newsService.updateNews(news);
    }

    /**修改任务状态，启用。关闭**/
    @RequestMapping(value = "/updateNewsOpen")
    public String updateNewsOpen(@RequestParam("newsId") int newsId,@RequestParam("isOpen") boolean isOpen){
        return newsService.updateNewsOpen(newsId,isOpen);
    }

    @RequestMapping(value = "/newsDel")
    public String newsDel(@RequestParam("newsIds") String newsIds){
        return  newsService.delNews(newsIds);
    }
}

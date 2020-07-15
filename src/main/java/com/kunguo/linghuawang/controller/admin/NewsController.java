package com.kunguo.linghuawang.controller.admin;




import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaomaohui
 * @ClassName: NewsController
 * @Description:
 * @date 2020/6/29
 */

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class NewsController {



    @RequestMapping(value = "/newsListInit")
    public String newsListInit(){
        return "adminpage/news/newsList.html";
    }


    //初始化添加任务
    @RequestMapping(value = "/newsAddInit")
    public String newsAddInit(Model model){
        return "adminpage/news/newsAdd.html";
    }
}

package com.kunguo.linghuawang.controller.admin;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaomaohui
 * @ClassName: BannerController
 * @Description:
 * @date 2020/6/30
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class BannerController {

    @RequestMapping(value = "/bannerListInit")
    public String bannerListInit(){
        return "adminpage/banner/bannerList.html";
    }


    //初始化添加任务
    @RequestMapping(value = "/bannerAddInit")
    public String bannerAddInit(Model model){
        return "adminpage/banner/bannerAdd.html";
    }
}

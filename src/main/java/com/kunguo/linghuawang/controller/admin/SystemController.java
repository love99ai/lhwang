package com.kunguo.linghuawang.controller.admin;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaomaohui
 * @ClassName: SystemController
 * @Description:
 * @date 2020/6/16
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class SystemController {


    @RequestMapping(value = "/systemSetting")
    public String adminWelcome(){
        return "adminpage/systemSetting/basicParameter.html";
    }
}

package com.kunguo.linghuawang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaomaohui
 * @ClassName: IndexController
 * @Description:
 * @date 2020/5/18
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/linghuawang")
    public String index()  {
        return "index.html";
    }
}

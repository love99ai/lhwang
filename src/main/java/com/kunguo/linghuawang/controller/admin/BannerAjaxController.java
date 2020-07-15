package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Banner;
import com.kunguo.linghuawang.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaomaohui
 * @ClassName: BannerAjaxController
 * @Description:
 * @date 2020/6/30
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class BannerAjaxController {

    @Autowired
    private BannerService bannerService;

    //公告列表
    @RequestMapping(value = "/bannerList")
    public String noticeList(@RequestParam("title") String title){
        return  bannerService.selectAllBanner(title);
    }

    //新增公告
    @RequestMapping(value = "/bannerAdd")
    public String bannerAdd(@RequestBody Banner banner){
        return bannerService.addBanner(banner);
    }

    //修改公告
    @RequestMapping(value = "/bannerUpdate")
    public String bannerUpdate(@RequestBody Banner banner){
        return bannerService.updateBanner(banner);
    }


    @RequestMapping(value = "/bannerDel")
    public String bannerDel(@RequestParam("newsIds") String bannerIds){
        return  bannerService.delBanner(bannerIds);
    }
}

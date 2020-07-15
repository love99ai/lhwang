package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Admin;
import com.kunguo.linghuawang.service.AdminService;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhaomaohui
 * @ClassName: AdminController
 * @Description:
 * @date 2020/5/18
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class AdminAjaxController {


    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/login")
    public String adminLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session){

        ResultJson resultJson = new ResultJson();
        resultJson.setCode(201);
        if (adminService.findByName(userName)!=1){
            resultJson.setMsg("账号不存在！");
            return resultJson.getJson();
        }
        Admin admin = adminService.adminLogin(userName,password);

        if (admin == null){
            resultJson.setMsg("密码错误！");
        }else  if (admin.getIsenable() == 0){
            resultJson.setMsg("你的帐号被停用请联系站点管理员！");
        }else {
            session.setAttribute("admin",admin);
            resultJson.setMsg("登录成功！");
            resultJson.setCode(200);
        }

        return resultJson.getJson();
    }




}

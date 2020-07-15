package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Admin;
import com.kunguo.linghuawang.pojo.VRoleRights;
import com.kunguo.linghuawang.service.AdminService;
import com.kunguo.linghuawang.service.RoleRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: AdminController
 * @Description:
 * @date 2020/5/18
 */

@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class AdminController {


    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleRightsService rightsService;


    @RequestMapping(value = "/")
    public String getAdmin(){
        return "adminpage/login/login.html";
    }


    @RequestMapping(value = "/index")
    public String adminIndex(HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        List<VRoleRights> roleRights= rightsService.getRoleRights(admin.getRoleid());
        model.addAttribute("roleRights", roleRights);
        model.addAttribute("nickName",admin.getNickname());
        return "adminpage/index.html";
    }

    @RequestMapping(value = "/welcome")
    public String adminWelcome(){
        return "adminpage/welcome.html";
    }


    @RequestMapping(value = "/main")
    public String adminMain(){
        return "adminpage/main.html";
    }


}

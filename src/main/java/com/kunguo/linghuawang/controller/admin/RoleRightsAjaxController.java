package com.kunguo.linghuawang.controller.admin;

import com.kunguo.linghuawang.pojo.Admin;
import com.kunguo.linghuawang.pojo.VRoleRights;
import com.kunguo.linghuawang.service.RoleRightsService;
import com.kunguo.linghuawang.utils.MapTools;
import com.kunguo.linghuawang.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * //TODO 权限管理
 * @author zhaomaohui
 * @ClassName: RoleRightsController
 * @Description:
 * @date 2020/5/21
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin" )
public class RoleRightsAjaxController {


    @Autowired
    private RoleRightsService rightsService;

    @RequestMapping(value = "/roleRights")
    public String adminRoleRights(@RequestParam("parentId") String parentId, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        ResultJson resultJson = new ResultJson();

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map= null;
        //一级菜单
        List<VRoleRights>  roleRights = rightsService.selectRoleRightsChild(admin.getRoleid(),Integer.parseInt(parentId));
        //二级菜单
        for (int i =0; i < roleRights.size();i++) {
            map =  MapTools.objectToMap(roleRights.get(i));
            map.put("children", rightsService.selectRoleRightsChild(admin.getRoleid(), roleRights.get(i).id));
            list.add(map);
        }
        resultJson.setObj(list);
        return resultJson.getJson();
    }


}

package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.VRoleRights;

import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: RoleRightsService
 * @Description:
 * @date 2020/5/21
 */
public interface RoleRightsService {


    /**查询角色权限**/
    public List<VRoleRights> getRoleRights(int roleId);

    public List<VRoleRights>  selectRoleRightsChild(int roleId,int parentId);
}

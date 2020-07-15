package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.RoleRightsMapper;
import com.kunguo.linghuawang.pojo.VRoleRights;
import com.kunguo.linghuawang.service.RoleRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaomaohui
 * @ClassName: RoleRightsServiceImpl
 * @Description:
 * @date 2020/5/21
 */
@Service
public class RoleRightsServiceImpl implements RoleRightsService {

    @Autowired
    RoleRightsMapper roleRightsMapper;

    @Override
    public List<VRoleRights> getRoleRights(int roleId) {
        return roleRightsMapper.selectRoleRights(roleId);
    }

    @Override
    public List<VRoleRights> selectRoleRightsChild(int roleId, int parentId) {
        return roleRightsMapper.selectRoleRightsChild(roleId,parentId);
    }
}

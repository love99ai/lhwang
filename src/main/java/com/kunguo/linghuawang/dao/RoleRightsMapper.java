package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.RoleRights;
import com.kunguo.linghuawang.pojo.VRoleRights;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleRightsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleRights record);

    int insertSelective(RoleRights record);

    RoleRights selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleRights record);

    int updateByPrimaryKey(RoleRights record);

    List<VRoleRights> selectRoleRights(int roleId);

    List<VRoleRights>  selectRoleRightsChild(@Param("roleId")int roleId,@Param("parentId") int parentId);
}
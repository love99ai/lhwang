package com.kunguo.linghuawang.dao;

import com.kunguo.linghuawang.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin findByName(@Param("userName") String userName);

    /**用户登录信息**/
    Admin adminLogin(@Param("userName") String userName, @Param("password") String password);
}
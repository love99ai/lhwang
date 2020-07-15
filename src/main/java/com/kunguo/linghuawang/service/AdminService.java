package com.kunguo.linghuawang.service;

import com.kunguo.linghuawang.pojo.Admin;

public interface AdminService {

    /**跟进ID查询管理员**/
    Admin selectByPrimaryKey(Integer id);
    /**查询用户是否存在**/
    int findByName(String userName);

    /**管理员登录**/
    Admin  adminLogin(String userName,String password);
}

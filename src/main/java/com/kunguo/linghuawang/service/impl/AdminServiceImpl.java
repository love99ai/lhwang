package com.kunguo.linghuawang.service.impl;

import com.kunguo.linghuawang.dao.AdminMapper;
import com.kunguo.linghuawang.pojo.Admin;
import com.kunguo.linghuawang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaomaohui
 * @ClassName: AdminServiceImpl
 * @Description:
 * @date 2020/5/18
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminDao;

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminDao.selectByPrimaryKey(id);
    }

    @Override
    public int findByName(String userName) {
        Admin admin = adminDao.findByName(userName);
        if ( admin == null)
            return 0;
        else
            return 1;
    }


    @Override
    public Admin adminLogin(String userName, String password) {
        return adminDao.adminLogin(userName,password);
    }
}

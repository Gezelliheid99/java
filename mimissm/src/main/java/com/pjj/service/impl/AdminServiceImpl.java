package com.pjj.service.impl;

import com.pjj.dao.AdminDao;
import com.pjj.pojo.Admin;
import com.pjj.service.AdminService;
import com.pjj.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 潘俊杰
 * @date 2021年09月06日 19:35
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String name, String password) {
        String pass = MD5Util.getMD5(password);
        Admin admin = adminDao.queryByName(name);
        System.out.println(pass);
        if (pass.equals(admin.getaPass())){
            return admin;
        }
        return null;
    }
}

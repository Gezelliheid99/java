package com.pjj.service;

import com.pjj.pojo.Admin;

/**
 * @author 潘俊杰
 * @date 2021年09月06日 19:34
 */
public interface AdminService {

    Admin login(String name , String password);
}

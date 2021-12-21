package com.pjj.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjj.boot.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月25日 17:35
 */

public interface UserMapper extends BaseMapper<User>{

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 查询用户
     * @param id
     * @return
     */
    List<User> selectUserById(Integer id);


}

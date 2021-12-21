package com.pjj.order.service.impl;

import com.pjj.order.entity.User;
import com.pjj.order.mapper.UserMapper;
import com.pjj.order.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pjj
 * @since 2021-09-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

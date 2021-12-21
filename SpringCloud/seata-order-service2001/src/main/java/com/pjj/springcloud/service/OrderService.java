package com.pjj.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pjj.springcloud.pojo.Order;

/**
*
*/
public interface OrderService extends IService<Order> {
    void create(Order order);
}

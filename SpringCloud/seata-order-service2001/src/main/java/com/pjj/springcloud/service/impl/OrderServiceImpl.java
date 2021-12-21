package com.pjj.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjj.springcloud.mapper.OrderMapper;
import com.pjj.springcloud.pojo.Order;
import com.pjj.springcloud.service.AccountService;
import com.pjj.springcloud.service.OrderService;
import com.pjj.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*
*/
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;
    @Resource
    private OrderMapper mapper;

    @Override
    @GlobalTransactional(name = "create-order-service",rollbackFor = Throwable.class)
    public void create(Order order) {
        log.info("===>开始新建订单");
        mapper.insert(order);
        log.info("===>库存扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("===>库存扣减完成");

        log.info("===>账户余额扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("===>账户余额扣减完成");

        //修改订单状态
        log.info("===>修改订单状态开始");
        order.setStatus(1);
        order.updateById();
        log.info("===>修改订单状态结束");

        log.info("订单创建完成");

    }

















}

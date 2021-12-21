package com.pjj.springcloud.controller;

import com.pjj.springcloud.mapper.OrderMapper;
import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Order;
import com.pjj.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 16:22
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private OrderMapper mapper;

    @GetMapping(value = "/order/create")
    public CommonResult createOrder(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建完成", order);
    }

    @GetMapping("/order/query/{id}")
    public CommonResult queryOrder(@PathVariable("id") Long id){
        Order order = mapper.selectById(id);
        return new CommonResult(200, "查询到结果", order);
    }
}

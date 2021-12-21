package com.pjj.book.dao.impl;

import com.pjj.book.dao.OrderDao;
import com.pjj.book.pojo.Order;

/**
 * @author 潘俊杰
 * @date 2021年08月17日 15:44
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int createOrder(Order order) {
        String sql = "insert into t_order(`orderId`,`createTime`,`price`,`status`,`userId`) values (?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}

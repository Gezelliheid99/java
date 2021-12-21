package com.pjj.book.dao.impl;

import com.pjj.book.dao.OrderItemsDao;
import com.pjj.book.pojo.OrderItems;

/**
 * @author 潘俊杰
 * @date 2021年08月17日 15:47
 */
public class OrderItemsDaoImpl extends BaseDao implements OrderItemsDao {
    @Override
    public int createOrderItem(OrderItems orderItems) {
        String sql = "insert into t_orderItems(`name`,`count`,`price`,`totalPrice`,`orderId`) values(?,?,?,?,?)";
        return update(sql,orderItems.getName(),orderItems.getCount(),orderItems.getPrice(),orderItems.getTotalPrice(),orderItems.getOrderId());
    }
}

package com.pjj.book.test;

import com.pjj.book.dao.OrderItemsDao;
import com.pjj.book.dao.impl.OrderItemsDaoImpl;
import com.pjj.book.pojo.OrderItems;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemsDaoTest {

    @Test
    public void createOrderItem() {
        OrderItemsDao orderItemsDao = new OrderItemsDaoImpl();
        orderItemsDao.createOrderItem(new OrderItems(null, "黑客攻防从入门到入狱", 1, new BigDecimal(50), new BigDecimal(50), "1234567"));
    }
}
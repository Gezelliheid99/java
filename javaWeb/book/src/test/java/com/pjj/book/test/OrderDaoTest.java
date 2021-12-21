package com.pjj.book.test;

import com.pjj.book.dao.OrderDao;
import com.pjj.book.dao.impl.OrderDaoImpl;
import com.pjj.book.pojo.Order;
import org.junit.Test;

import javax.xml.crypto.Data;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void createOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.createOrder(new Order("1234567",new Date(),new BigDecimal(100),0,1));
    }
}
package com.pjj.book.test;

import com.pjj.book.pojo.Cart;
import com.pjj.book.pojo.CartItems;
import com.pjj.book.service.OrderService;
import com.pjj.book.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        OrderService orderService = new OrderServiceImpl();
        cart.addItem(new CartItems(1,"java从入门到入狱",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(2,"java1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(3,"java2",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));

        String orderId = orderService.createOrder(cart, 1);
        System.out.println(orderId);
    }
}
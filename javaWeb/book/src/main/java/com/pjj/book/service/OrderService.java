package com.pjj.book.service;

import com.pjj.book.pojo.Cart;
import com.pjj.book.pojo.Order;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}

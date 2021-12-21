package com.pjj.book.service.impl;

import com.pjj.book.dao.BookDao;
import com.pjj.book.dao.OrderDao;
import com.pjj.book.dao.OrderItemsDao;
import com.pjj.book.dao.impl.BookDaoImpl;
import com.pjj.book.dao.impl.OrderDaoImpl;
import com.pjj.book.dao.impl.OrderItemsDaoImpl;
import com.pjj.book.pojo.*;
import com.pjj.book.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author 潘俊杰
 * @date 2021年08月17日 16:11
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemsDao orderItemsDao = new OrderItemsDaoImpl();
    private  BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号的唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        // 保存订单
        orderDao.createOrder(order);
        //遍历购物车当中的商品项转化成为订单项
        for (Map.Entry<Integer, CartItems>entry : cart.getItems().entrySet()){
            CartItems cartItems = entry.getValue();
            OrderItems orderItems =
                    new OrderItems(null, cartItems.getName(), cartItems.getCount(), cartItems.getPrice(), cartItems.getTotalPrice(), orderId);
            orderItemsDao.createOrderItem(orderItems);
            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItems.getId());
            book.setSales(book.getSales() + cartItems.getCount());
            book.setStock(book.getStock() - cartItems.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();


        return orderId;
    }
}

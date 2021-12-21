package com.pjj.book.web;

import com.pjj.book.pojo.Cart;
import com.pjj.book.pojo.User;
import com.pjj.book.service.OrderService;
import com.pjj.book.service.impl.OrderServiceImpl;
import com.pjj.book.utils.JdbcUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImpl();

    /**
     * 创建订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cart对象，再创建orderService
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = user.getId();
        // 生成订单
        String orderId = orderService.createOrder(cart, userId);
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
}

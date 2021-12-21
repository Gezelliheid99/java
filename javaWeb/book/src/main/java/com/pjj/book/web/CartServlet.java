package com.pjj.book.web;

import com.google.gson.Gson;
import com.pjj.book.pojo.Book;
import com.pjj.book.pojo.Cart;
import com.pjj.book.pojo.CartItems;
import com.pjj.book.service.BookService;
import com.pjj.book.service.impl.BookServiceImpl;
import com.pjj.book.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 调用方法得到book对象
        Book book = bookService.queryBookById(id);
        //转化成item对象
        CartItems cartItems = new CartItems(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用cart的方法加入购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItems);
        // 刚刚添加的商品名称
        request.getSession().setAttribute("lastName",cartItems.getName());
        // 重定向回原来商品的所在页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 删除商品项
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数，商品数量和id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        // 获取cart购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateCount(id,count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 调用方法得到book对象
        Book book = bookService.queryBookById(id);
        //转化成item对象
        CartItems cartItems = new CartItems(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用cart的方法加入购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItems);
        // 刚刚添加的商品名称
        request.getSession().setAttribute("lastName",cartItems.getName());
        // 返回购物车内的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItems.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        response.getWriter().write(resultMapJsonString);
    }


}

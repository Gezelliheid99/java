package com.pjj.book.web;

import com.pjj.book.pojo.Book;
import com.pjj.book.pojo.Page;
import com.pjj.book.service.BookService;
import com.pjj.book.service.impl.BookServiceImpl;
import com.pjj.book.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
   private BookService bookService = new BookServiceImpl();

    /**
     * 分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取请求的参数pageNo、PageSize
        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"),1);
        // int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookService.page(pageNo,PageSize)方法返回page对象
        Page<Book> page = bookService.page(pageNum,4);
        //首页的url
        page.setUrl("client/bookServlet?action=page");
        //保存book到request域中
        request.setAttribute("page",page);
        //请求转发到管理页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取请求的参数pageNo、PageSize
        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"),1);
        // int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);
        //调用bookService.page(pageNo,PageSize)方法返回page对象
        Page<Book> page = bookService.pageByPrice(pageNum,4,min,max);
        //首页的url
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (request.getParameter("min") != null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max") != null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //保存book到request域中
        request.setAttribute("page",page);
        //请求转发到管理页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }
}

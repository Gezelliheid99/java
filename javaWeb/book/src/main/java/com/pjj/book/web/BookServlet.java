package com.pjj.book.web;

import com.pjj.book.pojo.Book;
import com.pjj.book.pojo.Page;
import com.pjj.book.service.BookService;
import com.pjj.book.service.impl.BookServiceImpl;
import com.pjj.book.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 0);
        pageNum+=1;
        //获取请求的参数，封装成book对象
        Book book = WebUtils.copyParameterToBean(request.getParameterMap(),new Book());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + pageNum);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数封装成book
        Book book = WebUtils.copyParameterToBean(request.getParameterMap(), new Book());
        //修改图书
        bookService.updateBook(book);
        //重定向到管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + request.getParameter("pageNum"));
    }

    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        bookService.deleteBookByID(new Integer(id));
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + request.getParameter("pageNum"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.获取请求参数的图书编号
        String id = request.getParameter("id");
        //2.调用bookService.queryBookById方法
        Book book = bookService.queryBookById(new Integer(id));
        //3.保存图书到request域中
        request.setAttribute("book",book);
        //4.请求转发到 pages/manager/book_edit.jsp
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2、把全部图书保存在request域中
        request.setAttribute("books",books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

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
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookService.page(pageNo,PageSize)方法返回page对象
        Page<Book> page = bookService.page(pageNum,pageSize);
        //设置后台url
        page.setUrl("manager/bookServlet?action=page");
        //保存book到request域中
        request.setAttribute("page",page);
        //请求转发到管理页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

}

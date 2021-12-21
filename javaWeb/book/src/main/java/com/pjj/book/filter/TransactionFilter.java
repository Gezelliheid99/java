package com.pjj.book.filter;

import com.pjj.book.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 潘俊杰
 * @date 2021年08月19日 14:19
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            //提交事务
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);  //在抛给tomcat服务器处理异常页面
        }
    }

    @Override
    public void destroy() {

    }
}

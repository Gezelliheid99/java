<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/8/5
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div>
        <%--还没登录时显示的信息--%>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp" class="button_func">登录</a> |
            <a href="pages/user/regist.jsp" class="button_func">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临小小书城</span>&nbsp;
            <a href="pages/order/order.jsp" class="button_func">我的订单</a>&nbsp;
            <a href="userServlet?action=logout" class="button_func">注销</a>&nbsp;
        </c:if>
        <a href="index.jsp" class="button_func">返回</a>
    </div>


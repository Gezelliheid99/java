<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/8/13
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="http://localhost:8080/Cookie_Session/loginServlet" method="get">
        用户名： <input type="text" name="username" value="${cookie.username.value}"> <br>
        密码： <input type="password" name="password" value="${cookie.password.value}"> <br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>

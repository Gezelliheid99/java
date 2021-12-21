<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/9/4
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出</title>
</head>
<body>

    注销帐号
    <%
        session.removeAttribute("name");
    %>


</body>
</html>

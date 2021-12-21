<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/7/30
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式1</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>
    JSP表达式输出key的值：<%=request.getAttribute("key")%> <br>
    EL表达式输出：${key}
</body>
</html>

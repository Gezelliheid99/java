<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/7/30
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乘法表</title>
</head>
<body>
    <%
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=i ; j++) {
    %>
        <%=j + "X" + i + "=" + (i*j)%>
    <%
            }
    %>
        <br>
    <%
        }
    %>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/8/3
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL1</title>
</head>
<body>
    保存之前：${requestScope.abc} <br>
    <c:set scope="request" var="abc" value="123456"></c:set>
    保存之后：${requestScope.abc} <br>

</body>
</html>

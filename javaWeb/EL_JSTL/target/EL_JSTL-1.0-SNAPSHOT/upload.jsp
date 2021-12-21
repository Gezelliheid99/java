<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/8/3
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <form action="http://localhost:8080/EL_JSTL/upload" enctype="multipart/form-data" method="post">
        用户名 <input type="text" name="username"> <br>
        头像 <input type="file" name="photo"> <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>

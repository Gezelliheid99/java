<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

    <form action="receive.do" method="post">
        姓名： <input type="text" name="name" > <br>
        年龄： <input type="text" name="age" ><br>
        <input type="submit" value="提交">
    </form>

    <p>使用java对象接收请求参数</p>
    <form action="receive1.do" method="post">
        姓名： <input type="text" name="name" > <br>
        年龄： <input type="text" name="age" ><br>
        <input type="submit" value="提交">
    </form>



</body>
</html>
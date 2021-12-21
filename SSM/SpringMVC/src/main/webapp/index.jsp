<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="">Hello Servlet</a> <br>
    <a href="some.do">doSome方法</a> <br>
    <a href="other.do">doOther方法</a> <br>

    <p>请求转发的表单</p>
    <form action="forward.do" method="post">
        姓名：<input type="text" name="name" > <br>
        年龄：<input type="text" name="age" > <br>
        <input type="submit" value="提交">
    </form>
    <br>

    <p>重定向的表单</p>
    <form action="redirect.do" method="post">
        姓名：<input type="text" name="name" > <br>
        年龄：<input type="text" name="age" > <br>
        <input type="submit" value="提交">
    </form>









</body>
</html>
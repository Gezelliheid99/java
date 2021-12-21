<%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/7/29
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面</title>
</head>
<body>
    头部信息 <br>
    主题内容 <br>

    <%--
        <%@ %>是静态包含
        /表示从webapp路径下，因为映射到的是代码的webapp目录, 表示从http://localhost:8080/工程名/
        静态包含不会翻译被包含的jsp页面
        静态包含实际上是把包含的jsp页面的内容复制过去打印
    --%>

<%--    <%@include file="/include/footer.jsp"%>--%>

    <%--
            下面是jsp页面，动态包含可以传递参数,可以在footer里面获取
    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="key1" value="value1"/>
        <jsp:param name="key2" value="value2"/>
    </jsp:include>

    <%-- 请求转发   --%>
    <jsp:forward page="/include/footer.jsp"></jsp:forward>









</body>
</html>

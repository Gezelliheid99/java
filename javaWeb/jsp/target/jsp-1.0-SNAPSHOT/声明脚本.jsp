<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/7/29
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>声明脚本</title>
</head>
<body>
<%--1.声明类属性--%>
    <%!
        private String name;
        private Integer id;
        private static Map<String,Object> map;
    %>

<%--2.声明static静态代码块--%>
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
            map.put("key4","value4");
        }
    %>

<%--3.声明类方法--%>
    <%!
        public static int abc(){
            return 100;
        }
    %>


<%--4.声明内部类--%>
    <%!
        public static class A{
            private String name="内部类";
            private Integer id = 123;
        }
    %>



</body>
</html>

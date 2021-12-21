<%@ page import="com.pjj.EL_JSTL.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.sun.jdi.Value" %><%--
  Created by IntelliJ IDEA.
  User: 98334
  Date: 2021/7/30
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL2</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("潘俊杰");
        person.setPhone(new String[]{"186113566","1831215421","1925421412"});
        List<String> cities = new ArrayList<String>();
        cities.add("北京");
        cities.add("上海");
        cities.add("深圳");
        person.setCities(cities);
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>
    输出person：${person} <br>
    输出name：${person.name} <br>
    输出phone:${person.phone[1]} <br>
    输出cities:${person.cities} <br>
    输出map：${person.map} <br>
    输出map中的元素:${person.map.key1} <br>


</body>
</html>

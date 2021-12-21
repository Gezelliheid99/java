
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<head>
    <title>ajax查询学生</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="jQuery/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function (){
            loadStudentData();
            $("#loader").click(function (){
                loadStudentData();
            })
        })

        function loadStudentData(){
            $.ajax({
                url:"student/listStudent.do",
                type:"get",
                dataType:"json",
                success:function (data){
                    $("#info").html("");
                    $.each(data,function(i,n){
                        $("#info").append("<tr>")
                            .append("<td>" + n.id + "</td>")
                            .append("<td>" + n.name + "</td>")
                            .append("<td>" + n.email + "</td>")
                            .append("<td>" + n.age + "</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>邮箱</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" value="查询信息" id="loader">
    </div>
</body>
</html>

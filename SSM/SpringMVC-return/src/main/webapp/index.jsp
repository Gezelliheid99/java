<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="text/javascript" src="jQuery/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:"returnJson.do",
                    data:{
                        name:"pjj",
                        age:20
                        },
                    type:"post",
                    dataType:"json",
                    success:function (resp){
                        alert(resp.name + " " + resp.age);
                    }

                })
            })
        })
    </script>
</head>
<body>

    <br/>
    <p>处理器方法返回String表示视图名称</p>
    <form action="/returnVoid-ajax.do" method="post">
        姓名： <input type="text" name="name" > <br>
        年龄： <input type="text" name="age" ><br>
        <input type="submit" value="提交">
    </form>
    <button id="btn">发起ajax请求</button>



</body>
</html>
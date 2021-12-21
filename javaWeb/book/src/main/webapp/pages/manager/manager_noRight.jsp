<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>无权访问管理页面</title>
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<%--静态包含的菜单栏内容--%>
				<%@include file="/pages/common/login_success_mune.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>您未拥有管理权限<a href="index.jsp">转到主页</a></h1>
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
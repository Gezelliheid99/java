<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图书管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			//给删除的a标签绑定单击事件
			$("a.delete").click(function (){
				return confirm("你确认要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗?");
			})
		})

	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=addBook&pageNum=${requestScope.page.pageNumTotal}" class="button_manager">添加图书</a></td>
			</tr>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td ><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNum=${requestScope.page.pageNum}" class="button_manager">修改</a></td>
					<td ><a href="manager/bookServlet?action=deleteBook&id=${book.id}&pageNum=${requestScope.page.pageNum}" class="button_manager delete"  id="delete" >删除</a></td>
				</tr>
			</c:forEach>
		</table>

		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
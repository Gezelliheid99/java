<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		#notLogin{
			text-align: center;
			margin-top: 200px;
		}
		#count{
			width: 60px;
		}

	</style>
	<script type="text/javascript">
		$(function(){
			// 给删除键绑定功能
			$(".deleteItem").click(function (){
				return confirm("你确认要删除【"+ $(this).parent().parent().find("td:first").text() +"】吗?")
			})
			// 给清空购物车绑定功能
			$(".clear").click(function (){
				return confirm("你确定要清空购物车吗？")
			})
			// 给修改数量绑定功能
			$(".count").blur(function (){
				// 获取商品名称
				// let name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				var id = $(this).attr("bookId");
				var countRegExp = /^[1-9]\d*$/;
				var ok = countRegExp.test(count);
				if (!ok){
					alert("商品数量不符合规定，请重新修改！");
					this.value = this.defaultValue;
				}else {
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+ count + "&id=" + id;
				}

			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%--静态包含的菜单栏内容--%>
			<%@include file="/pages/common/login_success_mune.jsp"%>
			
	</div>
	
	<div id="main">
		<%--<c:if test="${empty sessionScope.user}">
			<h1 id="notLogin">您还未登录，请先注册登录账户！</h1>
		</c:if>--%>
		<c:if test="${1==1}">
			<table>

				<c:if test="${empty sessionScope.cart.items}">
					<tr>

						<td style="width: auto"><h1 style="margin-top: 200px;"><a href="index.jsp">您的购物车空空如也，快去添加商品吧！</a></h1></td>
					</tr>
				</c:if>

				<c:if test="${not empty sessionScope.cart.items}">
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${sessionScope.cart.items}" var="entry">
						<tr>
							<td>${entry.value.name}</td>
							<td>
								<input type="number" name="count" value="${entry.value.count}" class="count" bookId="${entry.value.id}">
							</td>
							<td>${entry.value.price}</td>
							<td>${entry.value.totalPrice}</td>
							<td><a href="cartServlet?action=deleteItem&id=${entry.value.id}" class="button_manager deleteItem" >删除</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>

			<c:if test="${not empty sessionScope.cart.items}">
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
					<span ><a href="cartServlet?action=clearItem" class="button_manager clear" >清空购物车</a></span>
					<span ><a href="orderServlet?action=createOrder" class="button_manager">去结账</a></span>
				</div>
			</c:if>

		</c:if>

	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
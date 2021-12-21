<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
	<style type="text/css">
		.login_form{
			height:450px;
			margin-top: 25px;
		}

	</style>


	<script type="text/javascript">
		$(function (){
			//用户名验证
			var $usernameText = $("#username");
			var $errorUsername = $("#errorUsername");
			$usernameText.blur(function (){
				var username = $usernameText.val();
				// $.getJSON("http://localhost:8080/userServlet","action=ajaxExistUsername&username= " + username,function (data){
				// 	if (!data.examUsername){
				// 		$errorPassword.addClass("illegal");
				// 		$errorUsername.text("用户名不可用");
				// 	} else {
				// 		$errorUsername.removeClass("illegal")
				// 		$errorUsername.addClass("legal");
				// 		$errorUsername.text("用户名可用");
				// 	}
				// })
				var usernameRegExp = /^[a-z0-9_-]{6,14}$/
				var ok = usernameRegExp.test(username);
				if(!ok){
					$errorPassword.addClass("illegal");
					$errorUsername.text("用户名不合法");
				}else {
					$errorUsername.removeClass("illegal")
					$errorUsername.addClass("legal");
					$errorUsername.text("用户名合法");
				}
			});

			$usernameText.focus(function (){
				if($errorUsername.text() != "用户名合法"){
					username.value = "";
				}
				$errorUsername.html("<br>");
			});

			//用户密码
			var $passwordText = $("#password");
			var $errorPassword = $("#errorPassword");
			$passwordText.blur(function (){
				var password = $passwordText.val();
				var passwordRegExp = /^[a-z0-9_-]{6,18}$/
				var ok = passwordRegExp.test(password);
				if (!ok){
					$errorPassword.addClass("illegal");
					$errorPassword.text("密码不合法");
				}else {
					$errorPassword.removeClass("illegal")
					$errorPassword.addClass("legal");
					$errorPassword.text("密码合法");
				}
			});
			$passwordText.focus(function (){
				if ($errorPassword.text() != "密码合法"){
					password.value = "";
				}
				$errorPassword.html("<br>");
			});

			//确认密码验证
			var $password2Test = $("#password2");
			var $errorPassword2 = $("#errorPassword2");
			$password2Test.blur(function (){
				var password2 = $password2Test.val();
				if (password2 === $passwordText.val()&&password2 != ""){
					$errorPassword2.removeClass("illegal")
					$errorPassword2.addClass("legal");
					$errorPassword2.text("确认密码正确");
				}else if (password2 != $passwordText.val()){
					$errorPassword2.addClass("illegal");
					$errorPassword2.text("确认密码与密码不一致");
				}
			});
			$password2Test.focus(function (){
				if ($errorPassword2.text() != "确认密码正确"){
					password2.value = "";
				}
				$password2Test.html("<br>");
			});

			//邮箱验证
			var $emailText = $("#email");
			var $errorEmail = $("#errorEmail");
			$emailText.blur(function (){
				var email = $emailText.val();
				var emailRegExp = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				var ok = emailRegExp.test(email);
				if(!ok){
					$errorEmail.addClass("illegal");
					$errorEmail.text("邮箱不合法");
				}else {
					$errorEmail.removeClass("illegal")
					$errorEmail.addClass("legal");
					$errorEmail.text("验证成功");
				}
			});

			$emailText.focus(function (){
				if($errorEmail.text() != "验证成功"){
					email.value = "";
				}
				$errorEmail.html("<br>");
			});

			// 给验证码绑定单击事件，切换验证码
			$("#code_img").click(function (){
				this.src = "${basePath}kaptcha.jpg?id=" + new Date();


			})

			$("#sub_btn").click(function (){
				$usernameText[0].focus();
				$usernameText[0].blur();
				$passwordText[0].focus();
				$passwordText[0].blur();
				$password2Test[0].focus();
				$password2Test[0].blur();
				$emailText[0].focus();
				$emailText[0].blur();

				if ($errorEmail.text() == "验证成功" &&
					$errorPassword2.text() == "确认密码正确" &&
					$errorPassword.text() == "密码合法" &&
					$errorUsername.text() == "用户名合法" ||
                    $errorUsername.text() =="用户名可用"){
					var userForm = $("userForm");
					userForm.submit();
				}
			})
		})
	</script>
</head>

<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("errorMsg")==null?"":request.getAttribute("errorMsg")%>--%>
<%--									${requestScope.errorMsg}--%>
								</span>
							</div>
							<div class="form">

								<form id="userForm" action="userServlet" method="post">
									<input type="hidden" name="action" value="register">
									<table align="center" id="registerTable" border="0px">
										<tr>
											<td align="right">
												<label>用户名称：</label>
											</td>
											<td>
												<input class="itxt" type="text" placeholder="请输入用户名"
													   autocomplete="off" tabindex="1" name="username" id="username"
														value="${requestScope.username}"/>
											</td>
										</tr>
										<!--用户名报错-->
										<tr>
											<td colspan="2" align="center">
												<span id="errorUsername" class="illegal">
													${requestScope.errorUsername}<br>
												</span>
											</td>
										</tr>

										<tr>
											<td align="right">
												<label>用户密码：</label>
											</td>
											<td>
												<input class="itxt" type="password" placeholder="请输入密码"
													   autocomplete="off" tabindex="1" name="password" id="password" />
											</td>
										</tr>

										<tr>
											<td colspan="2" align="center">
												<span id="errorPassword" ><br></span>
											</td>
										</tr>

										<tr>
											<td align="right">
												<label>确认密码：</label>
											</td>
											<td>
												<input class="itxt" type="password" placeholder="确认密码"
													   autocomplete="off" tabindex="1" name="password2" id="password2" />
											</td>
										</tr>

										<tr>
											<td colspan="2" align="center">
												<span id="errorPassword2" ><br></span>
											</td>
										</tr>


										<tr>
											<td align="right">
												<label>电子邮件：</label>
											</td>
											<td>
												<input class="itxt" type="text" placeholder="请输入邮箱地址"
													   autocomplete="off" tabindex="1" name="email" id="email"
													   value="${requestScope.email}"/>
											</td>
										</tr>

										<tr>
											<td colspan="2" align="center">
												<span id="errorEmail" ><br></span>
											</td>
										</tr>


										<tr>
											<td align="right">
												<label>验证码：</label>
											</td>
											<td>
												<input placeholder="请输入验证码"
													   autocomplete="off" tabindex="1" class="itxt" type="text" name="code" style="width: 100px;" id="code"/>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<img id="code_img" alt="" src="kaptcha.jpg" style="cursor: pointer;float: right; margin-right: 40px;width: 95px;height: 40px;">
											</td>
										</tr>

										<tr>
											<td colspan="2" align="center">
												<span id="errorCode" style="color: red; font-size: 15px">
													${requestScope.errorCode}<br>
												</span>
											</td>
										</tr>

										<tr align="bottom" id="buttonForm">
											<td colspan="2">
												<input type="submit" value="注册" id="sub_btn">
											</td>
										</tr>


									</table>


								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
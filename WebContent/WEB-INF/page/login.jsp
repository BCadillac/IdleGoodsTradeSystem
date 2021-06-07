<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<link rel="stylesheet" href="css/simpleForm.css">
	<script>
		function validateForm() {
			var x = document.forms["loginForm"]["id"].value;
			if (x == null || x == "") {
				alert("用户名必须填写");
				return false;
			}
		}
	</script>
</head>

<body>
	<br>
	<br>
	<br>
	<img id="logo" alt="logo" src="SystemImage/logo.jpg" >

	<h1>账户登录</h1>

	<form name="loginForm" class="formDiv" action="login" onsubmit="return validateForm()" method="post" >
		<div class="loginInputDiv">
			<div><img src="SystemImage/accountIcon.jpg" alt="accountIcon" ></div>
			<input type="text" name="id" placeholder="用户ID">
		</div>
		<div class="loginInputDiv">
			<div><img src="SystemImage/passwordIcon.jpg" alt="passwordIcon"></div>
			<input type="password" name="password"  placeholder="密码">
		</div>
		
		<input type="submit" value="登录">
		<p id="failMessage" style='color:red'>${failMessage }</p>
	</form>

	<a href="./register">没有账号？点此注册</a>


</body>

</html>
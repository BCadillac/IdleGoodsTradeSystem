<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册页面</title>
	<link rel="stylesheet" href="css/simpleForm.css">
	<script>
		function validateForm() {
			var idValue = document.forms["registerForm"]["id"].value;
			var pw1 = document.forms["registerForm"]["password"].value;
			var contactValue = document.forms["registerForm"]["contactInfo"].value;

			if (idValue == null || idValue == "") {
				alert("用户ID必须填写！");
				return false;
			}
			if (pw1 == null || pw1 == "") {
				alert("密码必须填写！");
				return false;
			}
			if (contactValue == null || contactValue == "") {
				alert("联系方式必须填写！");
				return false;
			}

			var pw2 = document.forms["registerForm"]["confirmPw"].value;
			if (pw1 != pw2) {
				alert("两次密码不一致！");
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

	<h1>用户注册</h1>

	<form name="registerForm" action="register" onsubmit="return validateForm()" method="post">
		<div class="loginInputDiv">
			<div><img src="SystemImage/accountIcon.jpg" alt="accountIcon"></div>
			<input type="text" name="id" placeholder="用户ID" ><br /> <!-- name值漏写会导致注入Account失败，处理函数接受不到Account -->
		</div>
		<div class="loginInputDiv">
			<div><img src="SystemImage/passwordIcon.jpg" alt="passwordIcon"></div>
			<input type="password" name="password" placeholder="密码" ><br />
		</div>
		<div class="loginInputDiv">
			<div><img src="SystemImage/passwordIcon.jpg" alt="passwordIcon"></div>
			<input type="password" name="confirmPw" placeholder="确认密码"><br />
		</div>
		<div class="loginInputDiv">
			<div><img src="SystemImage/contactIcon.jpg" alt="contactIcon"></div>
			<input type="text" name="contactInfo" placeholder="联系方式"><br />
		</div>

		<input type="submit" value="注册">
		<p style='color:green'>${successMessage }</p>
		<p style='color:red'>${failMessage }</p>
	</form>
	<a href="./login">登录</a>

</body>

</html>
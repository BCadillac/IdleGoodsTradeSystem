<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script>
	function validateForm(){
	var x=document.forms["loginForm"]["id"].value;
	if (x==null || x==""){
	  alert("用户必须填写");
	  return false;
	  }
	}
</script>
</head>
<body>

<h1>登录界面</h1>
<form name="loginForm" action="login" onsubmit="return validateForm()" method="post">
	用户ID:<input type="text" name="id" ><br />
	登录密码:<input type="password" name="password"><br />
	<input type="submit" value="登录">
	<p id="failMessage" style='color:red'>${failMessage }</p>
</form>
<a href="./register">注册</a>


</body>
</html>
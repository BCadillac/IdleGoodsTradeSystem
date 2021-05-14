<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<h1>注册页面</h1>

<form action="register" method="post">
	用户ID:<input type="text" name="id"><br/> <!-- name值漏写会导致注入Account失败，处理函数接受不到Account -->
	登录密码:<input type="text" name="password"><br/>
	//确认密码<br/>
	联系方式:<input type="text" name="contactInfo"><br/>
	<input type="submit" value="注册">
</form>
<a href="./login">登录</a>

</body>
</html>
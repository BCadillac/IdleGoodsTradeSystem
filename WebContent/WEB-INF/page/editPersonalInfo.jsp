<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑个人信息</title>
</head>
<body>
<form action="editPersonalInfo" method="post">
用户id:<input type="text" name="id" value=${id }><br />
联系方式:<input type="text" name="contactInfo" value=${contactInfo }><br/>
<input type="submit" value="提交">
</form>
<a href="./editPassword">修改密码</a>


</body>
</html>
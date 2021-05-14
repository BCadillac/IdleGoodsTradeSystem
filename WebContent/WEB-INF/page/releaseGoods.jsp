<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑商品信息</title>
</head>
<body>
<h1>发布商品</h1>
<form action="releaseGoods" method="post" enctype="multipart/form-data">	
	商品名称：<input type="text" name="name"><br/><br/>
	商品描述：<input type="text" name="description" style="height:51px;width:449px;font-size:16px"><br/><br/>
	商品图片(JPG)：<input type="file" name="image" accept="image/*"><br/><br/>
	<input type="submit" value="上传">
</form>

</body>
</html>
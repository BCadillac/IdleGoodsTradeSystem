<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"
	isELIgnored="false" %>
<!DOCTYPE HTML>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>编辑商品信息</title>
	<style>
		.introInfo{
			font-weight:bold;
    		color:#366F9C;
		}
		/* #releaseGoodsForm,#h1Line{
			margin-left: 35%;
		} */
		
	</style>

</head>

<body>
	<%@include file="top.jsp" %>
	<h1 id="h1Line">发布商品</h1>
	<form action="releaseGoods" method="post" enctype="multipart/form-data" id="releaseGoodsForm">
		<div id="goodsName"><span class="introInfo">商品名称：</span><input type="text" name="name"></div><br />
		<div id="goodsDescription"><span class="introInfo">商品描述：</span><input type="text" name="description" style="height:51px;width:449px;font-size:16px"></div><br />
		<div id="goodsImg"><span class="introInfo">商品图片(JPG)：</span><input type="file" name="image" accept="image/*"></div><br />
		<div id="submitButton"><input type="submit" value="上传"></div>
		<p style='color:green'>${successMessage }</p>
		<p style='color:red'>${failMessage }</p>

	</form>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑商品</title>
</head>
<body>
<form action="editGoodsInfo" method="post" enctype="multipart/form-data">	
	<input type="hidden" name="goodsId" value=${goodsId }>	<!-- 隐藏goodsId,使其随其他参数注入对象 -->
	商品名称：<input type="text" name="name" value=${name }><br/><br/>
	商品描述：<input type="text" name="description" style="height:51px;width:449px;font-size:16px" value=${description } ><br/><br/>
	<!-- 商品图片(JPG)：<input type="file" name="image" accept="image/*"><br/><br/> -->
	<input type="submit" value="上传">
</form>

</body>
</html>
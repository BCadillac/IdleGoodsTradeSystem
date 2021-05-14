<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pojo.Goods"%>  
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>
<h1>商品详情</h1>
<%
	Goods g=(Goods)request.getAttribute("goods");
%>
<img src="GoodsImg/<%=g.getPictureId()%>"  /><br />
出售者:<%=g.getSellerId() %><br />
商品名称:<%=g.getName()%><br />
商品描述:<%=g.getDescription() %><br />
<a href="./purchase?goodsId=<%=g.getGoodsId() %>">购买</a>
</body>
</html>
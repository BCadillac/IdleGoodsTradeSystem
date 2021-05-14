<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" 
		 import="pojo.Goods"
 %>    

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

<h1>Home</h1>
<div>
<a href="./personalCenter">个人中心</a>
<a href="./releaseGoods">发布商品</a>
</div>
<div>
<h2>在售商品</h2>
<%
	@SuppressWarnings("unchecked")
	List<Goods> listOfSellingGoods =(List<Goods>)request.getAttribute("listOfSellingGoods");
	for(Goods g:listOfSellingGoods){
%>
		<img src="GoodsImg/<%=g.getPictureId()%>" width="160" height="90" />
		<%=g.getName()%>
		<a href="./goodsInfo?goodsId=<%=g.getGoodsId() %>">详情</a> 
		<br/>
<%	}%>

</div>
</body>
</html>
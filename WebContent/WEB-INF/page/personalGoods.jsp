<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" 
		 import="pojo.Goods"
 %>  
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我发布的商品</title>
</head>
<body>
<h1>我发布的商品</h1>
<%
	@SuppressWarnings("unchecked")
	List<Goods> listOfPersonalGoods =(List<Goods>)request.getAttribute("listOfPersonalGoods");
	for(Goods g:listOfPersonalGoods){
%>
		<img src="GoodsImg/<%=g.getPictureId()%>" width="160" height="90" />
		<%=g.getName()%>
		<%=g.getDescription()%>
		<%=g.getStatus() %>
		<% if(g.getStatus().equals("SELLING")){ %>
			<a href="./editGoodsInfo?goodsId=<%=g.getGoodsId()%>">修改</a>
			<a href="./deleteGoods?goodsId=<%=g.getGoodsId()%>">删除</a>
		<% } %>
		
		<br/>
<%	}%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" 
		 import="DAO.AccountInfoDocDAO"
		 import="DAO.GoodsInfoDocDAO"
		 import="pojo.Transaction"
 %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我卖出的商品</title>
</head>
<body>
<h1>我卖出的商品</h1>
<p>图片     购买者    购买者联系方式</p>
<%
	@SuppressWarnings("unchecked")
	List<Transaction> listOfTransactions =(List<Transaction>)request.getAttribute("listOfTransactions");
	GoodsInfoDocDAO gidDao=new GoodsInfoDocDAO();
	AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
	for(Transaction s:listOfTransactions){
%>
		<img src="GoodsImg/<%=gidDao.getGoods(s.getGoodsId()).getPictureId()%>" width="160" height="90" />
		<%=s.getBuyerId() %>
		<%=aidDAO.getAccount(s.getBuyerId()).getContactInfo() %>
		<br />
<%	}%>
</body>
</html>
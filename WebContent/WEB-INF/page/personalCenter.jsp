<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
</head>
<body>

<h1>个人中心</h1>
<div>
个人信息：<br/>
用户ID:${id}<br/>
用户联系方式:${contactInfo}<br/>
</div>
<a href="./editPersonalInfo">编辑个人信息</a><br />
<a href="./personalGoods">查看我发布的商品</a><br />
<a href="./myBought">我购买的商品</a>
<a href="./mySold">我卖出的商品</a>

</body>
</html>
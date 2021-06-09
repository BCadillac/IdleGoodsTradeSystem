<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="pojo.Goods" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品详情</title>
    <link rel="stylesheet" href="css/goodsInfo.css">
    <script>
        function ifPurchase(){
            return confirm("是否确认购买？")
        }
    </script>

</head>

<body>
    <%@include file="top.jsp" %>
    <% Goods g=(Goods)request.getAttribute("goods"); %>
    
    <div class="contentDiv">
        <h1 id="goodsIntro">商品详情</h1>
        <table>
            <tbody>
                <tr>
                    <td class="leftTd">
                        <img src="GoodsImg/<%=g.getPictureId()%>" class="imgDiv" /><br />
                    </td>
                    <td class="rightTd">
                        <p><span class="introInfo" >商品名称: </span><%=g.getName()%></p>
                        <p><span class="introInfo" >商品描述: </span><%=g.getDescription() %></p>
                        <a href="./purchase?goodsId=<%=g.getGoodsId() %>" class="purchaseButton" onclick="return ifPurchase()">购买</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>
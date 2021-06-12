<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="css/personalInfo.css">

</head>

<body>
    <%@include file="top.jsp" %>
    <h1>个人中心</h1>
    <table width="100%" class="showTable">
        <tbody>
            <tr width="145px" style="padding-left:20px;">
                <td id="leftModuleTd">
                    <nav>
                        <div style="width:180px;">
                            <span class="leftModule selectedLeftModule">个人信息</span>
                            <a href="./personalGoods" class="leftModule">查看我发布的商品</a>
                            <a href="./myBought" class="leftModule">我购买的商品</a>
                            <a href="./mySold" class="leftModule">我卖出的商品</a>
                        </div>
                    </nav>
                </td>
                <td id="rightModuleTd">
                    <div class="rightModule" >
                        <p><span class="introInfo" >用户ID: </span>${id}</p>
                        <p><span class="introInfo" >用户联系方式: </span>${contactInfo}</p>
                        <button onclick="javascript:window.location.href='./editPersonalInfo' ">编辑个人信息</button>
                        <button onclick="javascript:window.location.href='./editPassword' ">修改密码</button>
                    </div>

                </td>

            </tr>
        </tbody>
    </table>


</body>

</html>

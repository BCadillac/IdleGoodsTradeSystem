<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑个人信息</title>
    <link rel="stylesheet" href="css/personalCenter.css">

</head>

<body>
    <%@include file="top.jsp" %>
    <h1>个人中心</h1>
    <table width="100%" class="showTable">
        <tbody>
            <tr width="145px" style="padding-left:20px;">
                <td>
                    <nav>
                        <div style="width:180px;">
                            <span class="leftModule selectedLeftModule">个人信息</span>
                            <a href="./personalGoods" class="leftModule"><span>查看我发布的商品</span></a>
                            <a href="./myBought" class="leftModule"><span>我购买的商品</span></a>
                            <a href="./mySold" class="leftModule"><span>我卖出的商品</span></a>
                        </div>
                    </nav>
                </td>
                <td>
                    <div class="rightModule">
                        <form action="editPersonalInfo" method="post">
                            <p><span class="introInfo" >用户id:</span><input type="text" name="id" value=${id }></p>
                            <p><span class="introInfo" >联系方式:</span><input type="text" name="contactInfo" value=${contactInfo }></p>
                            <input type="submit" value="提交">
                            <button type="button" onclick="javascript:window.location.href='./personalCenter' " >取消</button><!--设置type为button才能使表单内button不提交-->
                        </form>
                        <p style='color:green'>${successMessage }</p>
		                <p style='color:red'>${failMessage }</p>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>


</body>

</html>
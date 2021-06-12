<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="css/personalInfo.css">
    <script>
        function validateForm() {
			var pw1 = document.forms["editPwForm"]["newPw"].value;
			var pw2 = document.forms["editPwForm"]["newPw1"].value;
			if (pw1 != pw2) {
				alert("两次密码不一致！");
				return false;
			}
		}
    </script>
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
                        <form name="editPwForm" action="editPassword" method="post" onsubmit="return validateForm()" >
                            <p><span class="introInfo" >请输入原密码:</span><input type="password" name="originalPw"></p>
                            <p><span class="introInfo" >请输入新密码:</span><input type="password" name="newPw"></p>
                            <p><span class="introInfo" >再输入新密码:</span><input type="password" name="newPw1"></p>
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
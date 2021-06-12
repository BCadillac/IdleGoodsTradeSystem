<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>编辑商品</title>
		<link rel="stylesheet" href="css/personalInfo.css">
		<style>
			.goodsImg{
				width: 320px;
				height: 180px;
			}
			#goodsImgIntro, #changeImgButton{
				vertical-align: middle;
			}
			#rightModule{
				width: 85%;
			}
			

		</style>
	</head>
	<body>
		<%@include file="top.jsp" %>
		<h1>个人中心</h1>
		<table width="100%">
			<tbody>
				<tr>
					<td id="leftModuleTd">
						<nav>
							<div style="width:180px;">
								<a href="./personalCenter" class="leftModule"><span>个人信息</span></a>
								<span class="leftModule selectedLeftModule">查看我发布的商品</span>
								<a href="./myBought" class="leftModule"><span>我购买的商品</span></a>
								<a href="./mySold" class="leftModule"><span>我卖出的商品</span></a>
							</div>
						</nav>
					</td>
					<td id="rightModule">
						<form action="editGoodsInfo" method="post">
							<input type="hidden" name="goodsId" value=${goodsId }> <!-- 隐藏goodsId,使其随其他参数注入对象 -->
							<table>
								<tr>
									<td class="introInfo" id="goodsImgIntro" >商品图片：</td>
									<td><img class="goodsImg" src=${goodsImg} alt="goods picture"></td>
									<td id="changeImgButton"><a>更改图片</a></td>
								</tr>
							</table>
							<p><span class="introInfo" >商品名称：</span><input type="text" name="name" value=${name }></p>
							<br />
							<p><span class="introInfo" >商品描述：</span><input type="text" name="description" style="height:51px;width:449px;font-size:16px"
								value=${description }></p>
							<br />
							<!-- 商品图片(JPG)：<input type="file" name="image" accept="image/*"><br/><br/> -->
							<input type="submit" value="修改">
							<button type="button" onclick="javascript:window.location.href='./personalGoods' " >取消</button><!--设置type为button才能使表单内button不提交-->
							<p style='color:green'>${successMessage }</p>
							<p style='color:red'>${failMessage }</p>
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>
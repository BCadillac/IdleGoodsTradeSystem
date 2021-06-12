<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我发布的商品</title>
	<link rel="stylesheet" href="css/personalInfo.css">
	<link rel="stylesheet" href="css/personalGoods.css">
	<script src="js/vue.min.js"></script>
	<script src="js/axios.min.js"></script>

	<script>
		var listOfPersonalGoods;
		axios.post("./personalGoods").then(function (response) {
			listOfPersonalGoods = response.data.listOfPersonalGoods;
			for (i in listOfPersonalGoods) {
				listOfPersonalGoods[i].pictureId = "GoodsImg/" + listOfPersonalGoods[i].pictureId;
				if (listOfPersonalGoods[i].status == "SELLING") {
					//添加编辑功能跳转的url
					listOfPersonalGoods[i].editLink = "./editGoodsInfo?goodsId=" + listOfPersonalGoods[i].goodsId;
					//添加删除功能跳转的url
					listOfPersonalGoods[i].deleteLink = "./deleteGoods?goodsId=" + listOfPersonalGoods[i].goodsId;
				} else {
					listOfPersonalGoods[i].editLink = "";
					listOfPersonalGoods[i].deleteLink = "";
				}
			}
			addTable(listOfPersonalGoods);
		})
		function addTable(listOfPersonalGoods) {
			let tbody = document.getElementById("tableBody");
			for (i in listOfPersonalGoods) {
				//new tr
				let tr = tbody.insertRow();

				//get img str and put in
				let imgTd = document.createElement("td");
				imgTd.classList.add("imgTd");
				imgTd.innerHTML = getImgTdHTML(listOfPersonalGoods[i].pictureId, listOfPersonalGoods[i].name);
				tr.appendChild(imgTd);

				//get name str and put in
				let nameTd = document.createElement("td");
				nameTd.classList.add("nameTd");
				nameTd.innerHTML = listOfPersonalGoods[i].name;
				tr.appendChild(nameTd);

				//get des str and put in
				let descriptionTd = document.createElement("td");
				descriptionTd.classList.add("descriptionTd");
				descriptionTd.innerHTML = listOfPersonalGoods[i].description;
				tr.appendChild(descriptionTd);

				//get option str and put in
				let optionTd = document.createElement("td");
				optionTd.classList.add("optionTd");
				optionTd.innerHTML=getOptionTdHTML(listOfPersonalGoods[i].status,listOfPersonalGoods[i].editLink,listOfPersonalGoods[i].deleteLink);
				tr.appendChild(optionTd);
			}

		}
		function getImgTdHTML(pictureId, name) {
			return "<img src=" + pictureId + " alt=" + name + " class='goodsImg'>";
		}
		function getOptionTdHTML(status,editLink,deleteLink){
			return "<a class='editLink "+status+"' href="+editLink+">编辑</a>"
					+"<br>"
					+"<a class='deleteLink "+status+"' href="+deleteLink+">删除</a>";
		}
	</script>
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
					<table class="rightModuleTable">
						<thead>
							<tr>
								<th>商品图片</td>
								<th>商品名称</td>
								<th>商品详情</td>
								<th>操作</td>
							</tr>
						</thead>
						<tbody id="tableBody">
		
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
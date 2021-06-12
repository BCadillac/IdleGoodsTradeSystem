<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我够买的商品</title>
	<link rel="stylesheet" href="css/personalInfo.css">
	<link rel="stylesheet" href="css/personalGoods.css">
	<script src="js/vue.min.js"></script>
	<script src="js/axios.min.js"></script>

	<script>
		var listOfTransactions;
		var listOfContact;
		var listOfGoodsImg;
		axios.post("./myBought").then(function(response){
			listOfTransactions=response.data.listOfTransactions;
			listOfContact=response.data.listOfContact;
			listOfGoodsImg=response.data.listOfGoodsImg;
			
			for(i in listOfGoodsImg){
				listOfGoodsImg[i]="GoodsImg/"+listOfGoodsImg[i];
			}
			let tbody = document.getElementById("tableBody");
			for(i in listOfTransactions){
				//new tr
				let tr=tbody.insertRow();

				//get img str and put in
				let imgTd=document.createElement("td");
				imgTd.classList.add("imgTd");
				imgTd.innerHTML=getImgTdHTML(listOfTransactions[i].goodsId);
				tr.appendChild(imgTd);

				//get sellerId str and put in
				let sellerIdTd=document.createElement("td");
				sellerIdTd.classList.add("sellerIdTd");
				sellerIdTd.innerHTML=listOfTransactions[i].sellerId;
				tr.appendChild(sellerIdTd);

				//get contact str and put in
				let sellerContactTd=document.createElement("td");
				sellerContactTd.classList.add("sellerContactTd");
				let sellerContact=listOfContact[listOfTransactions[i].sellerId];
				sellerContactTd.innerHTML=sellerContact;
				tr.appendChild(sellerContactTd);
			}
		})
		function getImgTdHTML(goodsId){
			return "<img src="+listOfGoodsImg[goodsId]+" class='goodsImg'>";
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
							<a href="./personalGoods" class="leftModule"><span>查看我发布的商品</span></a>
							<span class="leftModule selectedLeftModule">我购买的商品</span>
							<a href="./mySold" class="leftModule"><span>我卖出的商品</span></a>
						</div>
					</nav>
				</td>
				<td id="rightModule">
					<table class="rightModuleTable">
						<thead>
							<tr>
								<th>商品图片</td>
								<th>出售者</td>
								<th>出售者联系方式</th>
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
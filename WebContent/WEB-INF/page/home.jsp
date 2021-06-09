<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<script src="js/vue.min.js"></script>
	<script src="js/axios.min.js"></script>
	<link rel="stylesheet" href="css/goods.css">

</head>

<body>
	<%@include file="top.jsp" %>
	<div id="templateDivHTML" style="display:none">
		<div class="goods" v-on:click="goToGoodsInfo">
			<div class="imgDiv">
				<img v-bind:src="product.pictureId" alt="img" width="160" height="90"> 
			</div>
			<div class="goodsNameIntro">
				商品名称
			</div>
			<div class="goodsName">
				{{product.name}}
			</div>
		</div>
	</div>	
	
	<div id="sellingGoodsListDiv">
		<goods v-for="item in listOfSellingGoods" v-bind:product="item"></goods>
	</div>
	
	<script>
		var tempalateDiv=document.getElementById("templateDivHTML").innerHTML;
		Vue.component('goods', {
			props: ['product'],
			template: tempalateDiv,
			methods:{
				goToGoodsInfo:function(){
					window.open("./goodsInfo?goodsId="+this.product.goodsId);
				}
			}
		})

		var url="./home";
		new Vue({
			el: '#sellingGoodsListDiv',
			data:{
				listOfSellingGoods:[]
			},
			mounted:function(){
				var self=this;
				axios.post(url).then(function(response){
					self.listOfSellingGoods=response.data.listOfSellingGoods;//注意这里必须取出listOfSellingGoods
					for(i in self.listOfSellingGoods){
						self.listOfSellingGoods[i].pictureId="GoodsImg/"+self.listOfSellingGoods[i].pictureId;
					}
				})
			}
		})
	</script>
</body>
</html>
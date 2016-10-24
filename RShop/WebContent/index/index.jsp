<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/RShop/index/index.css" /> 
<link type="text/css" rel="stylesheet" href="/RShop/common/header.css" />
<title>无标题文档</title>
<style type="text/css">
<!--
 

/* ~~ 此固定宽度容器包含其它 div ~~ */


/* ~~ 标题未指定宽度。它将扩展到布局的完整宽度。标题包含一个图像占位符，该占位符应替换为您自己的链接徽标 ~~ */


/* ~~ 这是布局信息。 ~~ 

1) 填充只会放置于 div 的顶部和/或底部。此 div 中的元素侧边会有填充。这样，您可以避免使用任何“方框模型数学”。请注意，如果向 div 自身添加任何侧边填充或边框，这些侧边填充或边框将与您定义的宽度相加，得出 *总计* 宽度。您也可以选择删除 div 中的元素的填充，并在该元素中另外放置一个没有任何宽度但具有设计所需填充的 div。

*/

.content {

	padding: 0px 0;
}

/* ~~ 脚注 ~~ */
.footer {
	padding: 10px 0;
	background-color: #CCC49F;
}


-->
  .category{
	  list-style:none;
	  padding-top:10px;
	  
  }
  .category li{
  	  font-size:16px;
	  height:30px;
	  border-bottom-style:solid;
	  border-bottom-width:thin;  
  }
</style>
<script type="text/javascript">
setInterval(changeImageAdvItem, 2000);
function changeImageAdvItem(){
	var left = parseInt($("#index_image_adv_container").css("left"));
	var newleft = (left-750)%<s:property value='index_image_adv.items.size()*750' /> ;
	$("#index_image_adv_container").animate({left:newleft+"px"});
	
}

function showComputerRecommendAdv(){
	hideRecommendAdv();
	$("#computer_recommend_adv").show();
	$("#computer_recommend_adv").css("display","block");
}
function showBookRecommendAdv(){
	hideRecommendAdv();
	$("#book_recommend_adv").show();
	$("#book_recommend_adv").css("display","block");
}
function showGameRecommendAdv(){
	hideRecommendAdv();
	$("#game_recommend_adv").show();
	$("#game_recommend_adv").css("display","block");
}
function showPhoneRecommendAdv(){
	hideRecommendAdv();
	$("#phone_recommend_adv").show();
	$("#phone_recommend_adv").css("display","block");
}
function hideRecommendAdv(){
	$("#game_recommend_adv").hide();
	$("#book_recommend_adv").hide();
	$("#phone_recommend_adv").hide();
	$("#computer_recommend_adv").hide();
}
</script>

</head>

<body>


<div class="container">

	<%@include file="/common/header.jsp" %>
   <div class="content">
   <div style="height:430px;font-size: 0">
   
     <div style="width:250px;height:430px;position: relative;display:inline-block;vertical-align: top">
     
	    <ul class="category" onmouseout="hideRecommendAdv()">
	    <li onmouseover="showBookRecommendAdv()">图书
		    <div id="book_recommend_adv" style="float:right;height:430px;width:750px;position: absolute;top:0px;left:250px;display:none;background-color: green;z-index: 1;">
		    	<div style="margin:20px;display:inline-block;">bbbbbbbb</div>
		    	<div style="margin:20px;display:inline-block;">bbbbbbbb</div>
		    	<div style="margin:20px;display:inline-block;">bbbbbbbb</div>
		    	<div style="margin:20px;display:inline-block;">bbbbbbbb</div>
		    	<!-- <img src="image1.jpg" width="750" height="430" /> -->
		    </div>
	    </li>
	    <li onmouseover="showGameRecommendAdv()">游戏
	    	<div id="game_recommend_adv" style="float:right;height:430px;width:750px;position: absolute;top:0px;left:250px;display:none;background-color: green;z-index: 1">
		    	<s:iterator value="recommend_game_adv.items" var="recommend_game_adv_item">
		    		<div style="margin:20px;display:inline-block;"><a href="/RShop/ProductView?product_code=<s:property value='#recommend_game_adv_item.product.code' />"><s:property value="#recommend_game_adv_item.product.name" /></a></div>
		    	</s:iterator>
		    </div>
	   	</li>
	    <li onmouseover="showPhoneRecommendAdv()">手机
	    	<div id="phone_recommend_adv" style="float:right;height:430px;width:750px;position: absolute;top:0px;left:250px;display:none;background-color: green;z-index: 1">
		    	<s:iterator value="recommend_phone_adv.items" var="recommend_phone_adv_item">
		    		<div style="margin:20px;display:inline-block;"><a href="/RShop/ProductView?product_code=<s:property value='#recommend_phone_adv_item.product.code' />"><s:property value="#recommend_phone_adv_item.product.name" /></a></div>
		    	</s:iterator>
		    </div>
	    </li>
	    <li onmouseover="showComputerRecommendAdv()">电脑
	    	<div id="computer_recommend_adv" style="float:right;height:430px;width:750px;position: absolute;top:0px;left:250px;display:none;background-color: green;z-index: 1">
		    	<s:iterator value="recommend_computer_adv.items" var="recommend_computer_adv_item">
		    		<div style="margin:20px;display:inline-block;"><a href="/RShop/ProductView?product_code=<s:property value='#recommend_computer_adv_item.product.code' />"><s:property value="#recommend_computer_adv_item.product.name" /></a></div>
		    	</s:iterator>
		    </div>
	    </li>
	    <li>平板</li>
	    <li>玩具</li>
	    </ul>    
    </div>
   
   
    <div style="width:750px;overflow: hidden;display:inline-block">
    	
		<div id="index_image_adv_container" style="left:0px;position: relative;width:<s:property value='index_image_adv.items.size()*750' />px">
			<s:iterator value="index_image_adv.items" var="index_image_adv_item">
				<a href="/RShop/ProductView?product_code=<s:property value='#index_image_adv_item.product.code' />"><img src="/image/advertisement_image/<s:property value="index_image_adv.code" />/<s:property value="#index_image_adv_item.image" />" style="width:750px;height:430px;float:left;" /></a>
			</s:iterator>
		</div>
    	 
    </div>
   
  		
    </div>
	<div style="width:100%; background-color:#818181;font-size: 0;">
	      <s:iterator value="all_product" var="product">
		       <div style="height:300px;display:inline-block; width:260px; background-color:#C0C0C0; margin-left:6px;margin-right:6px; margin-top:10px;vertical-align: top">
			      <div style="background-color:#6C6C6C; width:100%;">
			      	<img src="/image/product_image/<s:property value='#product.code' />/<s:property value="#product.images.split(\";\")[0]" />"  width="260" height="260" />
			      </div>
			      <div style="text-align:center;font-size: 16px;">
			      
			      	<a href="/RShop/ProductView?product_code=<s:property value='#product.code' />">
		      				<s:property value='#product.name' />/<s:property value='#product.price' />
		      		</a>
		      	  </div>
		      </div>
	      	
	      </s:iterator>
    </div>
    <!-- end .content --></div>
  <div class="footer"></div>
</div>
</body>
</html>
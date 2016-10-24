<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="product.name" /></title>
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link rel="stylesheet" href="/RShop/common/header.css"/>
<link rel="stylesheet" href="/RShop/product/product_info.css"/>
<script type="text/javascript" src="/RShop/common/usercenter.js"></script>
<script type="text/javascript">
	setInterval(changeProductImage, 2000);
	function changeProductImage(){
		var left = parseInt($("#product_image_container").css("left"));
		var newleft = (left-350)%<s:property value='product_images.length*350' /> ;
		$("#product_image_container").animate({left:newleft+"px"});
	}
</script>
</head>
<body>
<div class="container">

<%@include file="/common/header.jsp" %>
<table>
	<tr>
		<td width="350px">
			<div style="width:350px;height:350px;overflow: hidden">
				
				<div id="product_image_container" style="width:<s:property value='product_images.length*350' />px;height:300px;position: relative;left:0px">
				
					<s:iterator value="product_images" var="product_image">
						<img src="/image/product_image/<s:property value='product.code' />/<s:property value='product_image' />" style="width:350px;height:350px;float:left">
					</s:iterator>
				</div>
				
			</div>
			</td>
		<td width="1010px">
			<div style="width:950px;height:350px;margin-left: 20px;">
				<div>全部商品<s:iterator value="typelist" var="type">><s:property value="type" /></s:iterator>
				</div>
				<div style="font-size: 24px"><s:property value="product.name" /></div>
				<div style="font-size:18px"><s:property value="product.describe" /></div>
				<div>价格：￥<s:property value="product.price" /></div>
				<div><input type="button" value="加入购物车" onclick="tryAddProductToCart('<s:property value='product.code' />')" /> <input type="button" value="立即购买" /></div>
			</div>
		
		</td>
	</tr>
</table>
<script type="text/javascript">
function showProductDetail(){
	document.getElementById("product_parameter").style.display = "none" ;
	document.getElementById("product_comment").style.display = "none" ;
	document.getElementById("product_detail").style.display="block" ;
}
function showProductParameter(){
	document.getElementById("product_comment").style.display = "none" ;
	document.getElementById("product_detail").style.display="none" ;
	document.getElementById("product_parameter").style.display = "block" ;
	
}
function showProductComment(){
	document.getElementById("product_parameter").style.display = "none" ;
	document.getElementById("product_detail").style.display="none" ;
	document.getElementById("product_comment").style.display = "block" ;
	
}
</script>
<table>
	<tr>
		<td width="350px" class="related_product_container">
			<div>相关产品</div>
		</td>
		<td width="1010px">
			<div style="width:1010px;height:40px">
				<div class="product_other_info_title" onclick="showProductDetail()">产品介绍</div>
				<div class="product_other_info_title" onclick="showProductParameter()">规格参数</div>
				<div class="product_other_info_title" onclick="showProductComment()">用户评论</div>
			</div>
			<div style="width:910px">
				<div id="product_detail" style="display:block;border-style: solid;border-width: thin">
					<s:iterator value="product_desc_images" var="product_desc_image">
					<img src="/image/product_image/<s:property value='product.code' />/desc/<s:property value='product_desc_image' />" width="910px">
					
					</s:iterator>
				</div>
				<div id="product_parameter" style="display:none;border-style: solid;border-width: thin">
					<table>
						<s:iterator value="product.parameters"  var="parameter">
							<tr>
								<td width="40%"><s:property value="key" /></td>
								<td width="60%"><s:property value="value" /></td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div id="product_comment" style="display:none;border-style: solid;border-width: thin">
					<ul style="list-style: none">
						<li>df***sdf:very good</li>
						<li>sdfsd**ss:terrible</li>
					</ul>
				</div>
			</div>
		</td>
	</tr>
</table>

</div>
</body>
</html>
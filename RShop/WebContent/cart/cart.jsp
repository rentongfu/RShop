<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link rel="stylesheet" href="/RShop/common/header.css"/>
<link rel="stylesheet" href="/RShop/product/product_info.css"/>
</head>

<body >
<div class="container">
<%@include file="/common/header.jsp" %>
<div style="">
	<div style="width:20%;display:inline-block;float:left;">s</div>
	<div style="width:80%;display:inline-block;">
		<div style="padding-left: 20px">购物车</div>
		<hr/>
		<div>
		<table style="text-align: center;"  cellspacing="0" border="1">
			<tr>
				<td width="40">编号</td>
				<td width="560">产品名</td>
				<td width="160">数量</td>
				<td width="160">价格</td>
				<td width="160">操作</td>
			</tr>
			<s:set var="total_price" value="0"  />
			
			<s:iterator value="cart.items" var="cart_item" status="status">
				<tr>
					<td><s:property value="#status.index" /> </td>
					<td><s:property value="#cart_item.product.name" /> </td>
					<td>
						<input type="button" value="-" onclick="tryDecreaseQuantityOfCartItem(<s:property value="#status.index" />)" />
						<s:property value="#cart_item.quantity" />
						<input type="button" value="+" onclick="tryIncreaseQuantityOfCartItem(<s:property value="#status.index" />)" /></td>
					<td><s:property value="#cart_item.product.price" /></td>
					<td><input type="button" value="删除" onclick="tryRemoveCartItem(<s:property value="#status.index" />)" /></td>
				</tr>
				<s:set var="total_price" value="#total_price+#cart_item.product.price*#cart_item.quantity"  />
			</s:iterator>
		</table>
		
		</div>
		<div>
		<div style="float:right;position:relative;right:50px">总价：￥<s:property value="#total_price" /> 
			<input style="height:30px;width:100px;" type="button" value="去结算" onclick="window.location.href='/RShop/OrderSubmitView'" />
			
		</div>
				
		</div>
		<div>
		</div>
		
		

	</div>
</div>
</div>
</body>

</html>
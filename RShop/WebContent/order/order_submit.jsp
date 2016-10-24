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
<div>
	<table border="1" cellspacing="0">
		<tr>
				<td width="40">编号</td>
				<td width="560">产品名</td>
				<td width="160">数量</td>
				<td width="160">价格</td>

		<s:set value="0" var="total_money"></s:set>
		
		<s:iterator value="cart.items" var="cart_item" status="status">
			
			<tr>
				<td><s:property value="#status.index"/> </td>
				<td><s:property value="#cart_item.product.name"/> </td>
				<td><s:property value="#cart_item.quantity"/> </td>
				<td><s:property value="#cart_item.product.price"/> </td>
			</tr>
			<s:set value="#total_money + #cart_item.quantity * #cart_item.product.price" var="total_money"></s:set>
		</s:iterator>
	</table>
	<div>总价： ￥<s:property value="#total_money"/></div>
	<div>收货地址
		<table>
			<s:iterator value="address_list" var="address" status="status">
				<tr>
					<td>
					<input type="radio" name="address_info" value='<s:property value="#status.index" />'/>
					</td>
					<td> <s:property value="#address.receiver_name"/> </td>
					<td><s:property value="#address.describe"/> </td>
				</tr>
			</s:iterator>
		
		</table>
	</div>
	<div><input type="button" onclick="trySubmitOrder()" value="提交订单" style="width:100px;height:30px" /></div>
</div>
</div>
</body>

</html>
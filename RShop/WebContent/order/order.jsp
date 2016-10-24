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
	
		<s:iterator value="order.orderitems" var="orderitem" status="status">
			<tr>
				<td><s:property value="#status.index"/> </td>
				<td><s:property value="#orderitem.product.name"/> </td>
				<td><s:property value="#orderitem.quantity"/> </td>
				<td><s:property value="#orderitem.product.price"/> </td>
			</tr>
		</s:iterator>
	</table>
	<div>状态：
		<s:if test="order.status==\"U\"">未支付</s:if>
		<s:if test="order.status==\"C\"">已取消</s:if>
	</div>
	<div>创建时间:<s:property value="order.create_time" /></div>
	<div>总价： ￥<s:property value="order.money"/></div>
	<div>收货地址:
		<table>
				<tr>
					<td> <s:property value="order.address.receiver_name"/> </td>
					<td><s:property value="order.address.describe"/> </td>
				</tr>
		</table>
	</div>
	<div>
		<s:if test="order.status==\"C\"">
		
		</s:if>
		<s:else>
			<input type="button"  value="取消订单" onclick="tryCancelOrder(<s:property value="order.id" />)" style="width:100px;height:30px" />
			<s:if test="order.status==\"U\""><input type="button"  value="支付订单" style="width:100px;height:30px" /></s:if>
		</s:else>
		
	
	</div>
</div>
</div>
</body>

</html>
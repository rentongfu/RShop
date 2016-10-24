<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table style="text-align: center;"  cellspacing="0" border="1"> 
	<tr>
		<td width="60">订单号</td>
		<td width="120">收货人姓名</td>
		<td width="120">总价格</td>
		<td width="120">状态</td>
		<td width="120">操作</td>
	</tr>
	<s:iterator value="order_list" var="order">
		<tr>
			<td><s:property value="#order.id" /></td>
			<td><s:property value="#order.address.receiver_name"/> </td>
			<td><s:property value="#order.money" /></td>
			<td>
				<s:if test="#order.status==\"U\"">未支付</s:if>
				<s:if test="#order.status==\"C\"">已取消</s:if>
			</td>
			<td><input type="button" onclick="jumpToOrderView(<s:property value='#order.id' />)" value="查看" /></td>
		</tr>
	</s:iterator>
	
</table>			
</div>
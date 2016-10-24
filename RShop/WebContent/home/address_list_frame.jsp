<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table style="text-align: center;"  cellspacing="0" border="1"> 
	<tr>
		<td>编号</td>
		<td>收货人姓名</td>
		<td>省市县</td>
		<td>收获地址</td>
		<td>操作</td>
	</tr>
	<s:iterator value="addressinfo_list" var="address_info" status="status">
		<tr>
			<td> <s:property value="#status.index" /> </td>
			<td> <s:property value="#address_info.receiver_name" /> </td>
			<td> <s:property value="#address_info.district.city.province.name"/>><s:property value="#address_info.district.city.name"/>><s:property value="#address_info.district.name"/> </td>
			<td><s:property value="#address_info.describe" /></td>
			<td>			
				<input type="button" value="删除" onclick="tryDeleteAddressInfo( <s:property value="#address_info.id" /> )" />
				<input type="button" value="查看" onclick="showAddressUpdateFrame(<s:property value="#address_info.id" />)" />
			</td>
		</tr>
	</s:iterator>
	
</table>
			<input type="button" value="添加" onclick="showAddressAddFrame()"/>
			
</div>
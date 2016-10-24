<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="manage_advertisement_frame">
<table border="1px">
	<tr>
		<td>id</td>
		<td>广告名</td>
		<td><input type="button" value="查看" /></td>
		
		
	</tr>
	
	<s:iterator var="advertisement" value="advertisement_list" status="status">
		<tr>
			<td><s:property value="#advertisement.id"/> </td>
			<td><s:property value="#advertisement.name"/></td>
			<td><input type="button" value="查看" /></td>
		</tr>
	</s:iterator>
</table>

</div>
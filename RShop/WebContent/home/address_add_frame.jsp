<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table style="text-align: center;"  cellspacing="0" border="1"> 
	<tr>
		<td>收货人姓名</td>
		<td><input type="text" id="receiver_name" /></td>
	</tr>
	<tr>
		<td>电话号码</td>
		<td><input type="text" id="phone_num"/></td>
	</tr>
	<tr>
		<td>省市县</td>
		<td>
			<select id="province_select" onchange="onProvinceSelectChange('province_select','city_select','district_select')">
				<option value="-1" selected="selected">请选择省份</option>
				<s:iterator var="province" value="province_list" status="status">
					
					<option value='<s:property value="#province.code"/>'>
						<s:property value="#province.name"/>
					</option>
				</s:iterator>
				
			</select>
			<select id="city_select" onchange="onCitySelectChange('city_select','district_select')">
				<option value="-1" selected="selected">请选择城市</option>
			</select>
			<select id="district_select">
				<option value="-1" selected="selected">请选择区县</option>
			</select> 
		</td>
	</tr>
	<tr>
		<td>详细地址</td>
		<td><input type="text" id="address_describe" /></td>
	</tr>
</table>
<input type="button" value="添加" onclick="tryAddAddressInfo()"/>
<input type="button" value="取消" onclick="showAddressListFrame()" />

</div>
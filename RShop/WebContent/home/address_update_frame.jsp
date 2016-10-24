<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
<table style="text-align: center;"  cellspacing="0" border="1"> 
	<tr>
		<td>收货人姓名</td>
		<td><input type="text" id="receiver_name" value='<s:property value="addressinfo.receiver_name" />' /></td>
	</tr>
	<tr>
		<td>电话号码</td>
		<td><input type="text" id="phone_num" value='<s:property value="addressinfo.phone_num" />'/></td>
	</tr>
	<tr>
		<td>省市县</td>
		<td>
			<select id="province_select" onchange="onProvinceSelectChange('province_select','city_select','district_select')">
				<option value="-1">请选择省份</option>
				<s:iterator var="province" value="province_list" status="status">
					<s:if test='addressinfo.district.city.province.name == #province.name'>
						<option value='<s:property value="#province.code"/>' selected="selected">
							<s:property value="#province.name"/>
						</option>
					</s:if>
					<s:else>
						<option value='<s:property value="#province.code"/>'>
							<s:property value="#province.name"/>
						</option>
					</s:else>
					
				</s:iterator>
				
			</select>
			<select id="city_select" onchange="onCitySelectChange('city_select','district_select')">
				<option value="-1">请选择城市</option>
				<s:iterator var="city" value="city_list" status="status">
					<s:if test='addressinfo.district.city.name == #city.name'>
						<option value='<s:property value="#city.code"/>' selected="selected">
							<s:property value="#city.name"/>
						</option>
					</s:if>
					<s:else>
						<option value='<s:property value="#city.code"/>'>
							<s:property value="#city.name"/>
						</option>
					</s:else>
				</s:iterator>
				
			</select>
			<select id="district_select">
				<option value="-1">请选择区县</option>
				<s:iterator var="district" value="district_list" status="status">
					<s:if test="addressinfo.district.name == #district.name">
						<option value='<s:property value="#district.code"/>' selected="selected">
							<s:property value="#district.name"/>
						</option>
					</s:if>
					<s:else>
						<option value='<s:property value="#district.code"/>'>
							<s:property value="#district.name"/>
						</option>
					</s:else>
				</s:iterator>
				
			</select> 
		</td>
	</tr>
	<tr>
		<td>详细地址</td>
		<td><input type="text" id="address_describe" value='<s:property value="addressinfo.describe" />' /></td>
	</tr>
</table>
<input type="button" value="保存" onclick='tryUpdateAddressInfo(<s:property value="addressinfo.id" />)'/>
<input type="button" value="取消" onclick="showAddressListFrame()" />

</div>
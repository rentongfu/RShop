<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="addAdvertisementFrame">
<form>
	<table style="text-align: left;" border="1">
		<tr>
			<td>名称</td>
			<td><input type="text" id="advertisement_name" /></td>	
		</tr>
		<tr>
			<td>编码</td>
			<td><input type="text" id="advertisement_code" /></td>
		</tr>
		<tr>
			<td>商品列表 </td>
			<td>
				<table border="1">
					<tr id="add_advertisement_item_list">
						<td>编号</td>
						<td>产品名</td>
						<td>产品编码</td>
						<td>操作</td>
					</tr>
				</table>
				产品图片<input type="file" name="image" id="add_advertisement_product_image" ><br/>
				产品code<input type="text" id="add_advertisement_product_code" value="请输入产品code" onfocus="" />
				<input type="button" value="添加" onclick="tryUploadAdvertisementItem()" />
			</td>
		</tr>
		<tr>
			<td>描述</td>
			<td><textarea rows="4" cols="50" id="advertisement_describe"></textarea></td>
		</tr>
		<tr>
			<td><input type="button" onclick="tryAddAdvertisement()" value="提交" />
				
			</td>
			<td></td>
		</tr>
	</table>
</form>

</div>
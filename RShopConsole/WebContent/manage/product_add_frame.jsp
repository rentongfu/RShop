<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- product adding start -->

<div id="addProductFrame">
	<form>
    	<table style="text-align: left;">
        	<tr>
            	<td>产品名称</td>
                <td><input type="text" id="product_name" /></td>
            </tr>
            <tr>
            	<td>产品编码</td>
            	<td><input type="text" id="product_code" /></td>
            </tr>
            <tr>
            	<td>所属节点id</td>
                <td>
                	<select id="add_product_parent_protype" onchange="onProtypeSelectorSelect('add_product_parent_protype')">
                		<s:iterator value="base_protypes">
                			<option value="protype_option_<s:property value='code' />"><s:property value="name"/></option>
                		</s:iterator>
                	</select>
                </td>
            </tr>
            <tr>
            	<td>价格</td>
                <td><input type="text" id="product_price" /></td>
            </tr>
            <tr>
            	<td style="vertical-align: top">图片</td>
            	<td>
            		<div style="" id="product_image_table">
            			<div style="display:none" id="product_image_mark"></div>
            		</div>
            		<div style="width:100px;height:20px;position: relative;border: outset;text-align: center;display:inline-block;">上传图片<input type="file" style="position: absolute;left:0px;top:0px ;filter:alpha(opacity=00); -moz-opacity: 0.0; opacity:0.0;width:100%;height=100%" name="image" id="product_image" onchange="tryUploadProductImage()" /></div>（请务必上传300X300的图片）
            	</td>
            </tr>
            <tr>
            	<td style="vertical-align: top">描述</td>
            	<td>
            		<textarea id="product_desc" rows="6" cols="60"></textarea>
            	</td>
            </tr>
            <tr>
            	<td style="vertical-align: top">图片介绍</td>
            	<td>
            		<div style="max-width: 800px;" id="product_desc_image_table">
	            		<div style="display: none ;margin-right: 5px"><img src="" width=160 height=120 /></div>
	            		<div style="display:none" id="product_desc_image_mark"></div>
            		</div>
            		<div style="width:100px;height:20px;position: relative;border: outset;text-align: center;display:inline-block;">上传图片<input type="file" style="position: absolute;left:0px;top:0px ;filter:alpha(opacity=00); -moz-opacity: 0.0; opacity:0.0;width:100%;height=100%" name="image" id="product_desc_image" onchange="tryUploadProductDescImage()" /></div>（请务必上传800X600的图片）
            	</td>
            </tr>
            <tr>
            	<td style="vertical-align: top">产品参数</td>
            	<td>
            		<table border="1" id="add_product_parameter_table">
            			<tr id="add_product_parameter_table_title">
            				<td style="width:40px">编号</td>
            				<td style="width:160px">参数名</td>
            				<td style="width:160px">参数值</td>
            				<td style="width:60px">操作</td>
            			</tr>	
            		</table>
            			<input type="text" id="product_parameter_key" />
            			<input type="text" id="product_parameter_value"/>
            			<input type="button" value="添加" onclick="addProductParameter()"/>
            			
            	</td>
            </tr>
            
            <tr>
            	<td><input type="button" value="添加" onclick="tryAddProduct() " /></td>
                <td><input type="button" onclick="showTextArea()" value="显示textarea" /></td>
                
            </tr>
        </table>
    </form>
</div>
<!-- product adding end -->

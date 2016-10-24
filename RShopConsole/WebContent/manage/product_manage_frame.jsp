<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!--product list and-->

<div id="manageProductFrame">
	<form>
    	<table border="1px">
        	<tr>
        		<td>商品id</td>
                <td>商品名称</td>
                <td>价格</td>
                <td>父节点id</td>
                <td>父节点名称</td>
                <td>操作</td>
        	</tr>
            
            <s:iterator value="product_list" id="product" status="st">
            <tr>
            	<td><s:property value="id" /></td>
            	<td><s:property value="name" /></td>
            	<td><s:property value="price" /></td>
            	<td><s:property value="type.id" /></td>
            	<td> <s:property value="type.name" /> </td>
            	<td><input type="button" value="查看" /> <input type="button" value="下架" /> </td>
            </tr>
            </s:iterator>
    	</table>
    <input type="button" value="上一页" />
	<input type="number" disabled="true" />
	<input type="button" value="跳转" />
	<input type="button" value="下一页" />
    </form>
</div>
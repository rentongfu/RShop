<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<form>
    	<table border="1px">
        	<tr>
        		<td>节点id</td>
                <td>节点名称</td>
                <td>父节点id</td>
                <td>父节点名称</td>
                <td>描述</td>
                <td>操作</td>
        	</tr>
            
            <s:iterator value="protype_list" id="protype" status="st">
            <tr>
            	<td><s:property value="id" /></td>
            	<td><s:property value="name" /></td>
            	<td><s:property value="parent.id" /></td>
            	<td><s:property value="parent.name" /></td>
            	<td><s:property value="describe" /></td>
            	<td><input type="button" value="查看"/> </td>
            </tr>
            </s:iterator>
            
    	</table>
    <input type="button" value="上一页" />
	<input type="number" disabled="true" />
	<input type="button" value="跳转" />

	<input type="button" value="下一页" />
    </form>
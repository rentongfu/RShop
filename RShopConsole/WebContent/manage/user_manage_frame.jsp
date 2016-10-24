<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div id="manageUserFrame" >
<table border="1px">
	<tr>
    	<td>用户id</td>
        <td>登陆名</td>
        <td>操作</td>
    </tr>
    <tr>
    	<td>1</td>
        <td>rentongfu</td>
        <td><input type="button" value="禁用" /> <input type="button" value="修改" /></td>
    </tr>
    	 <s:iterator value="userlist" id="user" status="st">
            <tr>
            	<td><s:property value="id" /></td>
            	<td><s:property value="loginname" /></td>
            	<td><input type="button" value="禁用" /> <input type="button" value="修改" /></td>
       
            </tr>
	     </s:iterator>
</table>
<input type="button" value="上一页" />
<input type="number" disabled="true" />
<input type="button" value="跳转" />

<input type="button" value="下一页" />

</div>

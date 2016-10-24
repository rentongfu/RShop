<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

</script>

<div id="addManagerFrame">
<form>
<table>
	<tr>
    	<td>登录名</td>
        <td><input type="text" id="manager_loginname" /></td>
    </tr>
    <tr>
    	<td>密码</td>
    	<td><input type="password" id="manager_password" /></td>
    </tr>
    <tr>
    	<td>确认密码</td>
        <td><input type="password" id="manager_password2" /></td>
    </tr>
    <tr>
    	<td><input type="button" value="添加" onclick="tryAddManager()" /></td>
    	<td><input type="reset" value="重置" /></td>
    </tr>
</table>
</form>
</div>
<!-- adding manager end -->


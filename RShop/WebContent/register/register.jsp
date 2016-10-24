<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/RShop/common/header.css"/>
<link type="text/css" rel="stylesheet" href="/RShop/register/register.css"/>
<title>用户注册</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/common/header.jsp"></jsp:include>
		<div>
			<form id="registerform">
				<table>
					<tr>
						<td>用户名</td>
						<td><input id="loginname" type="text" name="loginname"/></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input id="password" type="password" name="password"/></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td><input id="password2" type="password" name="password2" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="注册" onclick="tryRegister()" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>
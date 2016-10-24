<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/RShop/common/header.css"/>
<link type="text/css" rel="stylesheet" href="/RShop/login/login.css" />
<title>用户登录</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/common/header.jsp"  ></jsp:include>
		<div>
			<form>
				<table>
					<tr>
						<td>用户名</td>
						<td><input type="text" name="loginname" id="loginname"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="password" name="password" id="password"></td>
					</tr>
					<tr>
						<td colspan="2"><input value="登录" type="button" onclick="tryLogin()" /></td>
					</tr>
				</table>
				
			</form>
		</div>
	
	</div>

</body>
</html>
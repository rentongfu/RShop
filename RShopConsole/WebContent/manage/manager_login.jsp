<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- http://localhost:8080/RShop/ManageLoginView --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理登陆</title>
<script type="text/javascript" src="/RShopConsole/common/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
var xmlHttpRequest ;
function tryLogin(){
	var loginname = $("#loginname").val() ;
	var password = $("#password").val() ;
	if( loginname=="" ){
		alert("请输入登录名");
		return ;
	}
	if( password ==""){
		alert("请输入密码");
		return ;
	}
	$.ajax({
		url:"ManagerLoginLogic",
		data:{loginname:loginname,password:password},
		type:"post" ,
		dataType:"json",
		success:function(data){
			if(data.result == "success"){
				window.location.href = "/RShopConsole/ManageView" ;
			}else{
				alert("登录失败") ;
			}
		}
	});
	/*
	var loginname = document.getElementById("loginname").value;
	var password = document.getElementById("password").value ;
	if( loginname=="" ){
		alert("请输入登录名");
		return ;
	}
	if( password ==""){
		alert("请输入密码");
		return ;
	}
	
	
	xmlHttpRequest = new XMLHttpRequest();
	
	var url = "ManagerLoginLogic" ;
	xmlHttpRequest.open("POST", url, true) ;
	xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpRequest.onreadystatechange = tryLoginResponse ;
	xmlHttpRequest.send("loginname=" + loginname + "&password=" + password) ;
	*/
	
}
function tryLoginResponse(){
	if(xmlHttpRequest.readyState == 4){
		
		if( xmlHttpRequest.status == 200){
			var responseText = xmlHttpRequest.responseText;
			if( responseText == "success" ){
				window.location.href = "/RShopConsole/ManageView" ;
			}else{
				document.write(responseText);
			}
		}
	}
	
	
}

</script>
</head>
<body>
<form action="" method="post">
<table style="margin:0 auto">
	<tr>
    	<td>管理员</td>
        <td><input type="text" name="loginname" id="loginname" /></td>
    </tr>
    <tr>
    	<td>密码</td>
        <td><input type="password" name="password" id="password" /></td>
    </tr>
    <tr>
    	<td><input type="button" value="登陆" onclick="tryLogin()" /></td>
        <td><input type="button"  value="注册" onclick=""  /></td>
    </tr>

</table></form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="/RShop/common/header.css" />
</head>
<body>
<div class="container">
	<%@include file="/common/header.jsp" %>
	<div class="content">
	<input type="button" value="收货地址" onclick="showAddressListFrame()"/>
	<input type="button" value="我的订单" onclick="showOrderListFrame()" />
	<input type="button" value="个人信息" />
	<input type="button" value="修改密码" />
</div>
<div id="workframe"></div>
</div>

</body>
</html>
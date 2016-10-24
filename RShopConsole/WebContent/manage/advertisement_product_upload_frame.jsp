<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
<form method="post" enctype="multipart/form-data" action="/RShop/ReceiveAdvertisementProductLogic">

<table border="1px" >
	<tr>
		<td>编号</td>
		<td>产品code</td>
		<td>图片</td>
	</tr>
	<c:forEach items="${add_advertisement_product_list}" var ="product" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${product.code}</td>
			<td><img src="${tmpImageDir}${add_advertisement_product_images[status.index]}" /></td>
		</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td><input type="text" name="advertisement_product_code"/></td>
		<td><input type="file" name="advertisement_product_image"/><input type="submit" value="添加"/></td>
	</tr>
</table>
</form>

</body>
</html>
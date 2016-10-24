<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!-- 废弃 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="height: auto">

<c:forEach items="${productImages}" var="imageName">
	<img src="${baseDir}/${imageName}"   /><br/>
</c:forEach>

<form action="/RShop/ReceiveProductImageLogic" method="post" enctype="multipart/form-data" >	
	<input type="file" name="image" ><input type="submit" value="上传"  /> 
</form>

</body>
</html>
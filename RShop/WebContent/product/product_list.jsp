<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="product.name" /></title>
<jsp:include page="/common/global_include.jsp"></jsp:include>
<link rel="stylesheet" href="/RShop/common/header.css"/>
<link rel="stylesheet" href="/RShop/product/product_info.css"/>
</head>

<body >
<div class="container">
<%@include file="/common/header.jsp" %>
<div style="">
	<div style="width:20%;display:inline-block;float:left;">s</div>
	<div style="width:80%;display:inline-block;">
		<div style="padding-left: 20px">所有产品<s:iterator value="typelist" var="type">><s:property value="type"/></s:iterator></div>
		<hr/>
		<div>
			<%-- 
			<div style="margin-left:20px;margin-top:10px;margin-bottom: 10px">
				<h4 style="width:40px;display:inline-block;margin-bottom: 0px">价格</h4>
				<div style="float:right;width:650px;overflow: hidden">
					<ul style="list-style: none;">
						<li style="display:inline-block;width:60px;margin-left: 20px;margin-right: 20px">1</li>
						<li style="display:inline-block;width:60px;margin-left: 20px;margin-right: 20px">1</li>
						<li style="display:inline-block;width:60px;margin-left: 20px;margin-right: 20px">1</li>
						<li style="display:inline-block;width:60px;margin-left: 20px;margin-right: 20px">1</li>
						<li style="display:inline-block;width:60px;margin-left: 20px;margin-right: 20px">1</li>
					</ul>
				</div>
			</div>
			--%>
		</div>
		<hr/>
		<div style="font-size: 0;margin-top: 20px" >
			<s:iterator value="product_list" var="product">
				<div style="display:inline-block;height:320px;width:260px; margin-left:6px;margin-right:6px;display:inline-block;">
		      		
		      		<div style="width:240px;margin:0 auto ;">
		      			<a href="/RShop/ProductView?product_code=<s:property value='#product.code' />">
		      				<img src="/image/product_image/<s:property value='#product.code' />/<s:property value="#product.images.split(\";\")[0]" />" width="240" height="260" />
		      			</a>
		      		</div>
		      		<div style="text-align:center;font-size: 16px">
		      			<a href="/RShop/ProductView?product_code=<s:property value='#product.code' />">
		      				<s:property value='#product.name' />/<s:property value='#product.price' />
		      			</a>
		      		</div>
		      	</div>
			</s:iterator>
		</div>

	</div>
</div>
</div>
</body>

</html>
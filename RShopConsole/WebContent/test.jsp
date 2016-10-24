<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/RShop/common/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("p").click(function(){
		$(this).hide();
	});
	$("h").click(function(){
		$("p").slideDown();
	});
});
</script>
<title>测试</title>
</head>
<body>
<h1>asdadasd</h1>
<p>asdsadasd</p>
<h>asdsadsad</h>
</body>
</html>
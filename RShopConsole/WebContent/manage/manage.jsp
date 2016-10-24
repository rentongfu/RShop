<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/RShopConsole/common/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="/RShopConsole/common/ajaxfileupload.js" ></script>
<script type="text/javascript" src="/RShopConsole/manage/manage.js"></script>
<link type="text/css" rel="stylesheet" href="/RShopConsole/manage/manage.css"/>
<title>管理后台</title>
<style type="text/css">

</style>
<script type="text/javascript">


</script>

</head>

<body>		
<div class="container">
<div>
<ul class="menu">
	<li id="menu_item1" onmouseover="mouseOverMenuItem('menu_item1');showElement('menu1')" onmouseout="mouseOutMenuItem('menu_item1');hideElement('menu1')">网站配置
    	<ul id="menu1">
        
        </ul>
    
    </li>
    <li id="menu_item2" onmouseover="mouseOverMenuItem('menu_item2');showElement('menu2')" onmouseout="mouseOutMenuItem('menu_item2');hideElement('menu2')">用户管理
   	 <ul id="menu2">
     	<li id="addManagerItem" onMouseOver="mouseOverMenuItem('addManagerItem')" onMouseOut="mouseOutMenuItem('addManagerItem')" onClick="showAddManagerFrame()">添加管理员</li>
		<li id="manageManagerItem" onMouseOver="mouseOverMenuItem('manageManagerItem')" onMouseOut="mouseOutMenuItem('manageManagerItem')" onClick="showManageManagerFrame()">管理管理员</li>
        <li id="addUserItem" onMouseOver="mouseOverMenuItem('addUserItem')" onMouseOut="mouseOutMenuItem('addUserItem')" onClick="showAddUserFrame()">添加会员</li>
   		<li id="manageUserItem" onMouseOver="mouseOverMenuItem('manageUserItem')" onMouseOut="mouseOutMenuItem('manageUserItem')" onClick="showManageUserFrame()">管理会员</li>
   	 </ul>
    </li>
  	
    <li id="menu_item3" onmouseover="mouseOverMenuItem('menu_item3');showElement('menu3')" onmouseout="mouseOutMenuItem('menu_item3');hideElement('menu3')">商品管理
    	<ul id="menu3">
        	<li id="addNodeItem" onMouseOver="mouseOverMenuItem('addNodeItem')" onMouseOut="mouseOutMenuItem('addNodeItem')" onClick="showAddNodeFrame()">添加商品节点</li>
            <li id="manageNodeItem" onMouseOver="mouseOverMenuItem('manageNodeItem')" onMouseOut="mouseOutMenuItem('manageNodeItem')" onClick="showManageNodeFrame()">管理商品节点</li>
            <li id="addProductItem" onMouseOver="mouseOverMenuItem('addProductItem')" onMouseOut="mouseOutMenuItem('addProductItem')" onClick="showAddProductFrame()">添加商品</li>
            <li id="manageProductItem" onMouseOver="mouseOverMenuItem('manageProductItem')" onMouseOut="mouseOutMenuItem('manageProductItem')" onClick="showManageProductFrame()">管理商品</li>
        </ul>
    </li>
    <li id="menu_item4" onmouseover="mouseOverMenuItem('menu_item4');showElement('menu4')" onmouseout="mouseOutMenuItem('menu_item4');hideElement('menu4')">订单管理
    	<ul id="menu4">
        </ul>
    </li>
    <li id="menu_item5" onmouseover="mouseOverMenuItem('menu_item5');showElement('menu5')" onmouseout="mouseOutMenuItem('menu_item5');hideElement('menu5')">广告管理
    	<ul id="menu5">
        	<li id="addAdvertisementItem" onmouseover="mouseOverMenuItem('addAdvertisementItem')" onMouseOut="mouseOutMenuItem('addAdvertisementItem')" onClick="showAddAdvertisementFrame()">添加广告</li>
        	<li id="manageAdvertisementItem" onmouseover="mouseOverMenuItem('manageAdvertisementItem')" onmouseout="mouseOutMenuItem('manageAdvertisementItem')" onClick="showManageAdvertisementFrame()">管理广告</li>
    	</ul>
    </li>
</ul>

<span style="float:right">你好：<s:property value="loginname" /></span>
</div>
<br />
<div class="workframe" id="workframe">

</div>

</div>
</body>
</html>
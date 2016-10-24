<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<div style="border-bottom-style:outset;border-bottom-width:thin;border-bottom-color:#575757;width:100%">
		<div style="float:right;margin-right:10px;">
			<c:choose>
				<c:when test="${!empty sessionScope.login_user }">
					<a href="/RShop/HomeView">
						${sessionScope.login_user.loginname }
					</a>/
					<a href="javascript:void(0)" onclick="tryLogout()" >注销</a>
				</c:when>
				<c:otherwise>
					<a href="/RShop/LoginView">登录</a>/<a href="/RShop/RegisterView">注册</a>	
				</c:otherwise>
			</c:choose>		
		</div>
		<div style="float:right;margin-right:10px;">
			<a href="/RShop/CartView">购物车</a>
		</div>
		<div style="margin-left:10px;float:left">
			<a href="/RShop/IndexView">首页</a>
		</div>
		<div style="padding-left:50px">
			<a href="#">帮助</a>
		</div>
	</div>
	<div style="width:100%">
		<div style="float:right; margin-top:20px;margin-right:10px">
			<form>
				<table>
					<tr>
						<td><input type="text" style=" height:30px;width:250px" /></td>
						<td><input type="button" value="搜索" style="height:30px;" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="float:right; margin-top:25px; margin-right:25px">
			<ul class="menu" style="list-style:none">
				<li><a href="#">图书</a></li>
				<li><a href="/RShop/ProductListView?type_code=TYPEGAME">游戏</a></li>
				<li><a href="/RShop/ProductListView?type_code=TYPEPHONE">手机</a></li>
				<li><a href="/RShop/ProductListView?type_code=TYPECOMPUTER">电脑</a></li>
				<li><a href="#">平板</a></li>
				<li><a href="#">玩具</a></li>
				<li><a href="#">其他</a></li>
			</ul>
		</div> 
		<img src="/RShop/common/logo.PNG" width="158" height="64" alt="logo" style="padding:10px" />
	</div>
</div>
 
function tryLogin(){
	var loginname = $("#loginname").val();
	var password = $("#password").val() ;
	if( (loginname == "")||(password == "") ){
		alert("请输入用户名或密码");
		return ;
	}
	$.ajax({
		url:"/RShop/UserLoginLogic",
		type:"post",
		async:true,
		data:{loginname:loginname,password:password},
		dateType:"text",
		success:function(data ){
			if(data == "success"){
				alert("登录成功");
				document.location.href="/RShop/IndexView" ;
				return ;
			}
			alert(data);
			$("#loginname").attr("value","") ;
			$("#password").attr("value","");
		}
	});
}


function tryRegister(){
	var loginname = $("#loginname").val() ;
	var password = $("#password").val() ;
	var password2 = $("#password2").val();
	if( loginname === ""){
		alert("请输入登录名");
		return ;
	}
	if( password != password2){
		alert("两次输入密码不一致");
		return ;
	}
	$.ajax({
		url:"/RShop/UserRegisterLogic",
		async:true,
		type:"post",
		contentType:"application/x-www-form-urlencoded",
		data:{loginname:loginname,password:password},
		dataType:"text",
		error:function(){
			alert("error");
		},
		success:function(data){
			alert(data);
			if( data == "success"){
				window.location.href = "/RShop/LoginView";
			}
			$("#loginname").attr("value","");
			$("#password").attr("value","");
			$("#password2").attr("value","");
		}
		
		});	
}

function tryLogout(){
	$.ajax({
		url:"/RShop/UserLogoutLogic" ,
		type:"post",
		data:{},
		success:function(){
			window.location.reload();
		}
	});
}
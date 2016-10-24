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
		dateType:"json",
		success:function(data ){
			if(data.result == "success"){
				alert("登录成功");
				document.location.href="/RShop/IndexView" ;
				return ;
			}
			alert(data.error);
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
		dataType:"json",
		error:function(){
			alert("error");
		},
		success:function(data){
			alert(data);
			if( data.result == "success"){
				window.location.href = "/RShop/LoginView";
			}else{
				alert(data.error);
				$("#loginname").attr("value","");
				$("#password").attr("value","");
				$("#password2").attr("value","");
			}
			
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

function tryAddProductToCart(product_code){
	var url = "/RShop/AddProductToCartLogic" ;
	var param = {product_code:product_code} ;
	$.ajax({
		url:url ,
		type:"post",
		data:param,
		dataType:"json",
		success:function(data){
			if(data.result == "success"){
				alert("加入成功");
			}
		}
		}) ;
}

function showAddressListFrame(){
	var url = "/RShop/AddressListFrame" ;
	$.ajax({
		url:url ,
		type:"get",
		data:{},
		dataType:"html",
		success:function(data){
			$("#workframe").html(data);
		}
		}) ;
}

function showAddressUpdateFrame(addressinfo_id){
	var url = "/RShop/AddressUpdateFrame" ;
	$.ajax({
		url:url ,
		type:"get",
		data:{addressinfo_id:addressinfo_id},
		dataType:"html",
		success:function(data){
			$("#workframe").html(data);
		}
		}) ;
}

function showAddressAddFrame(){
	var url = "/RShop/AddressAddFrame" ;
	$.ajax({
		url:url ,
		type:"get",
		data:{},
		dataType:"html",
		success:function(data){
			$("#workframe").html(data);
		}
		}) ;
}

function tryAddAddressInfo(){
	var url = "/RShop/AddAddressInfoLogic" ;
	var receiver_name = $("#receiver_name").val();
	var phone_num = $("#phone_num").val();
	var describe = $("#address_describe").val();
	var district_code = $("#district_select").val();
	
	
	if(receiver_name == "" || phone_num=="" || describe=="" ){
		alert("请补全信息");
		return;
	}
	if(district_code == "-1"){
		alert("请选择省市县");
		return;
	}
	var params = {receiver_name:receiver_name,phone_num:phone_num,describe:describe,district_code:district_code} ;
	$.ajax({
		url:url,
		data:params,
		type:'post',
		dataType:'json',
		success:function(data){
			if(data.result == "success"){
				alert("添加成功");
				showAddressListFrame();
			}else{
				alert("添加失败："+ data.error);
			}
		}
	});
}
function tryDeleteAddressInfo(addressinfo_id){
	var url="/RShop/DeleteAddressInfoLogic" ;
	$.ajax({
		url:url,
		data:{addressinfo_id:addressinfo_id},
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.result == "success"){
				alert("删除成功");
				showAddressListFrame();
			}
		}
		
	});
}

function tryUpdateAddressInfo(addressinfo_id){
	var url="/RShop/UpdateAddressInfoLogic" ;
	var receiver_name = $("#receiver_name").val();
	var phone_num = $("#phone_num").val();
	var describe = $("#address_describe").val();
	var district_code = $("#district_select").val();
	
	
	if(receiver_name == "" || phone_num=="" || describe=="" ){
		alert("请补全信息");
		return;
	}
	if(district_code == "-1"){
		alert("请选择省市县");
		return;
	}
	$.ajax({
		url:url,
		data:{addressinfo_id:addressinfo_id,receiver_name:receiver_name,phone_num:phone_num,describe:describe,district_code:district_code},
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.result == "success"){
				alert("修改成功");
				showAddressListFrame();
			}
		}
		
	});
}


function trySubmitOrder(){
	var address_index = $("[name=address_info]:checked").val();
	var url = "/RShop/OrderSubmitLogic" ;
	var params = {address_index:parseInt(address_index)} ;
	$.ajax({
		url:url,
		data:params,
		type:'post',
		dataType: 'json',
		success:function(data){
			if(data.result == "success"){
				alert("添加成功");
			}else{
				alert("添加失败："+ data.error);
			}
		}
		
	}) ;
}

function showOrderListFrame(){
	var url = "/RShop/OrderListFrame" ;
	$.ajax({
		url:url ,
		type:"get",
		data:{},
		dataType:"html",
		success:function(data){
			$("#workframe").html(data);
		}
		}) ;
}

function tryIncreaseQuantityOfCartItem(index){
	var url = "/RShop/IncreaseQuantityOfCartItemLogic" ;
	//index = parseInt(index);
	$.ajax({
		url:url,
		type:'get',
		data:{cartitem_index:index},
		dataType:"json",
		success:function(data){
			if( data.result == "success"){
				
				window.location.reload();
			}
		}
	}) ;
}

function tryDecreaseQuantityOfCartItem(index){
	var url= "/RShop/DecreaseQuantityOfCartItemLogic" ;
	//index = parseInt(index);
	$.ajax({
		url:url,
		type:'get',
		data:{cartitem_index:index},
		dataType:"json",
		success:function(data){
			if( data.result == "success"){
				
				window.location.reload();
			}
		}
	}) ;
}

function tryRemoveCartItem(index){
	var url = "/RShop/RemoveCartItemLogic" ;
	//index = parseInt(index);
	$.ajax({
		url:url,
		type:'get',
		data:{cartitem_index:index},
		dataType:"json",
		success:function(data){
			if( data.result == "success"){
				
				window.location.reload();
			}
		}
	}) ;
}

function jumpToOrderView(orderid){
	var url="/RShop/OrderView";
	window.location.href=url + "?order_id="+orderid;
}

function tryCancelOrder(orderid){
	var url = "/RShop/OrderCancelLogic" ;
	$.ajax({
		url:url,
		type:'post',
		data:{order_id:orderid},
		dataType:"json",
		success:function(data){
			if( data.result == "success"){
				
				window.location.reload();
			}else{
				alert(data.error);
			}
		}
	}) ;
}

function onProvinceSelectChange(province_select_id , city_select_id , district_select_id ){
	var province_code = $("#"+province_select_id).val();
	
	$("#"+city_select_id).empty();
	var option = new Option("请选择城市", "-1", true, true);
	$("#"+city_select_id).append(option);
	
	$("#"+district_select_id).empty();
	option = new Option("请选择区县", "-1", true, true);
	$("#"+district_select_id).append(option);
	
	if(province_code=="-1"){
		return ;
	}else{
		$.ajax({
			url : "/RShop/GetCityListLogic" ,
			type: "post" ,
			data: {province_code:province_code},
			dataType:"json",
			success:function(data){
				if(data.result == "success"){
					
					for(var city in data.city_list){
						option = new Option(data.city_list[city].name, data.city_list[city].code, false, false);
						$("#"+city_select_id).append(option);
					}
				}else{
					alert(data.error);
				}
			}
		});
	}
}

function onCitySelectChange( city_select_id , district_select_id ){
	$("#"+district_select_id).empty();
	var option = new Option("请选择区县", "-1", true, true);
	$("#"+district_select_id).append(option);
	
	var city_code = $("#"+city_select_id).val();
	if( city_code == "-1"){
		return;
	}else{
		$.ajax({
			url : "/RShop/GetDistrictListLogic" ,
			type: "post" ,
			data: {city_code:city_code},
			dataType:"json",
			success:function(data){
				if(data.result == "success"){
					
					for(var index in data.district_list){
						option = new Option(data.district_list[index].name, data.district_list[index].code, false, false);
						$("#"+district_select_id).append(option);
					}
				}else{
					alert(data.error);
				}
			}
		});
	}
	
}

function mouseOverMenuItem( MenuItemId ){
	document.getElementById(MenuItemId).style.backgroundColor = "#999" ;		
}
function mouseOutMenuItem( MenuItemId ) {
	document.getElementById(MenuItemId).style.backgroundColor = "#CCC" ;
}

function showMenu( id ){
	$("#"+id).slideDown() ;
	//$("#"+id).css("display","block");
}
function hideMenu( id ){
	//$("#"+id).slideUp();
	$("#"+id).css("display","none");
}

function showElement( id ){
	document.getElementById(id).style.display = "block" ;
}

function hideElement( id ) {
	document.getElementById(id).style.display = "none";
}


function setWorkFrame(url){
	$.ajax({
		url:url ,
		type:"GET",
		dataType:"html",
		success:function(data){
			$("#workframe").html(data);
		}	
	});
}

function showAddManagerFrame(){
	var url = "/RShopConsole/ManagerAddFrame" ;
	setWorkFrame(url);
}
function showManageManagerFrame(){
	var url = "/RShopConsole/ManagerManageFrame" ;
	setWorkFrame(url);
}
function showAddUserFrame(){
	var url = "/RShopConsole/UserAddFrame" ;
	setWorkFrame(url);
}
function showManageUserFrame(){
	var url = "/RShopConsole/UserManageFrame" ;
	setWorkFrame(url);
}
function showAddNodeFrame(){
	var url = "/RShopConsole/ProTypeAddFrame" ;
	setWorkFrame(url);
}
function showManageNodeFrame(){	
	var url = "/RShopConsole/ProTypeManageFrame" ;
	setWorkFrame(url);	
}

function showManageProductFrame(){
	var url = "/RShopConsole/ProductManageFrame";
	setWorkFrame(url);
}

function showAddAdvertisementFrame(){
	var url = "/RShopConsole/AdvertisementAddFrame" ;
	setWorkFrame(url);
}
function showManageAdvertisementFrame(){
	var url = "/RShopConsole/AdvertisementManageFrame" ;
	setWorkFrame(url);
}

function showAddProductFrame(){
	product_parameter_count = 0 ;
	product_image_count = 0 ;
	product_desc_image_count = 0 ;
	var url = "/RShopConsole/ProductAddFrame" ;
	setWorkFrame(url);
}

function showTextArea(){
	alert($("#product_desc").val());
}

function tryAddProduct(){
	var url = "/RShopConsole/AddProductLogic" ;
	var product_name = $("#product_name").val();
	var product_code = $("#product_code").val();
	var parent_code = selected_parent_protype_code ;
	var price = $("#product_price").val();
	var product_desc = $("#product_desc").val();

	var _productParameterKey = {};
	var _productParameterValue = {} ;
	
	for(var i = 0 ; i < product_parameter_count ; i++){
		_productParameterKey[i] = productParameterKey[i] ;
		_productParameterValue[i] = productParameterValue[i] ;
	}
	
	$.ajax({
		url:url,
		data:{product_name:product_name,product_code:product_code,type_code:parent_code,price:price,product_desc:product_desc,product_parameter_keys:_productParameterKey,product_parameter_values:_productParameterValue},
		type:"post",
		dataType:"json",
		success:function(data){
			if(data.status == 'success'){
				alert("添加成功");
			}else{
				alert("添加失败" + data.error);
			}
		}
	});
}

var productParameterKey = new Array();
var productParameterValue= new Array();
var product_parameter_count = 0 ;

function addProductParameter(){
	
	parameter_key = $("#product_parameter_key").val();
	parameter_value = $("#product_parameter_value").val();
	productParameterKey[product_parameter_count] = parameter_key ;
	productParameterValue[product_parameter_count] = parameter_value ;
	product_parameter_count++ ;
	refreshProductParameterTable();
}

function removeProductParameter(index,tr_id){
	if( index + 1 == product_parameter_count){
		//如果选定索引为表尾索引，无需执行元素移动操作
	}else{//如果选定索引不是表尾索引，需要执行元素移动操作
		for ( var i = index ; i < product_parameter_count-1 ; i++){
			productParameterKey[i] = productParameterKey[i +1] ;
			productParameterValue[i] = productParameterValue[i +1] ;
		}
	}
	product_parameter_count-- ;
	refreshProductParameterTable();
//	$("#"+tr_id).remove();
}

function refreshProductParameterTable(){
	var xml = "" ;
	for ( var i = 0 ; i < product_parameter_count ; i++){
		
		var parameter_key = productParameterKey[i];
		var parameter_value = productParameterValue[i];
		xml =  xml + "<tr id='parameter_"+ i +"_tr'><td>"+ i +"</td><td>"+parameter_key+"</td><td>"+parameter_value+"</td><td><input type='button' onclick=\"removeProductParameter("+i+")\" value='删除' /></td></tr>" ;
//		$("#add_product_parameter_table").html(xml);
	
	}
	$("#add_product_parameter_table_title ~ tr").remove();
	$("#add_product_parameter_table_title").after(xml);
}

var product_image_count = 0 ;

function tryUploadProductImage(){
	if (product_image_count >= 10){
		alert("最多上传10张图片")
		return;
	}
	
	$.ajaxFileUpload({
		url: '/RShopConsole/UploadProductImageLogic' ,
		secureuri:false,
		fileElementId:'product_image',
		dataType: 'json',
		type: 'post',
		success:function(data){
			if(data.status == 'success'){
				product_image_count++ ;
				refreshProductImageList(data.images , data.imagesDir) ;
			}
		},
		error: function (data, status, e)//服务器响应失败处理函数
        {
            alert(e);
        }
	});
}

function refreshProductImageList(images, imagesDir){
	var xml = "" ;
	for(var i = 0 ; i < images.length ; i++ ){
		var image = imagesDir +  images[i] ;
		xml = xml + "<div style='display:inline-block;margin-right:5px'><img src='"+ image +"' width='160' height='120' style='' /></div>" ;
	}
	$("#product_image_table").html(xml);
}

var product_desc_image_count = 0 ;

function tryUploadProductDescImage(){
	if(product_desc_image_count >= 20 ){
		alert("最多上传20张介绍图片");
		return ;
	}
	$.ajaxFileUpload({
		url:'/RShopConsole/UploadProductDescImageLogic',
		secureuri:false,
		fileElementId:'product_desc_image',
		dataType:'json',
		type:'post',
		success:function(data){
			if(data.status == 'success'){
				/*
				product_desc_image_count++ ;
				var xml = "<div style='display:inline-block;margin-right:5px'><img src='"+ data.imageDir +"' width='160' height='120' style='' /></div>" ;
				$("#product_desc_image_mark").before(xml);*/
				refreshProductDescImageList(data.images,data.imageDir);
			}
		}
	});
}


function refreshProductDescImageList(images,imageDir){
	var xml = "" ;
	for(var i = 0 ; i < images.length ; i++ ){
		var image = imageDir + images[i] ;
		xml = xml + "<div style='display:inline-block;margin-right:5px'><img src='"+ image +"' width='160' height='120' style='' /></div>" ;
	}
	$("#product_desc_image_table").html(xml);
}

function tryAddProType(){
	var url = "/RShopConsole/AddProTypeLogic" ;
	var protype_name = $("#protype_name").val();
	var protype_code = $("#protype_code").val();
	var parent_code = selected_parent_protype_code;
	var protype_desc = $("protype_desc").val();
	
	$.ajax({
		url:url,
		data:{protype_name:protype_name,protype_code:protype_code,parent_code:parent_code,protype_desc:protype_desc},
		type:"POST",
		dataType:"json",
		success:function(data){
			
			if(data.status=="success"){
				alert("添加成功");
			}else{
				alert(data.error);
			}
		}
	});
	selected_parent_protype_code = "all" ;
}

var selected_parent_protype_code="all" ;

function onProtypeSelectorSelect(select_node_id){
	$("#" + select_node_id + "~ select").remove();
	var get_child_protype_url="/RShopConsole/GetProtypesByParentLogic" ;
	//alert($(this).val());
	var code = $("#"+select_node_id).val().substring("protype_option_".length);
	var name = $("#"+select_node_id+" option:selected").text() ;
	var index =$("#"+select_node_id).get(0).selectedIndex ;
//	alert(index);
	if( index == 0 ){
		return ;
	}
	selected_parent_protype_code = code;
	$.ajax({
		url:get_child_protype_url,
		data:{parent_code:code},
		type:"GET",
		dataType:"json",
		success:function(data){
			if(data.status=="success"){
				if( data.result.length>0){
					var xml = genetate_protype_select_xml(data.result,select_node_id+"_",code,name);
					$("#"+select_node_id).after(xml);
				}else{
//					alert("无子类型");
				}
			}else{
				alert("载入失败");
			}
//			alert(JSON.stringify(data));
			
		}
	});
	
}

function genetate_protype_select_xml(protypes,id,parent_code,parent_name){
	var str = "<select id=\"" + id +"\" onchange=\"onProtypeSelectorSelect(\'"+id+"\')\" >" ;
	str = str + "<option value=\""+"protype_option_" + parent_code + "\">"
	+ parent_name +"</option>";
	for ( var i = 0 ; i < protypes.length ; i++){
		str = str + "<option value=\""+"protype_option_" + protypes[i].code + "\">"
		+ protypes[i].name +"</option>";
	}
	str+= "</select>";
	return str;
}

function tryAddManager(){
	var loginname = document.getElementById("manager_loginname").value ;
	var password = document.getElementById("manager_password").value ;
	var password2 = document.getElementById("manager_password2").value;
	
	if( loginname=="" ){alert("请输入登录名");return ;}
	if( password ==""){alert("请输入密码");return ;}
	if( password2==""){alert("请再次输入密码");return ;}
	if( password != password2){alert("两次输入密码不一致");return ;}
	
	var xmlHttpRequest = new XMLHttpRequest();
	var url = "/RShop/AddManagerLogic" ;
	xmlHttpRequest.open("POST" , url , true ) ;
	xmlHttpRequest.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded");
	xmlHttpRequest.onreadystatechange = function(){
		if( xmlHttpRequest.readyState == 4){
			if(xmlHttpRequest.status == 200){
				var responseText =xmlHttpRequest.responseText ;
				//处理服务器返回的数据
				if( responseText == "success"){
					alert("添加成功");
				}else{
					alert("添加失败");
				}
				document.getElementById("manager_loginname").value = "" ;
				document.getElementById("manager_password").value= "" ;
				document.getElementById("manager_password2").value = "" ;
			}
		}
	} ;
	xmlHttpRequest.send("loginname=" + loginname + "&password=" + password) ;
}

function tryUploadAdvertisementItem(){
	var product_code = $("#add_advertisement_product_code").val();
	var product_image = $("#add_advertisement_product_image").val();
	//if( product_image = null) product_image = "" ;
	if(product_image == ""){
		alert("请选择文件！！！");
		return ;
	}
	if(product_code == "" ){
		alert("请输入code");
		return ;
	}
	$.ajaxFileUpload({
		url:'/RShopConsole/UploadAdvertisementItemLogic' ,
		data:{product_code:product_code},
		secureuri:false ,
		fileElementId:'add_advertisement_product_image' ,
		dataType:'json' ,
		type:'post' ,
		success:function(data){
			if(data.result == "success" ){
				alert(data.result) ;
				refreshAddAdvertisementItemsList(data.items,data.imageDir);
			}else{
				alert(data.error) ;
			}
		}
	});
}

function refreshAddAdvertisementItemsList(items,imageDir){
	var xml = "" ;
	for( var i = 0 ; i < items.length ; i++){
		xml = xml + "<tr><td>" + i + "</td><td>" + items[i].product.name + "</td><td>" + items[i].product.code + "</td><td>" + "</td></tr>"
	}
	$("#add_advertisement_item_list ~ tr").remove();
	$("#add_advertisement_item_list").after(xml);
}

function tryAddAdvertisement(){
	var advertisement_name = $("#advertisement_name").val();
	var advertisement_code = $("#advertisement_code").val();
	var advertisement_desc = $("#advertisement_describe").val() ;
	if( advertisement_name == ""){
		alert("广告名不能为空");
		return ;
	}
	if( advertisement_code == "" ){
		alert("广告编码不能为空");
		return ;
	}
	if(advertisement_desc == ""){
		alert("广告描述不能为空");
		return ;
	}
	$.ajax({
		url:'/RShopConsole/AddAdvertisementLogic' ,
		data:{advertisement_name:advertisement_name,advertisement_code:advertisement_code,advertisement_desc:advertisement_desc} ,
		dataType:'json',
		type:'post',
		success:function(data){
			if(data.status == "success"){
				alert("添加成功");
			}
		}
	});
}

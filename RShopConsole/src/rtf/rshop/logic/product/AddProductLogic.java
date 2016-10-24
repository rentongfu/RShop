package rtf.rshop.logic.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.other.GlobalParameter;
import rtf.rshop.po.RProType;
import rtf.rshop.po.RProduct;
import rtf.rshop.po.RProductParameter;
import rtf.rshop.util.FileUtil;

public class AddProductLogic extends RLogicAction{
	private String product_name = "" ;
	private String product_code = "" ;
	private String type_code = "" ;
	private double price = -1 ;
	private String product_desc = "" ;
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getType_code() {
		return type_code;
	}

	public void setType_code(String type_code) {
		this.type_code = type_code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}



	private List<String> product_parameter_keys = new ArrayList<String>() ;

	private List<String> product_parameter_values =  new ArrayList<String>() ;

	
	public List<String> getProduct_parameter_keys() {
		return product_parameter_keys;
	}

	public void setProduct_parameter_keys(List<String> product_parameter_keys) {
		this.product_parameter_keys = product_parameter_keys;
	}

	public List<String> getProduct_parameter_values() {
		return product_parameter_values;
	}

	public void setProduct_parameter_values(List<String> product_parameter_values) {
		this.product_parameter_values = product_parameter_values;
	}

	@Override
	public void performExecute() {
		printParameter();
		//TODO 用户权限检查   
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> sessionMap = ctx.getSession();
		if(!sessionMap.containsKey("manager_loginname") ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "用户没有权限");
			return ;
		}
		
		//输入数据检查
		if( !parameterCheck() ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "参数错误");
			return ;
		}
		
		//检查product_code是否已经存在
		RProductDao productDao = new RProductDaoImpl();
		if(productDao.getProductByCode(product_code)!=null){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "产品编码已占用");
			return;
		}
		RProType parent_type = null ;
		RProTypeDao protypeDao = new RProTypeDaoImpl();
		parent_type  = protypeDao.getProTypeByCode(type_code);
		if( parent_type == null ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "类型编码不存在");
			return;
		}
			
		RProduct product = new RProduct() ;
		
		product.setName(product_name);
		product.setCode(product_code);
		product.setDescribe(product_desc);
		product.setPrice(price);
		product.setType(parent_type);
		List<RProductParameter> parameters = new ArrayList<RProductParameter>();
		for ( int i = 0 ; i < product_parameter_values.size() ; i++  ){
			RProductParameter parameter = new RProductParameter() ;
			parameter.setProduct(product);
			parameter.setKey(product_parameter_keys.get(i));
			parameter.setValue(product_parameter_values.get(i));
			parameters.add(parameter);
		}
		product.setParameters(parameters);
		
		
		List<String> product_images = (List<String>) sessionMap.get("add_product_images");
		List<String> product_desc_images = (List<String>) sessionMap.get("add_product_desc_images");
		if(product_images == null || product_images.size() < 5 ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "没有上传商品图片，或者商品图片数量过少，请至少上传5张商品图片");
			return;
		}
		if(product_desc_images == null || product_desc_images.size() < 5 ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "没有上传商品描述图片，或者商品描述图片数量过少，请至少上传5张商品描述图片");
			return ;
		}
		String sessionID = ServletActionContext.getRequest().getSession().getId();
		try{
			copyImage(product_images , GlobalParameter.absoluteImageDir + "/tmp/image/add_product/" + sessionID , GlobalParameter.absoluteImageDir + "/product_image/" +  product.getCode());
		
			copyImage(product_desc_images , GlobalParameter.absoluteImageDir + "/tmp/image/add_product/desc/" + sessionID , GlobalParameter.absoluteImageDir + "/product_image/" + product.getCode() +"/desc/");
			
		}catch (IOException e){
			putResponseProperty("status", "failure");
			putResponseProperty("error", "文件IO错误");
			return ;
		}
		
		product.setImages(convertImageList(product_images));
		product.setImagedescribe(convertImageList(product_desc_images));
		
		//RProductDao productDao= new RProductDaoImpl();
		
		//执行添加
		productDao.addProduct(product);
		
		putResponseProperty("status", "success");
		return ;
	}
	
	private void copyImage(List<String> image_list , String src , String dest ) throws IOException{
		for(String buf : image_list ){
			FileUtil.fileCopy(src + "/" + buf , dest + "/" + buf);
		}
	}
	
	private String convertImageList(List<String> image_list){
		StringBuffer buf = new StringBuffer();
		for ( String str : image_list ){
			buf.append(str + ";");
		}
		buf.deleteCharAt(buf.length()-1);
		return buf.toString();
	}
	
	private boolean parameterCheck(){
		//product_name,product_code 不能为空,price不能小于0
		if( product_name.length() == 0 || product_code.length() == 0 || price<0 )
			return false;
		
		return true ;
	}
	
	private void printParameter(){
		System.out.println("product_name:"+product_name);
		System.out.println("product_code:"+product_code);
		System.out.println("product_desc" + product_desc);
		System.out.println("price:" + price);
		System.out.println("product_parameter_keys");
		if( product_parameter_keys != null){
			for( String str : product_parameter_keys){
				System.out.println("---"+str);
			}
		}else{
			System.out.println("nothing");
		}
		System.out.println("product_parameter_values");
		if( product_parameter_values != null){
			for( String str : product_parameter_values){
				System.out.println("---"+str);
			}
		}else{
			System.out.println("nothing");
		}
		
	}
	
}

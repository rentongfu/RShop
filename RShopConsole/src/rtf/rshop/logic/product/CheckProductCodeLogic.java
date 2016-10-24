package rtf.rshop.logic.product;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RProductDaoImpl;

public class CheckProductCodeLogic {
	private String product_code ;

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	private InputStream result ;
	
	public String execute(){
		//TODO 
		RProductDao productDao = new RProductDaoImpl();
		if( productDao.getProductByCode(product_code) == null){
			result = new ByteArrayInputStream("success".getBytes(Charset.forName("UTF-8")));
			return "success";
		}else{
			result = new ByteArrayInputStream("error".getBytes(Charset.forName("UTF-8")));
			return "success";
		}
	}

	public InputStream getResult() {
		return result;
	}

	public void setResult(InputStream result) {
		this.result = result;
	}
}

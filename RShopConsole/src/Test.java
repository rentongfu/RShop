import java.util.List;

import org.apache.struts2.ServletActionContext;

import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.po.RProduct;

public class Test {
	public static void main(String[] args){
		List<RProduct> prolist = new RProductDaoImpl().getAllProduct();
//		List<RProType> protypelist = new RProTypeDaoImpl().getAllProType();
	}

	public String execute(){
		System.out.println(ServletActionContext.getRequest().getRealPath("/"));
		
		
		return "success" ;
	}
}

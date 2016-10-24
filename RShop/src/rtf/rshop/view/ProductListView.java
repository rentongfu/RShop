package rtf.rshop.view;

import java.util.ArrayList;
import java.util.List;

import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.po.RProType;
import rtf.rshop.po.RProduct;

public class ProductListView {
	private List<RProduct> product_list ;
	
	private String type_code ;

	private List<String> typelist = new ArrayList<String>();
	public String execute(){
		
		RProType type = new RProTypeDaoImpl().getTypeByCode(type_code);
		setProduct_list(new RProductDaoImpl().getProductByType(type));
		insertAnsestorTolist(type);
		return "success" ;
	}
	private void insertAnsestorTolist(RProType type) {
		// TODO Auto-generated method stub
		if(type.getParent().getCode().equals("all")){
			//typelist.add(type.getParent().getName());
		}else{
			insertAnsestorTolist(type.getParent());
		}
		typelist.add(type.getName());
	}
	
	public List<String> getTypelist() {
		return typelist;
	}
	public void setTypelist(List<String> typelist) {
		this.typelist = typelist;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public List<RProduct> getProduct_list() {
		return product_list;
	}
	public void setProduct_list(List<RProduct> product_list) {
		this.product_list = product_list;
	}
}

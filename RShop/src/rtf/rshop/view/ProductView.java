package rtf.rshop.view;

import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.po.RProType;
import rtf.rshop.po.RProduct;
import rtf.rshop.po.RProductParameter;

import java.util.List;
import java.util.ArrayList ;

public class ProductView {
	private String product_code ;
	private RProduct product ;
	private String[] product_images ;
	private String[] product_desc_images ;
	private List<String> typelist = new ArrayList<String>();
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public RProduct getProduct() {
		return product;
	}
	public List<String> getTypelist() {
		return typelist;
	}
	public void setTypelist(List<String> typelist) {
		this.typelist = typelist;
	}
	public void setProduct(RProduct product) {
		this.product = product;
	}
	public String execute(){
		product = new RProductDaoImpl().getProductByCode(product_code);
		insertAnsestorTolist(product.getType());
		product_images =product.getImages().split(";");
		setProduct_desc_images(product.getImagedescribe().split(";"));
		return "success";
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
	public String[] getProduct_images() {
		return product_images;
	}
	public void setProduct_images(String[] product_images) {
		this.product_images = product_images;
	}
	public String[] getProduct_desc_images() {
		return product_desc_images;
	}
	public void setProduct_desc_images(String[] product_desc_images) {
		this.product_desc_images = product_desc_images;
	}

	
}

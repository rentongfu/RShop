package rtf.rshop.view.manage;

import java.util.List;

import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.po.RProduct;

public class ProductManageFrame {
	private List<RProduct> product_list ;
	public String execute(){
		RProductDao productDao= new RProductDaoImpl();
		product_list = productDao.getAllProduct();
		return "success";
	}
	/**
	 * @return the product_list
	 */
	public List<RProduct> getProduct_list() {
		return product_list;
	}
	/**
	 * @param product_list the product_list to set
	 */
	public void setProduct_list(List<RProduct> product_list) {
		this.product_list = product_list;
	}

}

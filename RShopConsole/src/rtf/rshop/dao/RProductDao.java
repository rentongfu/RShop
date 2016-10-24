package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RProduct;

public interface RProductDao {
	public boolean addProduct(RProduct product);
	public List<RProduct> getAllProduct();
	public RProduct getProductByCode(String code);
}

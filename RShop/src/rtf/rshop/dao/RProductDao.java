package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RProType;
import rtf.rshop.po.RProduct;

public interface RProductDao {
	public List<RProduct> getAllProduct();
	public RProduct getProductByCode(String code);
	
	public List<RProduct> getProductByType(RProType type);
}

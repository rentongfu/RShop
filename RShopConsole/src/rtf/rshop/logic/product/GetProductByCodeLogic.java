package rtf.rshop.logic.product;

import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RProduct;

public class GetProductByCodeLogic extends RLogicAction{
	private String code ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		RProductDao productDao = new RProductDaoImpl();
		RProduct product = productDao.getProductByCode(code);
		if( product == null){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "code error");
			return ;
		}else{
			putResponseProperty("status", "success");
			putResponseProperty("product", product);
			return ;
		}
		
	}

}

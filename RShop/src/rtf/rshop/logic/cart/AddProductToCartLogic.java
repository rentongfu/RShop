package rtf.rshop.logic.cart;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RCartDao;
import rtf.rshop.dao.RCartItemDao;
import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RCartDaoImpl;
import rtf.rshop.dao.impl.RCartItemDaoImpl;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RCartItem;
import rtf.rshop.po.RProduct;
import rtf.rshop.po.RUser;

public class AddProductToCartLogic extends RLogicAction{
	private String product_code ;

	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		
		Map<String,Object> sessionMap = ActionContext.getContext().getSession() ;
		
		RUser user = (RUser) sessionMap.getOrDefault("login_user",null);
		if(user == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "ÓÃ»§Î´µÇÂ¼");
			return ;
		}
		
		RProductDao productDao = new RProductDaoImpl();
		RProduct product= productDao.getProductByCode(product_code);
		if( product == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "²úÆ·±àÂë´íÎó");
			return ;
		}
		
		RCartDao cartDao = new RCartDaoImpl();
		
		RCart cart  = (RCart) sessionMap.getOrDefault("cart",null);

		if( cart == null ){
			cart = cartDao.getCart(user) ;
		}
		RCartItem cart_item = new RCartItem() ;
		cart_item.setProduct(product);
		RCartItemDao cartitemDao = new RCartItemDaoImpl();
		cartitemDao.addCartItem(cart_item, cart);
		sessionMap.put("cart", cart);
		putResponseProperty("result", "success");
		return ;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
}

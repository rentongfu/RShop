package rtf.rshop.logic.cart;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RCartDao;
import rtf.rshop.dao.impl.RCartDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RCartItem;
import rtf.rshop.po.RUser;

public class DecreaseQuantityOfCartItemLogic extends RLogicAction{
	private int cartitem_index ;

	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "ÓÃ»§Î´µÇÂ¼");
			return ;
		}
		
		RCartDao cartDao = new RCartDaoImpl() ;
		RCart cart = cartDao.getCart(user );
		
		cartDao.decreaseQuantityOfCartItem(cart,cartitem_index);
		putResponseProperty("result", "success");
		
	}

	public int getCartitem_index() {
		return cartitem_index;
	}

	public void setCartitem_index(int cartitem_index) {
		this.cartitem_index = cartitem_index;
	}
	
}

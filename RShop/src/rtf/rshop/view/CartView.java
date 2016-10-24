package rtf.rshop.view;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RCartDao;
import rtf.rshop.dao.impl.RCartDaoImpl;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RUser;

public class CartView {
	private RCart cart = null;
	
	public String execute(){
		Map<String,Object> sessionMap = ActionContext.getContext().getSession() ;
		RUser user = (RUser) sessionMap.getOrDefault("login_user", null) ;
		if( user == null){
			return "error" ;
		}
		
		RCartDao cartDao = new RCartDaoImpl();
		cart = cartDao.getCart(user) ;
	
		sessionMap.put("cart", cart);
		return "success";
	}

	public RCart getCart() {
		return cart;
	}

	public void setCart(RCart cart) {
		this.cart = cart;
	}
}

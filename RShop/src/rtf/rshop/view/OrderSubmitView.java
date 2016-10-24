package rtf.rshop.view;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.dao.impl.RCartDaoImpl;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RUser;

public class OrderSubmitView {
	private RCart cart ;
	private List<RAddressInfo> address_list ;
	public String execute(){
		Map<String, Object> sessionMap = ActionContext.getContext().getSession() ;
		RUser user = (RUser) sessionMap.getOrDefault("login_user", null);
		if(user == null ){
			return "error" ;
		}
		cart = new RCartDaoImpl().getCart(user);
		setAddress_list(new RAddressInfoDaoImpl().getAddressInfoByUser(user));
		return "success";
	}
	public RCart getCart() {
		return cart;
	}
	public void setCart(RCart cart) {
		this.cart = cart;
	}
	public List<RAddressInfo> getAddress_list() {
		return address_list;
	}
	public void setAddress_list(List<RAddressInfo> address_list) {
		this.address_list = address_list;
	}

}

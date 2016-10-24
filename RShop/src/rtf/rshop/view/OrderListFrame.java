package rtf.rshop.view;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.impl.ROrderDaoImpl;
import rtf.rshop.po.ROrder;
import rtf.rshop.po.RUser;

public class OrderListFrame {
	private List<ROrder> order_list ;
	public String execute(){
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null ){
			return "error" ;
		}
		
		setOrder_list(new ROrderDaoImpl().getOrderByUser(user));
		return "success" ;
	}
	public List<ROrder> getOrder_list() {
		return order_list;
	}
	public void setOrder_list(List<ROrder> order_list) {
		this.order_list = order_list;
	}
}

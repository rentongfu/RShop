package rtf.rshop.view;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.ROrderDao;
import rtf.rshop.dao.impl.ROrderDaoImpl;
import rtf.rshop.po.ROrder;
import rtf.rshop.po.RUser;

public class OrderView {
	private int order_id ;
	private ROrder order ;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public ROrder getOrder() {
		return order;
	}
	public void setOrder(ROrder order) {
		this.order = order;
	}
	public String execute(){
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null ){
			return "error" ;
		}
		
		ROrderDao orderDao = new ROrderDaoImpl();
		order = orderDao.getOrderById(order_id) ;
		if(order.getUser().getId() != user.getId()){
			return "error" ;
		}
		
		return "success" ;
	}
}

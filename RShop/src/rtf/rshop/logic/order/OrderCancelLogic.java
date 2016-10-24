package rtf.rshop.logic.order;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.ROrderDao;
import rtf.rshop.dao.impl.ROrderDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.ROrder;
import rtf.rshop.po.RUser;

public class OrderCancelLogic extends RLogicAction {
	private int order_id ;
	
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "用户未登录");
			return;
		}
		ROrderDao orderDao = new ROrderDaoImpl();
		ROrder order = orderDao.getOrderById(order_id);
		if(order.getUser().getId() != user.getId()){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "用户没有操作该订单的权限");
			return ;
		}
		
		if(!order.getStatus().equals("U")){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "该订单不能取消");
			return ;
		}
		order.setStatus("C");
		orderDao.updateOrder(order);
		putResponseProperty("result", "success");
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

}

package rtf.rshop.logic.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RAddressInfoDao;
import rtf.rshop.dao.RCartDao;
import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.dao.impl.RCartDaoImpl;
import rtf.rshop.dao.impl.ROrderDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RCartItem;
import rtf.rshop.po.ROrder;
import rtf.rshop.po.ROrderItem;
import rtf.rshop.po.RUser;

public class OrderSubmitLogic extends RLogicAction{
	private int address_index ;
	
	public int getAddress_index() {
		return address_index;
	}

	public void setAddress_index(int address_index) {
		this.address_index = address_index;
	}

	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		RUser user = (RUser) sessionMap.getOrDefault("login_user",null);
		if( user == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "用户未登录");
			return ;
		}
		
		RAddressInfoDao addressDao = new RAddressInfoDaoImpl();
		List<RAddressInfo> address_list = addressDao.getAddressInfoByUser(user) ;
		if(address_index >= address_list.size() || address_index < 0 ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "地址不正确");
			return ;
		}
		ROrder order = new ROrder() ;
		RAddressInfo address_info = address_list.get(address_index) ;//地址信息
		order.setUser(user);
		order.setAddress(address_info);
		
		RCartDao cartDao = new RCartDaoImpl() ;
		RCart cart = cartDao.getCart(user);
		List<ROrderItem> orderitem_list = new ArrayList<ROrderItem>();
		double total_money = 0 ;
		for(RCartItem cart_item :cart.getItems() ){
			total_money = total_money + cart_item.getProduct().getPrice() * cart_item.getQuantity() ;
			ROrderItem orderitem = new ROrderItem();
			orderitem.setProduct(cart_item.getProduct());
			orderitem.setQuantity(cart_item.getQuantity());
			orderitem.setOrder(order);
			orderitem_list.add(orderitem);
		}
		order.setOrderitems(orderitem_list);
		order.setMoney(total_money);
		order.setStatus("U");
		order.setCreate_time(new Date());
		new ROrderDaoImpl().addOrder(order);
		putResponseProperty("result", "success");
		return ;
	}

}

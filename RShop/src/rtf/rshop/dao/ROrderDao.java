package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.ROrder;
import rtf.rshop.po.RUser;

public interface ROrderDao {
	public void addOrder(ROrder order);
	public List<ROrder> getOrderByUser(RUser user) ;
	public ROrder getOrderById(int id);
	public void updateOrder(ROrder order);
	public void cancelOrder(ROrder order);
}

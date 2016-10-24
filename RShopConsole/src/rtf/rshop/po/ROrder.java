package rtf.rshop.po;

import java.util.Date;
import java.util.List;

public class ROrder {
	private int id ;
	private RUser user ;
	private List<ROrderItem> orderitems ;
	private RAddressInfo address;
	private double money ;
	private String status ;
	private Date create_time ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<ROrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<ROrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	public RAddressInfo getAddress() {
		return address;
	}
	public void setAddress(RAddressInfo address) {
		this.address = address;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public RUser getUser() {
		return user;
	}
	public void setUser(RUser user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}

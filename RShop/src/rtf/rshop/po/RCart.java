package rtf.rshop.po;

import java.util.List;

public class RCart {
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RUser getUser() {
		return user;
	}
	public void setUser(RUser user) {
		this.user = user;
	}
	public List<RCartItem> getItems() {
		return items;
	}
	public void setItems(List<RCartItem> items) {
		this.items = items;
	}
	private RUser user ;
	private List<RCartItem> items ;
}

package rtf.rshop.po;

import java.util.Date;

public class RCartItem {
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RCart getCart() {
		return cart;
	}
	public void setCart(RCart cart) {
		this.cart = cart;
	}
	public RProduct getProduct() {
		return product;
	}
	public void setProduct(RProduct product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	private RCart cart ;
	private RProduct product ;
	private int quantity ;
	private Date create_time ;
}

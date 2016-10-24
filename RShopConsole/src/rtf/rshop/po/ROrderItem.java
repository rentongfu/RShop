package rtf.rshop.po;

public class ROrderItem {
	private int id ;
	private ROrder order;
	private RProduct product ;
	private int quantity ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ROrder getOrder() {
		return order;
	}
	public void setOrder(ROrder order) {
		this.order = order;
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
}

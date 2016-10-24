package rtf.rshop.po;

public class RProductParameter {
	private int id ;
	private RProduct product ;
	private String key ;
	public RProduct getProduct() {
		return product;
	}
	public void setProduct(RProduct product) {
		this.product = product;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String value ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

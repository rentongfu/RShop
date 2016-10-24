package rtf.rshop.po;

public class RProType {
	private int id ;
	private String code ;
	private String name ;
	private RProType parent ;
	private String describe ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RProType getParent() {
		return parent;
	}
	public void setParent(RProType parent) {
		this.parent = parent;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}

package rtf.rshop.po;

import java.util.List;

public class RAdvertisement {
	private int id ;
	private String name ;
	private String code ;
	private List<RAdvertisementItem> items ;
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<RAdvertisementItem> getItems() {
		return items;
	}
	public void setItems(List<RAdvertisementItem> items) {
		this.items = items;
	}

}

package rtf.rshop.po;

public class RAddressInfo {
	private int id ;
	private RUser user ;
	private String receiver_name ;
	private String phone_num ;
	private RDistrict district ;
	private String describe ;
	private boolean isdelete = false ;
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
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public RDistrict getDistrict() {
		return district;
	}
	public void setDistrict(RDistrict district) {
		this.district = district;
	}
	public boolean isIsdelete() {
		return isdelete;
	}
	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}

	
}

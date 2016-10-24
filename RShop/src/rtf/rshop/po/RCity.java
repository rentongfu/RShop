package rtf.rshop.po;

import java.util.List;

public class RCity {
	private int id ;
	private String code ;
	private String name ;
	private RProvince province ;
	private List<RDistrict> districts ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RProvince getProvince() {
		return province;
	}
	public void setProvince(RProvince province) {
		this.province = province;
	}
	public List<RDistrict> getDistricts() {
		return districts;
	}
	public void setDistricts(List<RDistrict> districts) {
		this.districts = districts;
	}

}

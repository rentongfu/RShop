package rtf.rshop.po;

import java.util.List;

public class RProvince {
	private int id ;
	private String code ;
	private String name ;
	private List<RCity> cities ;
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
	public List<RCity> getCities() {
		return cities;
	}
	public void setCities(List<RCity> cities) {
		this.cities = cities;
	}
}

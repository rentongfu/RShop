package rtf.rshop.view;

import java.util.List;

import rtf.rshop.dao.impl.RProvinceDaoImpl;
import rtf.rshop.po.RProvince;

public class AddressAddFrame {
	private List<RProvince> province_list;
	public String execute(){
		setProvince_list(new RProvinceDaoImpl().getAllProvince());
		return "success" ;
	}
	public List<RProvince> getProvince_list() {
		return province_list;
	}
	public void setProvince_list(List<RProvince> province_list) {
		this.province_list = province_list;
	}
}

package rtf.rshop.view;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.dao.impl.RCityDaoImpl;
import rtf.rshop.dao.impl.RDistrictDaoImpl;
import rtf.rshop.dao.impl.RProvinceDaoImpl;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RDistrict;
import rtf.rshop.po.RProvince;
import rtf.rshop.po.RUser;

public class AddressUpdateFrame {
	private int addressinfo_id ;
	private RAddressInfo addressinfo;
	private List<RProvince> province_list;
	private List<RCity> city_list ;
	private List<RDistrict> district_list ;
	public String execute(){
		addressinfo = new RAddressInfoDaoImpl().getAddressInfoById(addressinfo_id);
		
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null || user.getId() != addressinfo.getUser().getId()){
			return "error";
		}
		
		setProvince_list(new RProvinceDaoImpl().getAllProvince());
		if(addressinfo.getDistrict() == null){
			city_list = new ArrayList<RCity>();
			district_list = new ArrayList<RDistrict>();
		}else{
			city_list = new RCityDaoImpl().getCityList(addressinfo.getDistrict().getCity().getProvince());
			district_list = new RDistrictDaoImpl().getDistrictList(addressinfo.getDistrict().getCity());
			
		}
		return "success";
	}
	public int getAddressinfo_id() {
		return addressinfo_id;
	}
	public void setAddressinfo_id(int addressinfo_id) {
		this.addressinfo_id = addressinfo_id;
	}
	public RAddressInfo getAddressinfo() {
		return addressinfo;
	}
	public void setAddressinfo(RAddressInfo addressinfo) {
		this.addressinfo = addressinfo;
	}
	public List<RProvince> getProvince_list() {
		return province_list;
	}
	public void setProvince_list(List<RProvince> province_list) {
		this.province_list = province_list;
	}
	public List<RCity> getCity_list() {
		return city_list;
	}
	public void setCity_list(List<RCity> city_list) {
		this.city_list = city_list;
	}
	public List<RDistrict> getDistrict_list() {
		return district_list;
	}
	public void setDistrict_list(List<RDistrict> district_list) {
		this.district_list = district_list;
	}
}

package rtf.rshop.logic.user;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RAddressInfoDao;
import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.dao.impl.RDistrictDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RDistrict;
import rtf.rshop.po.RUser;

public class UpdateAddressInfoLogic extends RLogicAction {
	private int addressinfo_id ;
	private String receiver_name = "";
	private String phone_num = "";
	private String describe = "";
	public int getAddressinfo_id() {
		return addressinfo_id;
	}
	public void setAddressinfo_id(int addressinfo_id) {
		this.addressinfo_id = addressinfo_id;
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
	public String getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}
	private String district_code ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "用户未登陆");
			return ;
		}
		
		RAddressInfoDao addressinfoDao = new RAddressInfoDaoImpl() ;
		RAddressInfo oldaddressinfo = addressinfoDao.getAddressInfoById(addressinfo_id);
		if(oldaddressinfo == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "参数不合法");
			return;
		}
		
		if(user.getId() != oldaddressinfo.getUser().getId()){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "非法操作");
			return;
		}
		
		RDistrict district  = new RDistrictDaoImpl().getDistrictByCode(district_code);
		if(district == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "地址信息不合法");
			return ;
		}
		RAddressInfo newaddressinfo = new RAddressInfo();
		newaddressinfo.setUser(oldaddressinfo.getUser());
		newaddressinfo.setDescribe(describe);
		newaddressinfo.setPhone_num(phone_num);
		newaddressinfo.setReceiver_name(receiver_name);
		newaddressinfo.setDistrict(district);
		
		addressinfoDao.updateAddressInfo(newaddressinfo, oldaddressinfo);
		
		putResponseProperty("result", "success");
		
		
	}

}

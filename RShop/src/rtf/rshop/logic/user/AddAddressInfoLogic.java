package rtf.rshop.logic.user;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.dao.impl.RDistrictDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RDistrict;
import rtf.rshop.po.RUser;

public class AddAddressInfoLogic extends RLogicAction {
	private String receiver_name = "";
	private String phone_num = "";
	private String describe = "";
	private String district_code ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		if(!checkParameter()){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "参数不合法");
			return ;
		}
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null);
		if( user == null ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "用户未登陆");
			return ;
		}
		RAddressInfo address_info = new RAddressInfo();
		address_info.setReceiver_name(receiver_name);
		RDistrict district  = new RDistrictDaoImpl().getDistrictByCode(district_code);
		if(district == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "地址信息不合法");
			return ;
		}
		address_info.setDistrict(district);
		address_info.setDescribe(describe);
		address_info.setPhone_num(phone_num);
		address_info.setUser(user);
		new RAddressInfoDaoImpl().addAddressInfo(address_info);
		putResponseProperty("result", "success");
		
	}
	private boolean checkParameter(){
		return true ;
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

}

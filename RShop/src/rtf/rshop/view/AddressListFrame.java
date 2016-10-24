package rtf.rshop.view;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RUser;

public class AddressListFrame {
	private List<RAddressInfo> addressinfo_list ;
	public String execute(){
		RUser user = (RUser) ActionContext.getContext().getSession().getOrDefault("login_user", null) ;
		if( user == null ){
			return "error" ;
		}
		addressinfo_list = new RAddressInfoDaoImpl().getAddressInfoByUser(user);
		return "success" ;
	}
	public List<RAddressInfo> getAddressinfo_list() {
		return addressinfo_list;
	}
	public void setAddressinfo_list(List<RAddressInfo> addressinfo_list) {
		this.addressinfo_list = addressinfo_list;
	}
	
}

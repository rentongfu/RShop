package rtf.rshop.logic.user;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RAddressInfoDao;
import rtf.rshop.dao.impl.RAddressInfoDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RUser;

public class DeleteAddressInfoLogic extends RLogicAction {
	private int addressinfo_id ;
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
		RAddressInfo addressinfo = addressinfoDao.getAddressInfoById(addressinfo_id);
		if(addressinfo == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "参数不合法");
			return;
		}
		
		if(user.getId() != addressinfo.getUser().getId()){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "非法操作");
			return;
		}
		
		addressinfoDao.deleteAddressInfo(addressinfo);
		putResponseProperty("result", "success");
		return;
	}
	public int getAddressinfo_id() {
		return addressinfo_id;
	}
	public void setAddressinfo_id(int addressinfo_id) {
		this.addressinfo_id = addressinfo_id;
	}
	

}

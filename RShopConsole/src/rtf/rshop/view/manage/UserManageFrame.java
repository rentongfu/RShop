package rtf.rshop.view.manage;

import java.util.List;

import rtf.rshop.dao.RUserDao;
import rtf.rshop.dao.impl.RUserDaoImpl;
import rtf.rshop.po.RUser;

public class UserManageFrame {
	private List<RUser> userlist ;
	
	public String execute(){
		RUserDao userDao = new RUserDaoImpl();
		userlist = userDao.getAllUser();
		
		return "success";
	}

	/**
	 * @return the userlist
	 */
	public List<RUser> getUserlist() {
		return userlist;
	}

	/**
	 * @param userlist the userlist to set
	 */
	public void setUserlist(List<RUser> userlist) {
		this.userlist = userlist;
	}
}

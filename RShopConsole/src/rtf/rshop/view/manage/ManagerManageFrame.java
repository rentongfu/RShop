package rtf.rshop.view.manage;

import java.util.List;

import rtf.rshop.dao.RManagerDao;
import rtf.rshop.dao.impl.RManagerDaoImpl;
import rtf.rshop.po.RManager;

public class ManagerManageFrame {
	private List<RManager> managerlist ;
	public String execute(){
		RManagerDao managerDao = new RManagerDaoImpl();
		managerlist = managerDao.getAllManager();
		
		return "success";
	}

	/**
	 * @return the managerlist
	 */
	public List<RManager> getManagerlist() {
		return managerlist;
	}

	/**
	 * @param managerlist the managerlist to set
	 */
	public void setManagerlist(List<RManager> managerlist) {
		this.managerlist = managerlist;
	}
}

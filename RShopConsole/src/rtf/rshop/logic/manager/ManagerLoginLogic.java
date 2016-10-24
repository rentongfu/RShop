package rtf.rshop.logic.manager;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;
import rtf.rshop.dao.RManagerDao;
import rtf.rshop.dao.impl.RManagerDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RManager;

public class ManagerLoginLogic extends RLogicAction{
	
	private String loginname ;
	private String password ;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String,String>() ;
		map.put("a", "11");
		JSONObject json = JSONObject.fromObject(map) ;
	}
	public void performExecute(){
		System.out.println("loginname:" + loginname);
		System.out.println("password:" + password);
		RManager manager = new RManager();
		manager.setLoginname(loginname);
		manager.setPassword(password);
		RManagerDao managerDao = new RManagerDaoImpl();
		if(managerDao.checkPassword(manager)){
			
			ActionContext context = ActionContext.getContext() ;
			Map<String, Object> sessionMap = context.getSession(); 
			sessionMap.put("manager_loginname", loginname);
			putResponseProperty("result", "success");
		}else{
			putResponseProperty("result", "failed");
		}
		
	}
	/**
	 * @return the loginname
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * @param loginname the loginname to set
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}

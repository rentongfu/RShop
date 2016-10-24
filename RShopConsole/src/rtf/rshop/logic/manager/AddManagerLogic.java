package rtf.rshop.logic.manager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RManagerDao;
import rtf.rshop.dao.impl.RManagerDaoImpl;
import rtf.rshop.po.RManager;

public class AddManagerLogic {
	private String loginname ;
	private String password ;
	private InputStream result ;
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
	public String execute() throws UnsupportedEncodingException{
		//进行用户权限检查
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> sessionMap = ctx.getSession();
		if(!sessionMap.containsKey("manager_loginname") ){
			result = new ByteArrayInputStream("error".getBytes("UTF-8")) ;
			return "success" ;
		}
		
		if( ( loginname == null) || (loginname.equals("") )) {
			result = new ByteArrayInputStream("error".getBytes("UTF-8")) ;
			return "success" ;
		}
		if( ( password == null) || (password.equals(""))){
			result = new ByteArrayInputStream("error".getBytes("UTF-8")) ;
			return "success" ;
		}
		RManager manager = new RManager() ;
		manager.setLoginname(loginname);
		manager.setPassword(password);
		
		RManagerDao managerDao = new RManagerDaoImpl();
		if ( managerDao.addManager(manager)){
			result = new ByteArrayInputStream("success".getBytes("UTF-8")) ;
			return "success" ;
		}
		result = new ByteArrayInputStream("fail".getBytes("UTF-8")) ;
		return "success" ;
		
	}
	/**
	 * @return the result
	 */
	public InputStream getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(InputStream result) {
		this.result = result;
	}
}

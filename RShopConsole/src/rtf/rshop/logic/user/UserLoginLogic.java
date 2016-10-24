package rtf.rshop.logic.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RUserDao;
import rtf.rshop.dao.impl.RUserDaoImpl;
import rtf.rshop.po.RUser;

public class UserLoginLogic {
	private String loginname = ""  ;
	private String password ="" ;
	private InputStream result ;
	public String execute(){
		if( loginname.equals("")||password.equals("") ){
			result = new ByteArrayInputStream("loginname or password is empty".getBytes(Charset.forName("UTF-8")));
			return "success" ;
		}
		RUser user = new RUser();
		user.setLoginname(loginname);
		user.setPassword(password) ;
		RUserDao userDao = new RUserDaoImpl();
		user = userDao.checkPassword(user);
		if( user == null){
			result = new ByteArrayInputStream("loginname or password error".getBytes(Charset.forName("UTF-8")));
			return "success" ;
		}
		
		ActionContext.getContext().getSession().put("login_user", user) ;
		result = new ByteArrayInputStream("success".getBytes(Charset.forName("UTF-8")));
		return "success";
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public InputStream getResult() {
		return result;
	}
	public void setResult(InputStream result) {
		this.result = result;
	}

}

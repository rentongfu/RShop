package rtf.rshop.logic.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import rtf.rshop.dao.RUserDao;
import rtf.rshop.dao.impl.RUserDaoImpl;
import rtf.rshop.po.RUser;

public class UserRegisterLogic {
	private String loginname = "" ;
	private String password = "" ;
	private InputStream result ;
	
	public String execute(){
		if( loginname.isEmpty() || password.isEmpty()){
			result = new ByteArrayInputStream("loginname or password is empty".getBytes(Charset.forName("UTF-8")));
			return "success" ;
		}
		RUser user = new RUser() ;
		user.setLoginname(loginname);
		user.setPassword(password);
		RUserDao userDao = new RUserDaoImpl();
		if(userDao.addUser(user)){
			result = new ByteArrayInputStream("success".getBytes(Charset.forName("UTF-8")));
		}else{
			result = new ByteArrayInputStream("register failed".getBytes(Charset.forName("UTF-8")));
		}
		return "success" ;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public InputStream getResult() {
		return result;
	}

	public void setResult(InputStream result) {
		this.result = result;
	}
}

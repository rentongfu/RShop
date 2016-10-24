package rtf.rshop.logic.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RUserDao;
import rtf.rshop.dao.impl.RUserDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RUser;

public class UserLoginLogic extends RLogicAction{
	private String loginname = ""  ;
	private String password ="" ;
	
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

	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		if( loginname.equals("")||password.equals("") ){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "输入信息不合法");
			return;
		}
		RUser user = new RUser();
		user.setLoginname(loginname);
		user.setPassword(password) ;
		RUserDao userDao = new RUserDaoImpl();
		user = userDao.checkPassword(user);
		if( user == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "用户或密码错误");
			return;
		}
		
		ActionContext.getContext().getSession().put("login_user", user) ;
		putResponseProperty("result", "success");
	}

}

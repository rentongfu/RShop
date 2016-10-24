package rtf.rshop.logic.user;

import rtf.rshop.dao.RUserDao;
import rtf.rshop.dao.impl.RUserDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RUser;

public class UserRegisterLogic extends RLogicAction{
	private String loginname = "" ;
	private String password = "" ;


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



	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		if( loginname.isEmpty() || password.isEmpty()){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "输入信息不合法");
			return;
		}
		RUser user = new RUser() ;
		user.setLoginname(loginname);
		user.setPassword(password);
		RUserDao userDao = new RUserDaoImpl();
		if(userDao.addUser(user)){
			putResponseProperty("result", "success");	
		}else{
			putResponseProperty("result", "fail");
			putResponseProperty("error", "注册失败");
		}
	}
}

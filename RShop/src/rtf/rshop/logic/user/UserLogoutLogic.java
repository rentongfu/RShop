package rtf.rshop.logic.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.logic.RLogicAction;

public class UserLogoutLogic extends RLogicAction{
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		ActionContext.getContext().getSession().put("login_user", null);
		ActionContext.getContext().getSession().put("cart", null);
		putResponseProperty("result", "success");
		
	}
}

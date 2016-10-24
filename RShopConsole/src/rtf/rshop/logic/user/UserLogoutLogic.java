package rtf.rshop.logic.user;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.opensymphony.xwork2.ActionContext;

public class UserLogoutLogic {
	private InputStream result ;
	public String execute(){
		ActionContext.getContext().getSession().put("login_user", null);
		result = new ByteArrayInputStream("success".getBytes(Charset.forName("UTF-8")));
		return "success";
	}
	public InputStream getResult() {
		return result;
	}
	public void setResult(InputStream result) {
		this.result = result;
	}
}

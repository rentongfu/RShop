package rtf.rshop.view.manage;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ManageView implements Action {
	private String loginname ;
	public String getLoginname(){
		return loginname ;
	}
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> sessionMap = ctx.getSession();
		if(sessionMap.containsKey("manager_loginname")){
			loginname = (String) sessionMap.get("manager_loginname") ;
			return "success" ;
		}else{
		System.out.println("asdsad");
		return "error" ;

		}
	}
}

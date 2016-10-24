package rtf.rshop.logic.product;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RProType;

public class AddProTypeLogic extends RLogicAction{
	
	private String parent_code="" ;
	private String protype_name="" ;
	private String protype_code = "" ;
	private String protype_desc ="";

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getProtype_code() {
		return protype_code;
	}

	public void setProtype_code(String protype_code) {
		this.protype_code = protype_code;
	}

	public String getProtype_name() {
		return protype_name;
	}
	public void setProtype_name(String protype_name) {
		this.protype_name = protype_name;
	}

	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		//用户权限检查
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> sessionMap = ctx.getSession();
		if(!sessionMap.containsKey("manager_loginname") ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "用户没有权限");
			return ;
		}
		System.out.println("sdfssssssssssssss------------");
		System.out.println(protype_name);
		System.out.println(protype_code);
		System.out.println(parent_code);
		System.out.println(protype_desc);
		//输入信息格式检查
		if(!valideParameter()){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "无效输入");
			return ;
		}
		RProTypeDao protypeDao = new RProTypeDaoImpl();
		RProType parent = protypeDao.getProTypeByCode(parent_code) ;
		if( parent == null ){
			putResponseProperty("status", "failed");
			putResponseProperty("error", "非法的父节点code");
			return;
		}
		RProType protype = new RProType();
		protype.setCode(protype_code);
		protype.setName(protype_name);
		protype.setDescribe(protype_desc);
		protype.setParent(parent);
		try{
			protypeDao.addProType(protype);
		}catch(ConstraintViolationException e){
			
		}
		putResponseProperty("status", "success");
	}

	public String getProtype_desc() {
		return protype_desc;
	}

	public void setProtype_desc(String protype_desc) {
		this.protype_desc = protype_desc;
	}

	private boolean valideParameter() {
		// TODO Auto-generated method stub
		if(parent_code.isEmpty()||protype_code.isEmpty()||protype_name.isEmpty()){
			return false ;
		}
		return true ;
	}
}

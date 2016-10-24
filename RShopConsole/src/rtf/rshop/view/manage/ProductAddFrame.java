package rtf.rshop.view.manage;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.po.RProType;

public class ProductAddFrame {
	RProType[] base_protypes ;
	public String execute(){
		//清楚session中的相关信息
		Map<String,Object> sessionData = ActionContext.getContext().getSession();
		sessionData.put("add_product_desc_images", null);
		sessionData.put("add_product_images", null);
		ActionContext.getContext().setSession(sessionData);
		
		RProTypeDao protypeDao = new RProTypeDaoImpl();
		RProType root_protype = protypeDao.getProTypeByCode("all");
		base_protypes = protypeDao.getProTypesByParent(root_protype);
		return "success";
	}
	public RProType[] getBase_protypes() {
		return base_protypes;
	}
	public void setBase_protypes(RProType[] base_protypes) {
		this.base_protypes = base_protypes;
	}

	

	
}

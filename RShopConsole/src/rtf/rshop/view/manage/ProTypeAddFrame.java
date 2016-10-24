package rtf.rshop.view.manage;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.po.RProType;

public class ProTypeAddFrame {
	private RProType[] base_protypes ;
	public String execute(){
		RProTypeDao protypeDao = new RProTypeDaoImpl() ;
		RProType root_protype = protypeDao.getProTypeByCode("all");
		setBase_protypes(protypeDao.getProTypesByParent(root_protype));
		return "success" ;
	}
	public RProType[] getBase_protypes() {
		return base_protypes;
	}
	public void setBase_protypes(RProType[] base_protypes) {
		this.base_protypes = base_protypes;
	}
}

package rtf.rshop.logic.product;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RProType;

public class GetProtypesByParentLogic extends RLogicAction {
	private String parent_code ;
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	@Override
	public void performExecute() {
		System.out.println("获取到的parent_code参数为："+ parent_code);
		// TODO Auto-generated method stub
		RProTypeDao protypeDao = new RProTypeDaoImpl() ;
		RProType parent_protype = protypeDao.getProTypeByCode(parent_code);
		RProType[] prtypes = protypeDao.getProTypesByParent(parent_protype) ;
		putResponseProperty("status", "success");
		putResponseProperty("result", prtypes);
		return ;
	}

}

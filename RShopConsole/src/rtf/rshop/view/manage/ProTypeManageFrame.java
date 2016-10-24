package rtf.rshop.view.manage;

import java.util.List;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.dao.impl.RProTypeDaoImpl;
import rtf.rshop.po.RProType;

public class ProTypeManageFrame {
	private List<RProType> protype_list ;

	public String execute(){
		RProTypeDao protypeDao = new RProTypeDaoImpl();
		setProtype_list(protypeDao.getAllProType());
		
		for( RProType protype :getProtype_list() ){
			System.out.println(protype.getName());
		}
		
		return "success" ;
	}
	public List<RProType> getProtype_list() {
		return protype_list;
	}
	public void setProtype_list(List<RProType> protype_list) {
		this.protype_list = protype_list;
	}

}

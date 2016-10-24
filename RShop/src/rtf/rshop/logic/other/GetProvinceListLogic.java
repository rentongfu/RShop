package rtf.rshop.logic.other;

import java.util.List;

import rtf.rshop.dao.impl.RProvinceDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RProvince;

public class GetProvinceListLogic extends RLogicAction {

	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		List<RProvince> province_list = new RProvinceDaoImpl().getAllProvince();
		for(RProvince province : province_list){
			province.setCities(null);
		}
		putResponseProperty("result", "success");
		putResponseProperty("province_list", province_list);
	}

}

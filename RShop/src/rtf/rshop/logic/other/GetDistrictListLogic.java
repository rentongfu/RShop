package rtf.rshop.logic.other;

import java.util.List;

import rtf.rshop.dao.impl.RCityDaoImpl;
import rtf.rshop.dao.impl.RDistrictDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RDistrict;

public class GetDistrictListLogic extends RLogicAction {
	private String city_code ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		RCity city = new RCityDaoImpl().getCityByCode(city_code);
		if( city == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "city_code´íÎó");
			return;
		}
		List<RDistrict> district_list = new RDistrictDaoImpl().getDistrictList(city);
		for(RDistrict district:district_list){
			district.setCity(null);
			
		}
		putResponseProperty("result", "success");
		putResponseProperty("district_list", district_list);
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

}

package rtf.rshop.logic.other;

import java.util.List;

import rtf.rshop.dao.impl.RCityDaoImpl;
import rtf.rshop.dao.impl.RProvinceDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RProvince;

public class GetCityListLogic extends RLogicAction{
	private String province_code;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		RProvince province = new RProvinceDaoImpl().getProvinceByCode(province_code);
		if(province == null){
			putResponseProperty("result", "fail");
			putResponseProperty("error", "product_code´íÎó");
			return ;
		}
		
		List<RCity> city_list = new RCityDaoImpl().getCityList(province);
		for(RCity city:city_list){
			city.setDistricts(null);
			city.setProvince(null);
		}
		putResponseProperty("result", "success");
		putResponseProperty("city_list", city_list);
	}
	public String getProvince_code() {
		return province_code;
	}
	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

}

package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RCity;
import rtf.rshop.po.RProvince;

public interface RCityDao {
	public List<RCity> getCityList(RProvince province);
	public RCity getCityByCode(String code);
}

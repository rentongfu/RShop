package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RCity;
import rtf.rshop.po.RDistrict;

public interface RDistrictDao {
	public List<RDistrict> getDistrictList(RCity city);
	public RDistrict getDistrictByCode(String code);
}

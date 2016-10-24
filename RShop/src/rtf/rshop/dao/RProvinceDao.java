package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RProvince;

public interface RProvinceDao {
	public List<RProvince> getAllProvince();
	public RProvince getProvinceByCode(String code);
}

package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RUser;

public interface RAddressInfoDao {
	public void addAddressInfo(RAddressInfo address_info);
	public List<RAddressInfo> getAddressInfoByUser(RUser user);
	public void deleteAddressInfo(RAddressInfo addressinfo);
	public RAddressInfo getAddressInfoById(int id);
	public void updateAddressInfo(RAddressInfo addressinfo,RAddressInfo oldaddressinfo);
}
 
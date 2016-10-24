package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RAdvertisement;

public interface RAdvertisementDao {
	
	/**
	 * ���advertisement�����ݿ�
	 * @param advertisement
	 * @return
	 */
	public void  addAdvertisement(RAdvertisement advertisement);
	public RAdvertisement getAdvertisementByName(String name) ;
	public List<RAdvertisement> getAllAdvertisement();		
}

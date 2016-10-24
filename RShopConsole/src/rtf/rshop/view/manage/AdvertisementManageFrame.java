package rtf.rshop.view.manage;

import java.util.List;

import rtf.rshop.dao.impl.RAdvertisementDaoImpl;
import rtf.rshop.po.RAdvertisement;

public class AdvertisementManageFrame {
	private List<RAdvertisement> advertisement_list ;
	public String execute(){
		advertisement_list = new RAdvertisementDaoImpl().getAllAdvertisement();
		return"success";
	}
	public List<RAdvertisement> getAdvertisement_list() {
		return advertisement_list;
	}
	public void setAdvertisement_list(List<RAdvertisement> advertisement_list) {
		this.advertisement_list = advertisement_list;
	}
}

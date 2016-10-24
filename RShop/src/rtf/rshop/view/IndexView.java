package rtf.rshop.view;

import java.util.List;

import rtf.rshop.dao.RAdvertisementDao;
import rtf.rshop.dao.impl.RAdvertisementDaoImpl;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.po.RAdvertisement;
import rtf.rshop.po.RProduct;

public class IndexView {
	private RAdvertisement index_image_adv ;
	private RAdvertisement recommend_game_adv ;
	private RAdvertisement recommend_computer_adv ;
	private RAdvertisement recommend_phone_adv ;
	private List<RProduct> all_product;
	public String execute(){
		
		RAdvertisementDao advDao = new RAdvertisementDaoImpl();
		setIndex_image_adv(advDao.getAdvertisementByCode("IndexImageAdv"));
		recommend_computer_adv  = advDao.getAdvertisementByCode("RecommendComputerAdv");
		recommend_game_adv = advDao.getAdvertisementByCode("RecommendGameAdv");
		recommend_phone_adv = advDao.getAdvertisementByCode("RecommendPhoneAdv");
		setAll_product(new RProductDaoImpl().getAllProduct());
		return "success";
	}
	public RAdvertisement getIndex_image_adv() {
		return index_image_adv;
	}
	public void setIndex_image_adv(RAdvertisement index_image_adv) {
		this.index_image_adv = index_image_adv;
	}
	public RAdvertisement getRecommend_game_adv() {
		return recommend_game_adv;
	}
	public void setRecommend_game_adv(RAdvertisement recommend_game_adv) {
		this.recommend_game_adv = recommend_game_adv;
	}
	public RAdvertisement getRecommend_computer_adv() {
		return recommend_computer_adv;
	}
	public void setRecommend_computer_adv(RAdvertisement recommend_computer_adv) {
		this.recommend_computer_adv = recommend_computer_adv;
	}
	public RAdvertisement getRecommend_phone_adv() {
		return recommend_phone_adv;
	}
	public void setRecommend_phone_adv(RAdvertisement recommend_phone_adv) {
		this.recommend_phone_adv = recommend_phone_adv;
	}
	public List<RProduct> getAll_product() {
		return all_product;
	}
	public void setAll_product(List<RProduct> all_product) {
		this.all_product = all_product;
	}
}

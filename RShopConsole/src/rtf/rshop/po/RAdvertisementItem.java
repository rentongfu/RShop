package rtf.rshop.po;

public class RAdvertisementItem {
	private int id ;
	private RProduct product ;
	private String image ;
	private RAdvertisement advertisement ;
	public RProduct getProduct() {
		return product;
	}
	public void setProduct(RProduct product) {
		this.product = product;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RAdvertisement getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(RAdvertisement advertisement) {
		this.advertisement = advertisement;
	}
}

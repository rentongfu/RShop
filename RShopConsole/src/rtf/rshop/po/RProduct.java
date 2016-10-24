package rtf.rshop.po;

import java.util.List;
import java.util.Map;

public class RProduct {
	private int id ;
	private String code ;
	private String name ;
	private double price ;
	private RProType type ;
	private String images ; 
	private String describe ;
	private String imagedescribe ;
	private List<RProductParameter> parameters ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public RProType getType() {
		return type;
	}
	public void setType(RProType type) {
		this.type = type;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public String getImagedescribe() {
		return imagedescribe;
	}
	public void setImagedescribe(String imagedescribe) {
		this.imagedescribe = imagedescribe;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<RProductParameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<RProductParameter> parameters) {
		this.parameters = parameters;
	}
	
}

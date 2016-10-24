package rtf.rshop.other;

public class GlobalParameter {
	/**
	 * 产品图片宽度
	 */
	private static  int product_image_width = 300 ;
	
	/**
	 * 产品图片高度
	 */
	private static  int product_image_height = 400 ;
	
	/**
	 * 产品描述图片宽度
	 */
	private static  int product_describe_image_width = 800 ;
	
	/**
	 * 产品描述图片高度
	 */
	private static  int product_describe_image_height = 600 ;

	/**
	 * 添加产品图片临时路径
	 */
	private static  String add_product_image_tmp_dir = "/tmp/image/add_product/" ;
	/**
	 * 产品图片最终路径
	 */
	private static  String product_image_base_dir ="/image/product/" ;
	
	/**
	 * 添加广告图片临时路径
	 */
	private static  String add_advertisement_image_tmp_dir = "/tmp/image/add_advertisement/" ;
	/**
	 * 广告图片最终路径
	 */
	private static  String advertisement_image_base_dir ="/image/advertisement/" ;
	
	/**
	 * 获取产品图片宽度
	 */
	public static int getProductImageWidth(){
		return product_image_width ;
	}
	
	/**
	 * 获取产品图片高度
	 */
	public static int getProductImageHeight(){
		return product_image_height ;
	}
	
	/**
	 * 获取产品描述图片宽度
	 */
	public static int getProductDescImageWidth(){
		return product_describe_image_width ;
	}
	
	/**
	 * 获取产品描述图片高度
	 */
	public static int getProductDescImageHeight(){
		return product_describe_image_height;
	}
	
	/**
	 * 获取添加产品时产品图片的临时存放路径
	 */
	public static String getAddProductImageTmpDir(){
		return add_product_image_tmp_dir ;
	}
	/**
	 * 获取产品图片存放路径
	 */
	public static String getProductImageBaseDir(){
		return product_image_base_dir ;
	}
	/**
	 * 获取添加广告时临时图片的路径
	 * @return
	 */
	public static String getAddAdvertisementImageTmpDir(){
		return add_advertisement_image_tmp_dir ;
	}
	/**
	 * 获取广告图片的存放路径
	 */
	public static String getAdvertisementImageBaseDir(){
		return advertisement_image_base_dir ;
	}
}

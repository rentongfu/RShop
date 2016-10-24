package rtf.rshop.other;

public class GlobalParameter {
	/**
	 * ��ƷͼƬ���
	 */
	private static  int product_image_width = 300 ;
	
	/**
	 * ��ƷͼƬ�߶�
	 */
	private static  int product_image_height = 400 ;
	
	/**
	 * ��Ʒ����ͼƬ���
	 */
	private static  int product_describe_image_width = 800 ;
	
	/**
	 * ��Ʒ����ͼƬ�߶�
	 */
	private static  int product_describe_image_height = 600 ;

	/**
	 * ��Ӳ�ƷͼƬ��ʱ·��
	 */
	private static  String add_product_image_tmp_dir = "/tmp/image/add_product/" ;
	/**
	 * ��ƷͼƬ����·��
	 */
	private static  String product_image_base_dir ="/image/product/" ;
	
	/**
	 * ��ӹ��ͼƬ��ʱ·��
	 */
	private static  String add_advertisement_image_tmp_dir = "/tmp/image/add_advertisement/" ;
	/**
	 * ���ͼƬ����·��
	 */
	private static  String advertisement_image_base_dir ="/image/advertisement/" ;
	
	/**
	 * ��ȡ��ƷͼƬ���
	 */
	public static int getProductImageWidth(){
		return product_image_width ;
	}
	
	/**
	 * ��ȡ��ƷͼƬ�߶�
	 */
	public static int getProductImageHeight(){
		return product_image_height ;
	}
	
	/**
	 * ��ȡ��Ʒ����ͼƬ���
	 */
	public static int getProductDescImageWidth(){
		return product_describe_image_width ;
	}
	
	/**
	 * ��ȡ��Ʒ����ͼƬ�߶�
	 */
	public static int getProductDescImageHeight(){
		return product_describe_image_height;
	}
	
	/**
	 * ��ȡ��Ӳ�Ʒʱ��ƷͼƬ����ʱ���·��
	 */
	public static String getAddProductImageTmpDir(){
		return add_product_image_tmp_dir ;
	}
	/**
	 * ��ȡ��ƷͼƬ���·��
	 */
	public static String getProductImageBaseDir(){
		return product_image_base_dir ;
	}
	/**
	 * ��ȡ��ӹ��ʱ��ʱͼƬ��·��
	 * @return
	 */
	public static String getAddAdvertisementImageTmpDir(){
		return add_advertisement_image_tmp_dir ;
	}
	/**
	 * ��ȡ���ͼƬ�Ĵ��·��
	 */
	public static String getAdvertisementImageBaseDir(){
		return advertisement_image_base_dir ;
	}
}

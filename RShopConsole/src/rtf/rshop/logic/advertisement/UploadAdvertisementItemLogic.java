package rtf.rshop.logic.advertisement;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.classfile.Code;

import rtf.rshop.dao.RAdvertisementDao;
import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.other.GlobalParameter;
import rtf.rshop.po.RAdvertisementItem;
import rtf.rshop.po.RProduct;
import rtf.rshop.util.FileUtil;

public class UploadAdvertisementItemLogic extends RLogicAction{
	/*
	 * ��ʱͼƬ���·��TMP_BASE/
	 */
	private File image ;
	private String imageFileName ;
	private String imageContentType ;
	private String product_code ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		
		ActionContext context = ActionContext.getContext() ;
		Map sessionMap = context.getSession();
		List<RAdvertisementItem> advertisement_items = (List<RAdvertisementItem>)sessionMap.get("add_advertisement_items");
		if( advertisement_items == null){
			advertisement_items = new LinkedList<RAdvertisementItem>();
		}
		if(productExisted(product_code, advertisement_items)){
			putResponseProperty("result", "failed");
			putResponseProperty("error", "Product�Ѵ���");
			return;
		}
		System.out.println(image.getAbsolutePath());
		imageFileName = getValidFileName(imageFileName, advertisement_items) ;
		try {
			FileUtil.fileCopy(image.getAbsolutePath(), getTmpDir(ServletActionContext.getRequest().getRequestedSessionId())+"/" + imageFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			putResponseProperty("result", "failed");
			putResponseProperty("error", "����ͼƬ����");
			e.printStackTrace();
			return ;
		}
		
		RProductDao productDao = new RProductDaoImpl();
		RProduct product = productDao.getProductByCode(product_code) ;
		if( product == null){
			putResponseProperty("result", "failed");
			putResponseProperty("error", "code ���Ϸ�");
			return ;
		}
		
		RAdvertisementItem item  = new RAdvertisementItem() ;
		
		
		
		item.setProduct(product); 
		item.setImage(imageFileName);
		
		
		//���浽session
		advertisement_items.add(item);
		sessionMap.put("add_advertisement_items", advertisement_items); //��ӳɹ������session
		
		putResponseProperty("result", "success");
		putResponseProperty("items", advertisement_items.toArray());
		
	}
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	/*
	 * ����imageFileName��ȡһ����items�в����ڵ�ͼƬ��
	 */
	private String getValidFileName(String imageFileName , List<RAdvertisementItem> items){
		String str= imageFileName ;
		while(true){
			if(!imageExisted(str, items)){
				break;
			}
			str = "x" + str ;
		}
		
		return str ;
		
	}
	
	/**
	 * �ж��ļ����Ƿ��������ļ����������������������true��
	 * @param imageFileName
	 * @param items
	 * @return
	 */
	private boolean imageExisted(String imageFileName ,  List<RAdvertisementItem> items){
		for(RAdvertisementItem item:items){
			if( imageFileName.equals(item.getImage())){
				return true ;
			}
		}
		return false ;
	}
	
	//��ȡ��ʱ�ļ����·��
	public static String getTmpDir(String sessionID ){
		return GlobalParameter.absoluteImageDir +"/tmp/" + sessionID +"/add_advertisement/" ;
	}
	
	/**
	 * ���code��items���Ѵ��ڣ�����true�����򷵻�false
	 * @param code
	 * @param items
	 * @return
	 */
	private boolean productExisted(String code ,List<RAdvertisementItem> items){
		for ( RAdvertisementItem item : items ){
			if( code.equals(item.getProduct().getCode() )){
				return true ;
			}
		}
		return false ;
	}
	
}

package rtf.rshop.logic.advertisement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RProductDao;
import rtf.rshop.dao.impl.RProductDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.po.RProduct;
import rtf.rshop.util.FileUtil;

public class ReceiveAdvertisementProductLogic extends RLogicAction{
	private File image ;
	private String imageFileName ;
	private String imageContentType ;
	
	private String product_code ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		//����¼״̬
		
		//���code�Ϸ���
		if( !checkProductCode() ){
			//code���Ϸ������ش�����Ϣ
			putResponseProperty("result", "failed");
			putResponseProperty("error", "code���Ϸ�");
			return ;
		}		
		//���code�Ϸ��򱣴�ͼƬ
		
		//д��session
		
	}
	
	/**
	 * ���product_code�Ƿ�Ϸ�������Ϸ��򷵻�true�����򷵻�false��
	 * @return
	 */
	private boolean checkProductCode(){
		RProductDao productDao = new RProductDaoImpl() ;
		RProduct product = productDao.getProductByCode(product_code);
		if( product == null ) {
			return false ;
		}else{
			return true ;
		}
	}
	
	private void copyImage(){
		
	}
	
}

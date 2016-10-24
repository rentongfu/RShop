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
		//检查登录状态
		
		//检查code合法性
		if( !checkProductCode() ){
			//code不合法，返回错误信息
			putResponseProperty("result", "failed");
			putResponseProperty("error", "code不合法");
			return ;
		}		
		//如果code合法则保存图片
		
		//写入session
		
	}
	
	/**
	 * 检查product_code是否合法，如果合法则返回true，否则返回false。
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

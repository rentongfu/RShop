/*
 * ˵�����ϴ��ɹ���ͼƬ������·��/tmp/image/add_product/desc/sessionID�¡�
 * ͬʱ����session��д��һ��LinkedList<String>���󱣴���Щ��Ϣ������Ϊ��add_product_desc_images��
 */
package rtf.rshop.logic.product;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.logic.RLogicAction;
import rtf.rshop.other.GlobalParameter;
import rtf.rshop.util.FileUtil;

public class UploadProductDescImageLogic extends RLogicAction{
	private File image ;
	private String imageFileName ;
	private String imageContentType ;
	
	
	
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



	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> sessionMap = ctx.getSession();
		if(!sessionMap.containsKey("manager_loginname") ){
			putResponseProperty("status", "failure");
			putResponseProperty("error", "manager didn't login");
			return ;
		}
		
		Map<String,Object> sessionData = ActionContext.getContext().getSession();
		@SuppressWarnings("unchecked")
		LinkedList<String> productDescImages = (LinkedList<String>) sessionData.get("add_product_desc_images");
		if( productDescImages == null){
			productDescImages = new LinkedList<String>();
		}
		renameFileName(imageFileName, productDescImages);
		
		//�����û�sessionid��ȡ��ʱĿ¼·��
		
		HttpServletRequest request = ServletActionContext.getRequest() ;
		String sessionID = request.getSession().getId() ;
		System.out.println("���û���sessionId�ǣ�" + sessionID);
		String tmpDir =  GlobalParameter.absoluteImageDir + "/tmp/image/add_product/desc/" + sessionID +"/"   ;
//				
		try {
			FileUtil.fileCopy(image.getAbsolutePath(), tmpDir+ imageFileName);
		} catch (IOException e) {
			e.printStackTrace();
			putResponseProperty("status", "failure");
			putResponseProperty("error", "i/o error");
			return ;
		}
		
		//�ٽ�д�뵽��ʱ�ļ������ļ���Ϣ������session��
		productDescImages.add(imageFileName);
		sessionData.put("add_product_desc_images", productDescImages);
		ActionContext.getContext().setSession(sessionData);
				
		
		//����ִ�н��
		putResponseProperty("status", "success");
		putResponseProperty("images", productDescImages);
		putResponseProperty("imageDir", GlobalParameter.visitImageDir + "/tmp/image/add_product/desc/" + sessionID+"/");
		
		
	}
	
	/**
	 * ������ͼƬ���ļ����Ա�֤��Ψһ��
	 * @param imageFileName
	 * @param productImages
	 */
	private void renameFileName(String imageFileName , LinkedList<String> productDescImages){
		if( productDescImages.contains(imageFileName)){
			setImageFileName("x"+ imageFileName);
			renameFileName(this.imageFileName, productDescImages);
		}
	}
	

}

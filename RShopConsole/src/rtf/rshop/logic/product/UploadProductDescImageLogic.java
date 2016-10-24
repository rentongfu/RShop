/*
 * 说明：上传成功的图片保存在路径/tmp/image/add_product/desc/sessionID下。
 * 同时会在session中写入一个LinkedList<String>对象保存这些信息，键名为：add_product_desc_images，
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
		
		//根据用户sessionid获取临时目录路径
		
		HttpServletRequest request = ServletActionContext.getRequest() ;
		String sessionID = request.getSession().getId() ;
		System.out.println("该用户的sessionId是：" + sessionID);
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
		
		//再将写入到临时文件区的文件信息保存在session中
		productDescImages.add(imageFileName);
		sessionData.put("add_product_desc_images", productDescImages);
		ActionContext.getContext().setSession(sessionData);
				
		
		//返回执行结果
		putResponseProperty("status", "success");
		putResponseProperty("images", productDescImages);
		putResponseProperty("imageDir", GlobalParameter.visitImageDir + "/tmp/image/add_product/desc/" + sessionID+"/");
		
		
	}
	
	/**
	 * 重命名图片的文件名以保证其唯一性
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

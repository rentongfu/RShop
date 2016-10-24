/*
 * 说明：上传成功的图片会先存储在/tmp/image/add_product/sessionID路径下
 * 同时会在session中写入一个LinkedList<String>对象保存这些信息，键名为：add_product_images，
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

public class UploadProductImageLogic extends RLogicAction  {
	private File image ;
	private String imageFileName ;
	private String imageContentType ;
	@Override
	public void performExecute() {
		System.out.println("获取到的image文件名为："+ imageFileName);
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		Map<String,Object> sessionMap = ctx.getSession();
		if(!sessionMap.containsKey("manager_loginname") ){
			putResponseProperty("status", "failure");
			putResponseProperty("error", "manager didn't login");
			return ;
		}
		

		//检查同名文件是否已上传
		Map<String,Object> sessionData = ActionContext.getContext().getSession();
		@SuppressWarnings("unchecked")
		LinkedList<String> productImages = (LinkedList<String>) sessionData.get("add_product_images");
		if( productImages == null){
			productImages = new LinkedList<String>();
		}
		renameFileName(imageFileName, productImages);
		
		
		
		//根据用户sessionid获取临时目录路径
		
		HttpServletRequest request = ServletActionContext.getRequest() ;
		String sessionID = request.getSession().getId() ;
		System.out.println("该用户的sessionId是：" + sessionID);
		String tmpDir =  GlobalParameter.absoluteImageDir + "/tmp/image/add_product/" + sessionID +"/"   ;
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
		productImages.add(imageFileName);
		sessionData.put("add_product_images", productImages);
		ActionContext.getContext().setSession(sessionData);
				
		
		//返回执行结果
		putResponseProperty("status", "success");
		//putResponseProperty("imageDir", GlobalParameter.visitImageDir + "/tmp/image/add_product/" + sessionID+"/" + imageFileName);
		putResponseProperty("images", productImages);
		putResponseProperty("imagesDir", GlobalParameter.visitImageDir + "/tmp/image/add_product/" + sessionID+"/");
	}
	

	/**
	 * 重命名图片的文件名以保证其唯一性
	 * @param imageFileName
	 * @param productImages
	 */
	private void renameFileName(String imageFileName , LinkedList<String> productImages){
		if( productImages.contains(imageFileName)){
			setImageFileName("x"+ imageFileName);
			renameFileName(this.imageFileName, productImages);
		}
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


}

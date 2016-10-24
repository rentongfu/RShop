package rtf.rshop.view.manage;

import org.apache.struts2.ServletActionContext;

public class AdvertisementProductUploadFrame {

	private String tmpImageDir ;
	private String baseTmpImageDir ;
	public String execute(){
		String sessionID = ServletActionContext.getRequest().getSession().getId();
		setTmpImageDir(getBaseTmpImageDir() + sessionID +"/") ;
		return "success" ;
	}
	
	public String getTmpImageDir() {
		return tmpImageDir;
	}
	public void setTmpImageDir(String tmpImageDir) {
		this.tmpImageDir = tmpImageDir;
	}
	public String getBaseTmpImageDir() {
		return baseTmpImageDir;
	}
	public void setBaseTmpImageDir(String baseTmpImageDir) {
		this.baseTmpImageDir = baseTmpImageDir;
	}
	
}

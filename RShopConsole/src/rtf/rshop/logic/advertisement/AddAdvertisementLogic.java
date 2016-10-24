package rtf.rshop.logic.advertisement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import rtf.rshop.dao.RAdvertisementDao;
import rtf.rshop.dao.impl.RAdvertisementDaoImpl;
import rtf.rshop.logic.RLogicAction;
import rtf.rshop.other.GlobalParameter;
import rtf.rshop.po.RAdvertisement;
import rtf.rshop.po.RAdvertisementItem;
import rtf.rshop.util.FileUtil;

public class AddAdvertisementLogic extends RLogicAction{
	private String advertisement_name ;
	private String advertisement_code ;
	private String advertisement_desc ;
	@Override
	public void performExecute() {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext() ;
		Map sessionMap = context.getSession();
		List<RAdvertisementItem> advertisement_items = (List<RAdvertisementItem>)sessionMap.get("add_advertisement_items");
		if( advertisement_items == null){
			advertisement_items = new LinkedList<RAdvertisementItem>();
		}
		sessionMap.put("add_advertisement_items",null);
		RAdvertisement advertisement = new RAdvertisement() ;
		advertisement.setCode(advertisement_code);
		advertisement.setItems(advertisement_items);
		advertisement.setName(advertisement_name);
		advertisement.setDescribe(advertisement_desc);
		
		String sessionID = ServletActionContext.getRequest().getRequestedSessionId();
		
		for (RAdvertisementItem item : advertisement_items ){
			item.setAdvertisement(advertisement);
			try {
				FileUtil.fileCopy(GlobalParameter.absoluteImageDir+"/tmp/"+sessionID+"/add_advertisement/"+item.getImage(), 
						GlobalParameter.absoluteImageDir+"/advertisement_image/" + advertisement.getCode() + "/"+item.getImage()
						);
			} catch (IOException e) {
				e.printStackTrace();
				putResponseProperty("status", "failed");
				putResponseProperty("error", "ÎÄ¼þ¶ÁÐ´´íÎó");
				return;
				
			}
		}
		
		
		
		RAdvertisementDao advertisementDao = new RAdvertisementDaoImpl();
		advertisementDao.addAdvertisement(advertisement);
		
		putResponseProperty("status", "success");
	}
	public String getAdvertisement_name() {
		return advertisement_name;
	}
	public void setAdvertisement_name(String advertisement_name) {
		this.advertisement_name = advertisement_name;
	}

	public String getAdvertisement_desc() {
		return advertisement_desc;
	}
	public void setAdvertisement_desc(String advertisement_desc) {
		this.advertisement_desc = advertisement_desc;
	}
	public String getAdvertisement_code() {
		return advertisement_code;
	}
	public void setAdvertisement_code(String advertisement_code) {
		this.advertisement_code = advertisement_code;
	}
}

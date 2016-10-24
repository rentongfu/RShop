package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RManager;

public interface RManagerDao {
	/**
	 * 添加管理员
	 * @param manager 必须含有loginname和password
	 * @return 成功返回true，失败返回false
	 */
	public boolean addManager(RManager manager) ;
	
	/**
	 * 检查登录名和密码是否相符
	 * @param manager必须含有loginname和password
	 * @return 成功返回true，失败返回false
	 */
	public boolean checkPassword(RManager manager) ;
	
	public List<RManager> getAllManager();
}

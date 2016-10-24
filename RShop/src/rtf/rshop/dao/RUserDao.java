package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RUser;

public interface RUserDao {
	
	public boolean addUser(RUser user) ;
	
	/**
	 * 检查登录名和密码是否相符
	 * @param manager必须含有loginname和password
	 * @return 成功返回true，失败返回false
	 */
	public RUser checkPassword(RUser user) ;
	
	public List<RUser> getAllUser();
}

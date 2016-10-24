package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RUser;

public interface RUserDao {
	
	public boolean addUser(RUser user) ;
	
	/**
	 * ����¼���������Ƿ����
	 * @param manager���뺬��loginname��password
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public RUser checkPassword(RUser user) ;
	
	public List<RUser> getAllUser();
}

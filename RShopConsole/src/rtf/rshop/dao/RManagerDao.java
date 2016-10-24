package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RManager;

public interface RManagerDao {
	/**
	 * ��ӹ���Ա
	 * @param manager ���뺬��loginname��password
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean addManager(RManager manager) ;
	
	/**
	 * ����¼���������Ƿ����
	 * @param manager���뺬��loginname��password
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean checkPassword(RManager manager) ;
	
	public List<RManager> getAllManager();
}

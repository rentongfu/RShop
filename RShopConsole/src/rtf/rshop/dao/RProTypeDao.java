package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RProType;

public interface RProTypeDao {
	
	
	/**
	 * �����Ʒ���
	 * @param protype ��ӵ�ProType
	 * @return 1 �ɹ���2 code���Ϸ���Υ��ΨһԼ��
	 */
	public void addProType(RProType protype) ;
	
	/**
	 * ��ȡ���е�ProType
	 * @return
	 */
	public List<RProType> getAllProType() ;
	
	/**
	 * ����code��ȡRProType
	 * @param code
	 * @return
	 */
	public RProType getProTypeByCode(String code) ;
	
	/**
	 * ���ݸ��ڵ�code��ȡRProType�б�
	 */
	public RProType[] getProTypesByParent(RProType parent);
}

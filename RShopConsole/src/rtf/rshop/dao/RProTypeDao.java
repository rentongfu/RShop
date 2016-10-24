package rtf.rshop.dao;

import java.util.List;

import rtf.rshop.po.RProType;

public interface RProTypeDao {
	
	
	/**
	 * 添加商品类别
	 * @param protype 添加的ProType
	 * @return 1 成功；2 code不合法，违反唯一约束
	 */
	public void addProType(RProType protype) ;
	
	/**
	 * 获取所有的ProType
	 * @return
	 */
	public List<RProType> getAllProType() ;
	
	/**
	 * 根据code获取RProType
	 * @param code
	 * @return
	 */
	public RProType getProTypeByCode(String code) ;
	
	/**
	 * 根据父节点code获取RProType列表
	 */
	public RProType[] getProTypesByParent(RProType parent);
}

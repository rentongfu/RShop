package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.po.RProType;
import rtf.rshop.po.RProduct;

public class RProTypeDaoImpl implements RProTypeDao {

	@Override
	public RProType getTypeByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from RProType where code = :code" ;
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql) ;
		query.setString("code", code);
		@SuppressWarnings("unchecked")
		List<RProType> list = query.list() ;
		ts.commit();
		HibernateUtil.closeSession(session);
		if( list.isEmpty())
			return null;
		else
			return list.get(0);
		
	}
	
}

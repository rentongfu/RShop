package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import rtf.rshop.dao.RProTypeDao;
import rtf.rshop.po.RProType;

public class RProTypeDaoImpl implements RProTypeDao {
	public static void main(String[] args){
		RProType protype = new RProType();
		protype.setCode("asd");
		protype.setName("asdasd");
		protype.setParent(protype);
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		session.save(protype);
		ts.commit();
		HibernateUtil.closeSession(session);
	}
	
	public void addProType(RProType protype){
		Session session = HibernateUtil.getSession();	
		Transaction ts = session.beginTransaction();
		session.save(protype);
		ts.commit();
	
		HibernateUtil.closeSession(session);
	
	}

	@Override
	public List<RProType> getAllProType() {
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction() ;
		String hql = "from RProType" ;
		Query query = session.createQuery(hql) ;
		List<RProType> list = query.list() ;
		ts.commit();
		HibernateUtil.closeSession(session);
		return list;
	}

	
	@Override
	public RProType getProTypeByCode(String code) {
		String hql = "select protype from RProType as protype where code = :code" ;
		Session session = HibernateUtil.getSession() ;
		Transaction ts =session.beginTransaction() ;
		Query query = session.createQuery(hql);
		query.setString("code", code ) ;
		List<RProType> list = query.list();
		ts.commit();
		HibernateUtil.closeSession(session);
		if(list.isEmpty()){
			return null ;
		}
		
		return list.get(0);
	}

	@Override
	public RProType[] getProTypesByParent(RProType parent) {
		// TODO Î´Íê³É
		String hql = "select protype from RProType as protype where parent= :parent" ;
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction() ;
		Query query = session.createQuery(hql);
		query.setParameter("parent", parent);
//		query.setString("parent_code", parent_code) ;
		List<RProType> list = query.list() ;
		ts.commit();
		HibernateUtil.closeSession(session);
		
		return (RProType[]) list.toArray(new RProType[list.size()]);
	}
}

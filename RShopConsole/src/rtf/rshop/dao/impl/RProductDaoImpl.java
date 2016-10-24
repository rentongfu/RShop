package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RProductDao;
import rtf.rshop.po.RProduct;
import rtf.rshop.po.RProductParameter;

public class RProductDaoImpl implements RProductDao {

	@Override
	public boolean addProduct(RProduct product) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		session.save(product);
		for( RProductParameter parameter : product.getParameters() ){
			session.save(parameter);
		}
		ts.commit();
		HibernateUtil.closeSession(session);
		return true;
	}

	@Override
	public List<RProduct> getAllProduct() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction() ;
		String hql = "from RProduct" ;
		Query query = session.createQuery(hql) ;
		List<RProduct> list = query.list() ;
		ts.commit();
		HibernateUtil.closeSession(session);
		return list;

	}

	@Override
	public RProduct getProductByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from RProduct where code=:code" ;
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery(hql) ;
		query.setString("code", code);
		@SuppressWarnings("unchecked")
		List<RProduct> list = query.list() ;
		ts.commit();
		RProduct product = null;
		
		
		if(! list.isEmpty()) product = list.get(0);
		HibernateUtil.closeSession(session);
		return product ;
			
	
	}

}

package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.ROrderDao;
import rtf.rshop.po.ROrder;
import rtf.rshop.po.RUser;

public class ROrderDaoImpl implements ROrderDao{

	@Override
	public void addOrder(ROrder order) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction() ;
		session.save(order);
		trans.commit(); 
		HibernateUtil.closeSession(session);
	}

	@Override
	public List<ROrder> getOrderByUser(RUser user) {
		// TODO Auto-generated method stub
		String hql = "from ROrder where user=:user" ;
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction() ;
		Query query = session.createQuery(hql);
		query.setParameter("user", user);
		List<ROrder> order_list = query.list() ;
		trans.commit(); 
		HibernateUtil.closeSession(session);
		return order_list;
	}

	@Override
	public ROrder getOrderById(int id) {
		// TODO Auto-generated method stub
		String hql = "from ROrder where id=:id" ;
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction() ;
		Query query = session.createQuery(hql);
		
		query.setInteger("id", id) ;
		List<ROrder> order_list = query.list() ;
		trans.commit(); 
		HibernateUtil.closeSession(session);
		if( order_list.size() >  0)
			return order_list.get(0);
		return null;
	}

	@Override
	public void updateOrder(ROrder order) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction() ;
		session.update(order);
		trans.commit(); 
		HibernateUtil.closeSession(session);
	}

	@Override
	public void cancelOrder(ROrder order) {
		// TODO Auto-generated method stub
		
	}

}

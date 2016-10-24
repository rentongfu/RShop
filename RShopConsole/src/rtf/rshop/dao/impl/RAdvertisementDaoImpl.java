package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RAdvertisementDao;
import rtf.rshop.po.RAdvertisement;
import rtf.rshop.po.RAdvertisementItem;

public class RAdvertisementDaoImpl implements RAdvertisementDao {

	@Override
	public void addAdvertisement(RAdvertisement advertisement) {
		Session sess = HibernateUtil.getSession() ;
		Transaction ts = sess.beginTransaction() ;
		sess.save(advertisement);
		for ( RAdvertisementItem item : advertisement.getItems()){
			sess.save(item);
		}
		ts.commit();
		HibernateUtil.closeSession(sess);
		return;
	}

	@Override
	public RAdvertisement getAdvertisementByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from RAdvertisement as adv where adv.name=:name" ;
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction() ;
		Query query = session.createQuery(hql);
		query.setString("name", name);
		@SuppressWarnings("unchecked")
		List<RAdvertisement> adv_list = query.list();
		ts.commit();
		HibernateUtil.closeSession(session);
		return adv_list.get(0);
	}

	@Override
	public List<RAdvertisement> getAllAdvertisement() {
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction() ;
		String hql = "from RAdvertisement" ;
		Query query = session.createQuery(hql);
		List<RAdvertisement> adv_list = query.list();
		ts.commit();
		HibernateUtil.closeSession(session);
		return adv_list;
	}

}

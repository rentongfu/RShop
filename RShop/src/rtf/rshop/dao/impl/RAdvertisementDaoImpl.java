package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RAdvertisementDao;
import rtf.rshop.po.RAdvertisement;

public class RAdvertisementDaoImpl implements RAdvertisementDao {

	

	@Override
	public RAdvertisement getAdvertisementByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from RAdvertisement as adv where adv.code=:code" ;
		Session session = HibernateUtil.getSession() ;
		Transaction ts = session.beginTransaction() ;
		Query query = session.createQuery(hql);
		query.setString("code", code);
		@SuppressWarnings("unchecked")
		List<RAdvertisement> adv_list = query.list();
		ts.commit();
		HibernateUtil.closeSession(session);
		return adv_list.get(0);
	}



}

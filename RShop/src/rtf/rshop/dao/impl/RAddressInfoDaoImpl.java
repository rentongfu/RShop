package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RAddressInfoDao;
import rtf.rshop.po.RAddressInfo;
import rtf.rshop.po.RUser;

public class RAddressInfoDaoImpl implements RAddressInfoDao {

	@Override
	public void addAddressInfo(RAddressInfo address_info) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction();
		session.save(address_info);
		trans.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public List<RAddressInfo> getAddressInfoByUser(RUser user) {
		// TODO Auto-generated method stub
		String hql = "from RAddressInfo where user = :user and isdelete!=:isdelete" ;
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("user", user);
		query.setBoolean("isdelete", true);
		List<RAddressInfo> addressinfo_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		return addressinfo_list;
	}

	@Override
	public void deleteAddressInfo(RAddressInfo addressinfo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction();
		
		addressinfo.setIsdelete(true);
			
		session.update(addressinfo);
		trans.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public RAddressInfo getAddressInfoById(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction();
		
		RAddressInfo addressinfo = (RAddressInfo) session.get(RAddressInfo.class, id);
		
		trans.commit();
		HibernateUtil.closeSession(session);
		return addressinfo;
	}

	@Override
	public void updateAddressInfo(RAddressInfo addressinfo,RAddressInfo oldaddressinfo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction();
		oldaddressinfo.setIsdelete(true);
		session.update(oldaddressinfo);
		session.save(addressinfo);
		trans.commit();
		HibernateUtil.closeSession(session);
	}

}

package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RDistrictDao;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RDistrict;

public class RDistrictDaoImpl implements RDistrictDao {

	@Override
	public List<RDistrict> getDistrictList(RCity city) {
		// TODO Auto-generated method stub
		String hql = "from RDistrict where city=:city";
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("city", city);
		List<RDistrict> district_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		return district_list;
	}

	@Override
	public RDistrict getDistrictByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from RDistrict where code=:code";
		
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("code", code);
		List<RDistrict> district_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		if(district_list.size() > 0 ){
			return district_list.get(0);
		}
		return null;
	}

}

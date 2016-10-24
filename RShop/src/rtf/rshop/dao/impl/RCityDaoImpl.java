package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;

import rtf.rshop.dao.RCityDao;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RProvince;

public class RCityDaoImpl implements RCityDao {

	@Override
	public List<RCity> getCityList(RProvince province) {
		// TODO Auto-generated method stub
		String hql = "from RCity where province=:province";
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("province", province);
		List<RCity> city_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		return city_list;
	}

	@Override
	public RCity getCityByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from RCity where code=:code";
		
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("code", code);
		//query.setParameter("code", code);
		List<RCity> city_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		if(city_list.size() > 0 ){
			return city_list.get(0);
		}
		return null;
	}
	
}

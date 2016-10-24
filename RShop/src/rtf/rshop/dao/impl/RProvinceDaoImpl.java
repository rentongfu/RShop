package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RProvinceDao;
import rtf.rshop.po.RCity;
import rtf.rshop.po.RProduct;
import rtf.rshop.po.RProvince;

public class RProvinceDaoImpl implements RProvinceDao {

	@Override
	public List<RProvince> getAllProvince() {
		// TODO Auto-generated method stub
		String hql = "from RProvince" ;
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query  query = session.createQuery(hql);
		List<RProvince> province_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		return province_list;
	}

	@Override
	public RProvince getProvinceByCode(String code) {
		// TODO Auto-generated method stub
		String hql = "from RProvince where code=:code";
		
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("code", code);
		List<RProvince> province_list = query.list();
		trans.commit();
		HibernateUtil.closeSession(session);
		if(province_list.size() > 0 ){
			return province_list.get(0);
		}
		return null;
	}

}

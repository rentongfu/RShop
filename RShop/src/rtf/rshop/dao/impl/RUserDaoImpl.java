package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RUserDao;
import rtf.rshop.po.RManager;
import rtf.rshop.po.RUser;

public class RUserDaoImpl implements RUserDao {

	@Override
	public boolean addUser(RUser user) {
		// TODO Auto-generated method stub
		if( (user.getLoginname() == null) || (user.getLoginname().equals(""))){
			return false ;
		}
		if( ( user.getPassword() == null ) || (user.getPassword().equals(""))){
			return false ;
		}
		
		String hql = "from RUser as user where user.loginname=:loginname" ;
		Session session = HibernateUtil.getSession() ;
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("loginname", user.getLoginname());
		List<?> userlist = query.list() ;
		if( userlist.size() > 0 ){
			transaction.commit();
			HibernateUtil.closeSession(session);
			return false ;
		}
		session.save(user);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
		return true;
	}

	@Override
	public RUser checkPassword(RUser user) {
		// TODO Auto-generated method stub
		String hql = "from RUser as user where user.loginname=:loginname" ;
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction() ;
		Query query = session.createQuery(hql);
		query.setString("loginname", user.getLoginname());
		@SuppressWarnings("unchecked")
		List<RUser> userlist = query.list();
		if(userlist.size() == 0){
			return null ;
		}
		if( userlist.get(0).getPassword().equals(user.getPassword())){
			return userlist.get(0);
		}
		return null;
	}

	@Override
	public List<RUser> getAllUser() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		String hql = "from RUser" ;
		Query query = session.createQuery(hql);
		List<RUser> userList = query.list();
		ts.commit();
		HibernateUtil.closeSession(session);
		return userList;
	}

}

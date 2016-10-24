package rtf.rshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RManagerDao;
import rtf.rshop.po.RManager;

public class RManagerDaoImpl implements RManagerDao {

	@Override
	public boolean addManager(RManager manager) {
		
		//此处应先检查输入信息的合法性
		if( (manager.getLoginname() == null )||(manager.getLoginname().equals(""))){
			return false ;
		}
		if( ( manager.getPassword() == null) || (manager.getPassword().equals(""))){
			return false ;
		}
		//验证登录名是否已存在
		String hql = "from RManager as manager where manager.loginname=:loginname" ;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString("loginname", manager.getLoginname());
		List<?> managerlist = query.list() ;
		if( managerlist.size() > 0 ){
			return false ;
		}
		session.save(manager);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
		return true;
	}

	@Override
	public boolean checkPassword(RManager manager) {
		String hql = "from RManager as user where user.loginname=:loginname and user.password=:password" ;
	
		//此处应先检查输入信息的合法性
		if( (manager.getLoginname() == null )||(manager.getLoginname().equals(""))){
			return false ;
		}
		if( ( manager.getPassword() == null) || (manager.getPassword().equals(""))){
			return false ;
		}
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql) ;
		query.setString("loginname", manager.getLoginname()) ;
		query.setString("password", manager.getPassword()) ;
		List<?> userlist = query.list() ;
		transaction.commit();

		HibernateUtil.closeSession(session);
		
		if(userlist.isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<RManager> getAllManager() {
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		String hql = "from RManager" ;
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<RManager> managerList = query.list();
		ts.commit();
		HibernateUtil.closeSession(session);
		return managerList;
	}

}

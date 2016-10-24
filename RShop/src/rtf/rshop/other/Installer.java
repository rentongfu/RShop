package rtf.rshop.other;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.impl.HibernateUtil;
import rtf.rshop.po.RManager;
import rtf.rshop.po.RProType;

public class Installer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		initRProType(session);
		initRManager(session);
		HibernateUtil.closeSession(session);
		System.exit(0);
	}
	private static void initRProType(Session session){
		Transaction ts = session.beginTransaction() ;
		RProType type= new RProType();
		type.setName("所有商品");
		type.setParent(type);
		type.setDescribe("所有商品");
		session.save(type);
		ts.commit();
	}
	private static void initRManager(Session session){
		Transaction ts = session.beginTransaction();
		RManager manager = new RManager() ;
		manager.setLoginname("admin");
		manager.setPassword("admin123");
		session.save(manager);
		ts.commit();
	}

}

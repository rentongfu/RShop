package rtf.rshop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory ;
	static{
		Configuration conf = new Configuration().configure() ;
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		sessionFactory = conf.buildSessionFactory(serviceRegistry);
	}
	public static Session getSession(){
		return sessionFactory.openSession() ;
	}
	public static void closeSession(Session session){
		session.close();
		
	}

}

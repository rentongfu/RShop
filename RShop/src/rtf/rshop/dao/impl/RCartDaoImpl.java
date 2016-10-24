package rtf.rshop.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RCartDao;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RCartItem;
import rtf.rshop.po.RUser;

public class RCartDaoImpl implements RCartDao{

	@Override
	public RCart getCart(RUser user) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		RCart cart = (RCart) session.get(RCart.class, user.getId());
		if (cart == null ){
			cart = new RCart();
			cart.setItems(new ArrayList<RCartItem>());
			cart.setUser(user);
			session.save(cart);
		}
		trans.commit();
		HibernateUtil.closeSession(session);
		return cart;
	}

	@Override
	public void updateCart(RCart cart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction() ;
		session.update(cart);
		trans.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void increaseQuantityOfCartItem(RCart cart, int index) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction() ;
		RCartItem cart_item = cart.getItems().get(index);
		cart_item.setQuantity(cart_item.getQuantity()+1);
		session.update(cart_item);
		trans.commit();
		HibernateUtil.closeSession(session);
	}

	@Override
	public void decreaseQuantityOfCartItem(RCart cart, int index) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction() ;
		RCartItem cart_item = cart.getItems().get(index);
		if(cart_item.getQuantity() >= 2){
			cart_item.setQuantity(cart_item.getQuantity()-1);
			session.update(cart_item);
		}else{
			
			cart.getItems().remove(index);
			cart_item.setCart(null);
			session.delete(cart_item);
			session.update(cart);
			
		}
		
		trans.commit();
		HibernateUtil.closeSession(session);
	}

	public void removeCartItem(RCart cart ,int index ){
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction() ;
		RCartItem cart_item = cart.getItems().get(index);
		cart.getItems().remove(index);
		cart_item.setCart(null);
		session.delete(cart_item);
		session.update(cart);
		
		trans.commit();
		HibernateUtil.closeSession(session);
	}
}

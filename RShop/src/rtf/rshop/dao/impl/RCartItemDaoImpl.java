package rtf.rshop.dao.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import rtf.rshop.dao.RCartItemDao;
import rtf.rshop.po.RCart;
import rtf.rshop.po.RCartItem;

public class RCartItemDaoImpl implements RCartItemDao {

	@Override
	public void addCartItem(RCartItem cart_item, RCart cart) {
		// TODO Auto-generated method stub
		boolean isExist = false ;
		for(RCartItem item:cart.getItems()){
			if( item.getProduct().getCode().equals(cart_item.getProduct().getCode())){
				isExist = true ;
				cart_item = item ;
				break;
			}
		}
		Session session = HibernateUtil.getSession() ;
		Transaction trans = session.beginTransaction() ;
		
		if(isExist ){
			cart_item.setQuantity(cart_item.getQuantity() + 1 );
			session.update(cart_item);
		}else{
			cart_item.setCart(cart);
			cart_item.setQuantity(1);
			cart_item.setCreate_time(new Date());
			cart.getItems().add(cart_item);
			session.update(cart);
		//	session.save(cart_item);
		}
		trans.commit();
		HibernateUtil.closeSession(session);
	}

}

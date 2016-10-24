package rtf.rshop.dao;

import rtf.rshop.po.RCart;
import rtf.rshop.po.RUser;

public interface RCartDao {
	public RCart getCart(RUser user);
	public void updateCart(RCart cart) ;
	public void increaseQuantityOfCartItem(RCart cart ,int index );
	public void decreaseQuantityOfCartItem(RCart cart ,int index );
	public void removeCartItem(RCart cart ,int index );
}

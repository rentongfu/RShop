package rtf.rshop.dao;

import rtf.rshop.po.RCart;
import rtf.rshop.po.RCartItem;

public interface RCartItemDao {
	public void addCartItem(RCartItem cart_item , RCart cart );
}

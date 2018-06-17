package com.WebShop.dao.implementation;

import com.WebShop.dao.CartItemDao;
import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();

    }

    public void removeAllCartItems(Cart cart) {

        List<CartItem>cartItems=cart.getCartItemList();

        for (CartItem item:cartItems){
           removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductID(int productID) {

        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from CartItem where productID=?");
        query.setInteger(0,productID);
        session.flush();

        return (CartItem) query.uniqueResult();
    }
}

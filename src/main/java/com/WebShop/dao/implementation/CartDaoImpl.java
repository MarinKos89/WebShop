package com.WebShop.dao.implementation;

import com.WebShop.dao.CartDao;
import com.WebShop.model.Cart;
import com.WebShop.service.CartService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {


    @Autowired
    private SessionFactory sessionFactory;

    public Cart getCartByID(int cartID) {
       Session session =sessionFactory.getCurrentSession();
       Cart cart=(Cart)session.get(Cart.class,cartID);
       session.flush();
       return  cart;
    }

    public void update(Cart cart) {
        //TODO
    }

    public Cart validate(int cartId) throws IOException {
        Cart cart=getCartByID(cartId);
        if (cart==null || cart.getCartItemList().size()==0){
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }
}

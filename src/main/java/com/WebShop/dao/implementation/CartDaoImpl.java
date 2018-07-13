package com.WebShop.dao.implementation;

import com.WebShop.dao.CartDao;
import com.WebShop.model.Cart;
import com.WebShop.service.CartService;
import com.WebShop.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {




    @Autowired
    private SessionFactory sessionFactory;



    @Autowired
    private CustomerOrderService customerOrderService;

    @Override
    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderPrice(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    @Override
    public Cart validate(int cartId) throws IOException {
        Cart cart=getCartByID(cartId);
        if(cart==null||cart.getCartItems().size()==0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }

    @Override
    public Cart getCartByID(int cartID) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartID);
    }



}

package com.WebShop.service.impl;

import com.WebShop.dao.CartDao;
import com.WebShop.model.Cart;
import com.WebShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    private CartDao cartDao;

    public Cart getCartByID(int cartid) {

        return cartDao.getCartByID(cartid);
    }

    public void update(Cart cart) {

        cartDao.update(cart);

    }
}

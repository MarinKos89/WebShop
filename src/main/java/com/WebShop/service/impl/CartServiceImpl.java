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


    @Override
    public Cart getCartByID(int Cartid) {
        return cartDao.getCartByID(Cartid);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }


}

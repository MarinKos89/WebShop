package com.WebShop.dao;

import com.WebShop.model.Cart;

import java.io.IOException;


public interface CartDao {

    Cart getCartByID(int Cartid);

    void update(Cart cart);

    Cart validate(int cartId) throws IOException;
}

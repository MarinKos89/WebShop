package com.WebShop.service;

import com.WebShop.model.Cart;

public interface CartService {


    Cart getCartByID(int Cartid);
//    Cart create(Cart cart);
//    Cart read(String cartId);
//    void update(String cartId, Cart cart);
//    void delete(String cartId);

    void update(Cart cart);
}

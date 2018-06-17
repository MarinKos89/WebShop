package com.WebShop.service;

import com.WebShop.model.Cart;

public interface CartService {

    Cart getCartByID(int Cartid);

    void update(Cart cart);
}

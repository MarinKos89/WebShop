package com.WebShop.dao;

import com.WebShop.model.Cart;

public interface CartDao {

    Cart create(Cart item);
    Cart read(String cartID);
    void delete(String cartID);
    void update(String cartID,Cart cart);
}

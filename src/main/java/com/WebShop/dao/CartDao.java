package com.WebShop.dao;

import com.WebShop.model.Cart;

public interface CartDao {

    Cart create(Cart cart);
    Cart read(String cartId);
    void delete(String cartId);
    void update(String cartId,Cart cart);
}

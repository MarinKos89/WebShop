package com.WebShop.dao;

import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;


public interface CartItemDao {

    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProductID(int productID);
}

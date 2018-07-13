package com.WebShop.service;


import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItemID);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProductID(int productID);
}

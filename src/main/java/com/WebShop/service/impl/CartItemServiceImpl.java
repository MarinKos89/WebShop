package com.WebShop.service.impl;

import com.WebShop.dao.CartItemDao;
import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;
import com.WebShop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItemID) {

        cartItemDao.removeCartItem(cartItemID);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductID(int productID) {
        return cartItemDao.getCartItemByProductID(productID);
    }
}

package com.WebShop.dao.implementation;

import com.WebShop.dao.CartDao;
import com.WebShop.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {


    private Map<String,Cart> cartMapList;

    public CartDaoImpl(){
        cartMapList=new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
       if (cartMapList.keySet().contains(cart.getCartID()))
       {
           try {
               throw new IllegalAccessException("Cart with that ID already exists");
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
       cartMapList.put(cart.getCartID(),cart);
       return cart;

    }

    public Cart read(String cartID) {
        return cartMapList.get(cartID);
    }

    public void delete(String cartID) {
        if (!cartMapList.keySet().contains(cartID)){
           throw new IllegalArgumentException("Cart with that id does not exist");
        }
        cartMapList.remove(cartID);
    }

    public void update(String cartID, Cart cart) {
        if (!cartMapList.keySet().contains(cartID)) {
            throw new IllegalArgumentException("No cart with that id");
        }
        cartMapList.put(cartID,cart);
    }
}

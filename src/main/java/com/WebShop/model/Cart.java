package com.WebShop.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private String cartID;
    private Map<String, CartItem> cartItemMap;
    private double grandTotal;


    private Cart(){
        cartItemMap=new HashMap<String, CartItem>();
        grandTotal=0;
    }
    public Cart(String cartID){

        this();
        this.cartID=cartID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public Map<String, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<String, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void AddCartItem(CartItem cartItem){
        String productID=cartItem.getProduct().getProductID();

        if (cartItemMap.containsKey(productID)) {
            CartItem existingItem=cartItemMap.get(productID);
            existingItem.setQuantity(existingItem.getQuantity()+cartItem.getQuantity());
            cartItemMap.put(productID,existingItem);
        }
        else{
            cartItemMap.put(productID,cartItem);
        }
        updateGrandTotal();
    }

    private void updateGrandTotal() {
        grandTotal=0;
        for (CartItem item: cartItemMap.values()){
            grandTotal=grandTotal+item.getTotalPrice();
        }

    }

    public void RemoveCartItem(CartItem item){
        String productID=item.getProduct().getProductID();
        cartItemMap.remove(productID);
        updateGrandTotal();
    }
}




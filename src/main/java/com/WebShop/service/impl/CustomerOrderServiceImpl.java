package com.WebShop.service.impl;

import com.WebShop.dao.CustomerOrderDao;
import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;
import com.WebShop.model.CustomerOrder;
import com.WebShop.service.CartService;
import com.WebShop.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderPrice(int cartId) {

        double grandTotal=0;
        Cart cart=cartService.getCartByID(cartId);
        List<CartItem>cartItems=cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal+=item.getTotalPrice();
        }
        return grandTotal;
    }
}

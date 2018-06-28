package com.WebShop.controller;

import com.WebShop.dao.CustomerOrderDao;
import com.WebShop.model.Cart;
import com.WebShop.model.Customer;
import com.WebShop.model.CustomerOrder;
import com.WebShop.service.CartService;
import com.WebShop.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){

        CustomerOrder customerOrder=new CustomerOrder();

        Cart cart=cartService.getCartByID(cartId);

        customerOrder.setCart(cart);

        Customer customer=cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());


        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cartId="+cartId;


    }
}

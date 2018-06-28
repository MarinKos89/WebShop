package com.WebShop.controller;

import com.WebShop.model.Cart;
import com.WebShop.model.CartItem;
import com.WebShop.model.Customer;
import com.WebShop.service.CartService;
import com.WebShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer/cart")
public class CartController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){

        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/"+cartId;


}

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}

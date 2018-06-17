package com.WebShop.controller;

import com.WebShop.model.Customer;
import com.WebShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/cart")
public class CartController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer=customerService.getCustomerByUsername(activeUser.getUsername());
        int cartID=customer.getCart().getCartID();

        return "redirect:/customer/cart/" +cartID;
    }

    @RequestMapping("/cart/{cartID}")
    public String getCartRedirect(@PathVariable (value = "cartID") int cartID,Model model){
        model.addAttribute("cartID",cartID);

        return "cart";
    }
}

package com.WebShop.controller.admin;

import com.WebShop.model.Customer;
import com.WebShop.model.Product;
import com.WebShop.service.CustomerService;
import com.WebShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product>products=productService.getProductList();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model){

        List<Customer>customerList=customerService.getAllCustomers();
        model.addAttribute("customerList",customerList);


        return "customerManagement";
    }
}

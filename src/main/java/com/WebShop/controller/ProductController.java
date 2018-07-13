package com.WebShop.controller;

import com.WebShop.model.Product;
import com.WebShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products=productService.getProductList();
        model.addAttribute("products",products);

        return "productList";
    }


    @RequestMapping("/viewProduct/{productID}")
    public String viewProduct(@PathVariable int productID, Model model) throws IOException{
        Product product=productService.getProductByID(productID);
        model.addAttribute("product",product);

        return "viewProduct";
    }
}

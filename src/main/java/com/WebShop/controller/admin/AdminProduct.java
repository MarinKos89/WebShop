package com.WebShop.controller.admin;

import com.WebShop.model.Product;
import com.WebShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.*;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    private ProductService productService;

   @RequestMapping("/product/addProduct")
    public String addProduct(Model model){
       Product product=new Product();
       product.setProductCategory("gitara");
       product.setProductCondition("used");
       product.setProductStatus("active");

       model.addAttribute("product", product);

       return "addProduct";
   }

    @RequestMapping(value="/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if(result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(product);



        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductByID(id);

        model.addAttribute("product", product);

        return "editProduct";
    }

    @RequestMapping(value="/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                  HttpServletRequest request) {
        if(result.hasErrors()) {
            return "editProduct";
        }



        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }


    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");


        Product product = productService.getProductByID(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}

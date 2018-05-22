package com.WebShop;

import com.WebShop.dao.ProductDao;
import com.WebShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){

        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){

        List<Product> products=productDao.getAllProduct();

        model.addAttribute("products",products);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productID}")
    public String viewProduct(@PathVariable String productID,Model model) throws IOException {

        Product product=productDao.getProductByID(productID);
        model.addAttribute(product);

        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){

        List<Product>products=productDao.getAllProduct();
        model.addAttribute("products",products);

        return "productInventory";

    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product=new Product();
        product.setProductCategory("Drums");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product",product);

        return "addProduct";
    }


    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){

        if (result.hasErrors()){
            return "addProduct";
        }

        productDao.addProduct(product);

        return "redirect:/admin/productInventory";
    }


    @RequestMapping("/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") String id, Model model){
        Product product=productDao.getProductByID(id);

        model.addAttribute(product);

        return "editProduct";

    }

    @RequestMapping(value = "/admin/productInventory/editProduct",method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, Model model, HttpServletRequest request, BindingResult result)
    {
        if (result.hasErrors()){
            return "editProduct";
        }

        productDao.editProduct(product);

        return "redirect: /admin/productInventory";
    }


    @RequestMapping(value = "/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id,Model model)
    {

        productDao.deleteProduct(id);


        return "redirect:/admin/productInventory";
    }
}

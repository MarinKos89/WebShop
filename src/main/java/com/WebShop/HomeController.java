package com.WebShop;

import com.WebShop.dao.ProductDao;
import com.WebShop.dao.implementation.ProductDaoImpl;
import com.WebShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

    private Path path;


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


    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request){
        productDao.addProduct(product);

        MultipartFile productImage=product.getProductImage();
        String rootDirectory=request.getSession().getServletContext().getRealPath("/");
        path=Paths.get(rootDirectory + "\\WEB-INF\\images\\" + product.getProductID()+".png");

        if (productImage!=null && !productImage.isEmpty())
        {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("product image saving failed", e);
            }
        }

        return "redirect:/admin/productInventory";
    }


    @RequestMapping(value = "/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id,Model model)
    {

        productDao.deleteProduct(id);


        return "redirect:/admin/productInventory";
    }
}

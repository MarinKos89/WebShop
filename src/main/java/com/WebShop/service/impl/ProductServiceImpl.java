package com.WebShop.service.impl;

import com.WebShop.dao.ProductDao;
import com.WebShop.model.Product;
import com.WebShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public Product getProductByID(int productId) {
        return productDao.getProductByID(productId);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);

    }

    public void editProduct(Product product) {
        productDao.editProduct(product);

    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);

    }
}

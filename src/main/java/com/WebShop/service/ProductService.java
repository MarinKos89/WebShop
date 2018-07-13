package com.WebShop.service;

import com.WebShop.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> getProductList();

    Product getProductByID(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);


}

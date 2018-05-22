package com.WebShop.dao;

import com.WebShop.model.Product;


import java.util.List;


public interface ProductDao {

    void addProduct(Product product);

    Product getProductByID(String id);

    List<Product>getAllProduct();

    void deleteProduct(String id);

    void editProduct(Product product);

}

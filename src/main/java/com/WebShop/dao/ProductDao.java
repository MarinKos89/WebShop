package com.WebShop.dao;

import com.WebShop.model.Product;


import java.util.List;


public interface ProductDao {

    List<Product> getProductList();

    Product getProductByID(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}

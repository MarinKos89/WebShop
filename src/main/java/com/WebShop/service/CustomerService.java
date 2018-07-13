package com.WebShop.service;

import com.WebShop.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerByID(int customerID);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}

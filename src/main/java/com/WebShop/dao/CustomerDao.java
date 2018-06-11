package com.WebShop.dao;

import com.WebShop.model.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);

    Customer getCustomerByID(int customerID);

    List<Customer> getAllCustomers();
}

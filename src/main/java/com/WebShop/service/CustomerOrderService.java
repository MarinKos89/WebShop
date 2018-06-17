package com.WebShop.service;

import com.WebShop.model.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderPrice(int cartId);


}

package com.WebShop.dao.implementation;

import com.WebShop.dao.CustomerDao;
import com.WebShop.model.Authorities;
import com.WebShop.model.Cart;
import com.WebShop.model.Customer;
import com.WebShop.model.Users;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser=new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerID(customer.getCustomerID());

        Authorities newAuthorities=new Authorities();
        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart=new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerByID(int customerID){
        Session session=sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class,customerID);
    }


    public List<Customer> getAllCustomers(){
        Session session=sessionFactory.getCurrentSession();

        Query query= session.createQuery("from Customer");
        List<Customer>customerList=query.list();

        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        Session session=sessionFactory.getCurrentSession();
        Query query= (Query) session.createQuery("from Customer where username = ?");
        query.setString(0,username);

        return (Customer) query.uniqueResult();
    }
}

package com.upgrad.movieapp.dao.sql.hibernate;

import com.upgrad.movieapp.entities.sql.Customer;

public interface CustomerDao {

    public Customer save(Customer customer);

    public Customer findById(int id);

    public Customer update(Customer customer);

    public void delete(Customer customer);
}

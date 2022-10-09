package com.repositoty;

import com.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ICustomerRepository  {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(Long id);
    Customer findById(Long id);
}

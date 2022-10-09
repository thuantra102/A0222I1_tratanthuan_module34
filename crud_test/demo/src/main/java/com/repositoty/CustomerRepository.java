package com.repositoty;

import com.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        String queryStr = "select c from Customer as c";
        List<Customer> customerList = entityManager.createQuery(queryStr,Customer.class).getResultList();
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId()!=null) {
            entityManager.merge(customer);
        }else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        if(customer!= null) {
            entityManager.remove(customer);
        }

    }

    @Override
    public Customer findById(Long id) {
        String queryStr = "from Customer as c where c.id =:id";
        Customer customer = entityManager.createQuery(queryStr,Customer.class).setParameter("id",id).getSingleResult();
        return customer;
    }
}

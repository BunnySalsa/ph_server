package com.rsreu.ph_server.service;

import com.rsreu.ph_server.entity.Customer;
import com.rsreu.ph_server.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    public void update(Long id, Customer customer) {
        Customer customer1 = customerRepo.findById(id).orElseThrow();
        customer1.setName(customer.getName());
        customer1.setAddress(customer.getAddress());
        customerRepo.save(customer1);
    }

    public void delete(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow();
        customerRepo.delete(customer);
    }

    public Customer getCustomer(long id) {
        return customerRepo.findById(id).orElseThrow();
    }

    public Iterable<Customer> getAll() {
        return customerRepo.findAll();
    }
}

package com.rsreu.ph_server.repository;

import com.rsreu.ph_server.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

}

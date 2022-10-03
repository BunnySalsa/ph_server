package com.rsreu.ph_server.repository;

import com.rsreu.ph_server.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Employee findByLogin(String login);


}

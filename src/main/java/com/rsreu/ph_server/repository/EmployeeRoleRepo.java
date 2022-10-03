package com.rsreu.ph_server.repository;

import com.rsreu.ph_server.entity.Employee;
import com.rsreu.ph_server.entity.EmployeeRole;
import com.rsreu.ph_server.entity.EmployeeRoleID;
import com.rsreu.ph_server.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRoleRepo extends CrudRepository<EmployeeRole, EmployeeRoleID> {

    List<EmployeeRole> findByEmployee(Employee employee);
    List<EmployeeRole> findByRole(Role role);
}

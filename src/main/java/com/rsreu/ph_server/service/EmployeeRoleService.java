package com.rsreu.ph_server.service;

import com.rsreu.ph_server.entity.Employee;
import com.rsreu.ph_server.entity.EmployeeRole;
import com.rsreu.ph_server.entity.Role;
import com.rsreu.ph_server.repository.EmployeeRepo;
import com.rsreu.ph_server.repository.EmployeeRoleRepo;
import com.rsreu.ph_server.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRoleService {
    @Autowired
    private EmployeeRoleRepo repo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private RoleRepo roleRepo;

    public void save(EmployeeRole employeeRole) {
        repo.save(employeeRole);
    }

    public void deleteByEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        repo.findByEmployee(employee).forEach(repo::delete);
    }

    public void deleteByRole(Long employeeId) {
        Role role = roleRepo.findById(employeeId).orElseThrow();
        repo.findByRole(role).forEach(repo::delete);
    }

    public void delete(EmployeeRole employeeRole) {
        repo.delete(employeeRole);
    }

    public List<EmployeeRole> getAll() {
        return (List<EmployeeRole>) repo.findAll();
    }

}

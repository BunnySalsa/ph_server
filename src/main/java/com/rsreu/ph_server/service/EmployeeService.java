package com.rsreu.ph_server.service;

import com.rsreu.ph_server.dto.EmployeeDTO;
import com.rsreu.ph_server.entity.Employee;
import com.rsreu.ph_server.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public void save(Employee employee) {
        repo.save(employee);
    }

    public void update(Long id, Employee employee) {
        Employee employee1 = repo.findById(id).orElseThrow();
        employee1.setName(employee.getName());
        employee1.setLogin(employee.getLogin());
        employee1.setPassword(employee.getPassword());
    }

    public void delete(Long id) {
        Employee employee = repo.findById(id).orElseThrow();
        repo.delete(employee);
    }

    public List<EmployeeDTO> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false).map(EmployeeDTO::toModel)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeDTO(long id) {
        return EmployeeDTO.toModel(repo.findById(id).orElseThrow());
    }

    public Employee getEmployee(long id) {
        return repo.findById(id).orElseThrow();
    }

    public EmployeeDTO getByLogin(String login) {
        return EmployeeDTO.toModel(repo.findByLogin(login));
    }

    public boolean isAuthorized(Employee employee) {
        return repo.findByLogin(employee.getLogin()).getPassword().equals(employee.getPassword());
    }
}

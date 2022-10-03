package com.rsreu.ph_server.dto;

import com.rsreu.ph_server.entity.Employee;
import com.rsreu.ph_server.entity.EmployeeRole;

import java.util.List;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String login;

    public static EmployeeDTO toModel(Employee entity) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(entity.getId());
        employee.setName(entity.getName());
        employee.setLogin(entity.getLogin());
        return employee;
    }

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

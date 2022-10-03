package com.rsreu.ph_server.dto;

import com.rsreu.ph_server.entity.EmployeeRole;

public class EmployeeRoleDTO {

    private long employee;
    private long role;

    public static EmployeeRoleDTO toModel(EmployeeRole employeeRole) {
        EmployeeRoleDTO employeeRoleDTO = new EmployeeRoleDTO();
        employeeRoleDTO.setEmployee(employeeRole.getEmployee().getId());
        employeeRoleDTO.setRole(employeeRole.getRole().getId());
        return employeeRoleDTO;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }
}

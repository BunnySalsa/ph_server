package com.rsreu.ph_server.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeRoleID implements Serializable {
    private Long employee;
    private Long role;

    public EmployeeRoleID() {
    }

    public EmployeeRoleID(Long employee, Long role) {
        this.employee = employee;
        this.role = role;
    }
}

package com.rsreu.ph_server.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(EmployeeRoleID.class)
public class EmployeeRole implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    public EmployeeRole() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

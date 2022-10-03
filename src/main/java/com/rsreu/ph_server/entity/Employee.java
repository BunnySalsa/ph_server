package com.rsreu.ph_server.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String login;
    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<EmployeeRole> roles;

    public Employee() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<EmployeeRole> getRoles() {
        return roles;
    }

    public void setRoles(List<EmployeeRole> roles) {
        this.roles = roles;
    }
}

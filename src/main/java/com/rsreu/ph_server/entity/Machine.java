package com.rsreu.ph_server.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer production;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machine")
    private List<PrintingOrder> orders;

    public Machine() {
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

    public Integer getProduction() {
        return production;
    }

    public void setProduction(Integer production) {
        this.production = production;
    }
}

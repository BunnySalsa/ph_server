package com.rsreu.ph_server.dto;

import com.rsreu.ph_server.entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleDTO {
    private long id;
    private String name;

    public static RoleDTO toModel(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

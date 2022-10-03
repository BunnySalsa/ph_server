package com.rsreu.ph_server.service;

import com.rsreu.ph_server.entity.Role;
import com.rsreu.ph_server.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepo repo;

    public void save(Role role) {
        repo.save(role);
    }

    public void delete(Long id) {
        Role role = repo.findById(id).orElseThrow();
        repo.delete(role);
    }

    public void update(Long id, Role role) {
        Role role1 = repo.findById(id).orElseThrow();
        role1.setName(role.getName());
        repo.save(role1);
    }

    public Role getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Role> getAll() {
        return (List<Role>) repo.findAll();
    }

}

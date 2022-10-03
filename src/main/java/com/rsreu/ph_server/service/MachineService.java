package com.rsreu.ph_server.service;


import com.rsreu.ph_server.entity.Machine;
import com.rsreu.ph_server.repository.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepo repo;

    public void save(Machine machine) {
        repo.save(machine);
    }

    public void update(Long id, Machine machine) {
        Machine machine1 = repo.findById(id).orElseThrow();
        machine1.setName(machine.getName());
        machine1.setProduction(machine.getProduction());
    }

    public void delete(Long id) {
        Machine machine = repo.findById(id).orElseThrow();
        repo.delete(machine);
    }

    public Machine getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Machine> getAll() {
        return (List<Machine>) repo.findAll();
    }
}

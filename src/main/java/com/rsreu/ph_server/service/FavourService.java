package com.rsreu.ph_server.service;

import com.rsreu.ph_server.entity.Favour;
import com.rsreu.ph_server.repository.FavourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavourService {

    @Autowired
    private FavourRepo repo;

    public void save(Favour favour){
        repo.save(favour);
    }

    public void update(Long id, Favour favour) {
        Favour favour1 = repo.findById(id).orElseThrow();
        favour1.setName(favour.getName());
        repo.save(favour1);
    }

    public void delete(Long id) {
        repo.delete(repo.findById(id).orElseThrow());
    }

    public List<Favour> getAll() {
        return (List<Favour>) repo.findAll();
    }

    public Favour getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

}

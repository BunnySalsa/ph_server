package com.rsreu.ph_server.service;

import com.rsreu.ph_server.entity.Material;
import com.rsreu.ph_server.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepo repo;

    public void save(Material material) {
        repo.save(material);
    }

    public void update(Long id, Material material) {
        Material material1 = repo.findById(id).orElseThrow();
        material1.setName(material.getName());
        repo.save(material1);
    }

    public void delete(Long id) {
        Material material = repo.findById(id).orElseThrow();
        repo.delete(material);
    }

    public Material getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Material> getAll() {
        return (List<Material>) repo.findAll();
    }
}

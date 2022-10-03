package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.entity.Material;
import com.rsreu.ph_server.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @PostMapping("/add")
    public ResponseEntity addMaterial(@RequestBody Material material) {
        try {
            service.save(material);
            return ResponseEntity.ok("Материал добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMaterial(@PathVariable Long id, @RequestBody Material material) {
        try {
            service.update(id, material);
            return ResponseEntity.ok("Данные обновлены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Материал удалён");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getMaterial(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}

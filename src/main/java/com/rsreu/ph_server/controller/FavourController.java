package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.entity.Favour;
import com.rsreu.ph_server.service.FavourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favours")
public class FavourController {

    @Autowired
    private FavourService service;

    @PostMapping("/add")
    public ResponseEntity addFavour(@RequestBody Favour favour) {
        try {
            service.save(favour);
            return ResponseEntity.ok("Услуга добавлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Favour favour) {
        try {
            service.update(id, favour);
            return ResponseEntity.ok("Услуга обновлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("remove/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Услуга удалена");
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
    public ResponseEntity getFavour(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}

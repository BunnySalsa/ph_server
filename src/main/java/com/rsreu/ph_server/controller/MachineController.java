package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.entity.Machine;
import com.rsreu.ph_server.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private MachineService service;

    @PostMapping("/add")
    public ResponseEntity addMachine(@RequestBody Machine machine) {
        try {
            service.save(machine);
            return ResponseEntity.ok("Станок добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteMachine(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Станок удалён");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMachine(@PathVariable Long id, @RequestBody Machine machine) {
        try {
            service.update(id, machine);
            return ResponseEntity.ok("Данные обновлены");
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
    public ResponseEntity getMachine(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}

package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.dto.RoleDTO;
import com.rsreu.ph_server.entity.Role;
import com.rsreu.ph_server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody Role role) {
        try {
            service.save(role);
            return ResponseEntity.ok("Роль добавлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRole(@PathVariable Long id, @RequestBody Role role) {
        try {
            service.update(id, role);
            return ResponseEntity.ok("Данные обновлены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Роль удалена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(StreamSupport.stream(service.getAll().spliterator(), false)
                    .map(RoleDTO::toModel).collect(Collectors.toList()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getRole(@PathVariable long id) {
        try {
            return ResponseEntity.ok(RoleDTO.toModel(service.getById(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

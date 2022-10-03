package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.dto.EmployeeDTO;
import com.rsreu.ph_server.dto.EmployeeRoleDTO;
import com.rsreu.ph_server.entity.Employee;
import com.rsreu.ph_server.repository.RoleRepo;
import com.rsreu.ph_server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        try {
            service.save(employee);
            return ResponseEntity.ok("Сотрдник добавен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/auth")
    public ResponseEntity authorize(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(service.isAuthorized(employee));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            service.update(id, employee);
            return ResponseEntity.ok("Данные обновлены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Сотрудник удалён");
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
    public ResponseEntity getEmployee(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.getEmployeeDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

    @GetMapping("/get/login/{login}")
    public ResponseEntity getEmployeeByLogin(@PathVariable String login) {
        try {
            return ResponseEntity.ok(service.getByLogin(login));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/role/{id}")
    public ResponseEntity getRole(@PathVariable long id) {
        try {
            Employee employee = service.getEmployee(id);
            return ResponseEntity.ok(employee.getRoles().stream().map(EmployeeRoleDTO::toModel)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

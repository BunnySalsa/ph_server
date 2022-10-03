package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.dto.EmployeeRoleDTO;
import com.rsreu.ph_server.entity.EmployeeRole;
import com.rsreu.ph_server.entity.PrintingOrder;
import com.rsreu.ph_server.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee_role")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleService service;

    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody EmployeeRole employeeRole) {
        try {
            service.save(employeeRole);
            return ResponseEntity.ok("Роль " + employeeRole.getRole().getName() + " успешно добавлена "
                    + employeeRole.getEmployee().getName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/employee/{id}")
    public ResponseEntity deleteByEmployee(@PathVariable Long id) {
        try {
            service.deleteByEmployee(id);
            return ResponseEntity.ok("Роль сотрудника удалена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/role/{id}")
    public ResponseEntity deleteByRole(@PathVariable Long id) {
        try {
            service.deleteByRole(id);
            return ResponseEntity.ok("Роль сотрудника удалена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/entry")
    public ResponseEntity delete(@RequestBody EmployeeRole employeeRole) {
        try {
            service.delete(employeeRole);
            return ResponseEntity.ok("Роль сотрудника удалена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/employee/{id}")
    public ResponseEntity getByEmployee(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getAll().stream().filter(x -> x.getEmployee().getId().equals(id))
                    .map(EmployeeRoleDTO::toModel)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/role/{id}")
    public ResponseEntity getByRole(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getAll().stream().filter(x -> Objects.equals(x.getRole().getId(), id))
                    .map(EmployeeRoleDTO::toModel)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

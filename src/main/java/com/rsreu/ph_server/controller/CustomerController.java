package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.entity.Customer;
import com.rsreu.ph_server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        try {
            customerService.save(customer);
            return ResponseEntity.ok("Заказчик добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        try {
            customerService.update(id, customer);
            return ResponseEntity.ok("Данные обновлены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        try {
            customerService.delete(id);
            return ResponseEntity.ok("Заказчик удалён");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(customerService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getCustomer(@PathVariable long id) {
        try {
            return ResponseEntity.ok(customerService.getCustomer(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

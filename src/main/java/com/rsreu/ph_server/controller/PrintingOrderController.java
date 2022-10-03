package com.rsreu.ph_server.controller;

import com.rsreu.ph_server.dto.OrderDTO;
import com.rsreu.ph_server.entity.*;
import com.rsreu.ph_server.repository.FavourRepo;
import com.rsreu.ph_server.repository.MachineRepo;
import com.rsreu.ph_server.repository.MaterialRepo;
import com.rsreu.ph_server.service.CustomerService;
import com.rsreu.ph_server.service.EmployeeService;
import com.rsreu.ph_server.service.PrintingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class PrintingOrderController {
    @Autowired
    private PrintingOrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MaterialRepo materialRepo;
    @Autowired
    private MachineRepo machineRepo;
    @Autowired
    private FavourRepo favourRepo;
    @Autowired
    private EmployeeService empService;

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody PrintingOrder order) {
        try {
            orderService.save(order);
            return ResponseEntity.ok("Заказ добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody PrintingOrder order) {
        try {
            orderService.update(id, order);
            return ResponseEntity.ok("Данные обновлены");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        try {
            orderService.delete(id);
            return ResponseEntity.ok("Заказ удалён");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(orderService.getAll().stream()
                    .map(OrderDTO::toDTO)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getOrder(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(OrderDTO.toDTO(orderService.getById(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/customer/{id}")
    public ResponseEntity getByCustomer(@PathVariable long id) {
        try {
            Customer customer = customerService.getCustomer(id);
            return ResponseEntity.ok(orderService.getOrderByCustomer(customer).stream()
                    .map(OrderDTO::toDTO)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/machine/{id}")
    public ResponseEntity getByMachine(@PathVariable long id) {
        try {
            Machine machine = machineRepo.findById(id).orElseThrow();
            return ResponseEntity.ok(orderService.getOrderByMachine(machine).stream()
                    .map(OrderDTO::toDTO)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/material/{id}")
    public ResponseEntity getByMaterial(@PathVariable long id) {
        try {
            Material material = materialRepo.findById(id).orElseThrow();
            return ResponseEntity.ok(orderService.getOrderByMaterial(material).stream()
                    .map(OrderDTO::toDTO)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/employee/{id}")
    public ResponseEntity getByEmployee(@PathVariable long id) {
        try {
            Employee employee = empService.getEmployee(id);
            return ResponseEntity.ok(orderService.getOrderByEmployee(employee).stream()
                    .map(OrderDTO::toDTO)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/service/{id}")
    public ResponseEntity getByService(@PathVariable long id) {
        try {
            Favour favour = favourRepo.findById(id).orElseThrow();
            return ResponseEntity.ok(orderService.getOrderByFavour(favour).stream()
                    .map(OrderDTO::toDTO)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

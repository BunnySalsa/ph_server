package com.rsreu.ph_server.service;

import com.rsreu.ph_server.entity.Customer;
import com.rsreu.ph_server.entity.Employee;
import com.rsreu.ph_server.entity.Favour;
import com.rsreu.ph_server.entity.Machine;
import com.rsreu.ph_server.entity.Material;
import com.rsreu.ph_server.entity.PrintingOrder;
import com.rsreu.ph_server.repository.PrintingOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PrintingOrderService {

    @Autowired
    private PrintingOrderRepo repo;

    public void save(PrintingOrder order) throws OrderMatchException {
        if (order.getBeginningDate().before(order.getEndingDate())
                && order.getVolume() > 0 && isMachineFree(order)) {
            repo.save(order);
        } else {
            throw new OrderMatchException();
        }
    }

    public void update(Long id, PrintingOrder order) {
        PrintingOrder order1 = repo.findById(id).orElseThrow();
        order1.setCustomer(order.getCustomer());
        order1.setEmployee(order.getEmployee());
        order1.setFavour(order.getFavour());
        order1.setEndingDate(order.getEndingDate());
        order1.setDeadLine(order.getDeadLine());
        order1.setMachine(order.getMachine());
        order1.setMaterial(order.getMaterial());
        order1.setVolume(order.getVolume());
        repo.save(order1);
    }

    public void delete(Long id) {
        PrintingOrder order = repo.findById(id).orElseThrow();
        repo.delete(order);
    }

    public List<PrintingOrder> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .toList();
    }

    public PrintingOrder getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<PrintingOrder> getOrderByCustomer(Customer customer) {
        return repo.findByCustomer(customer);
    }

    public List<PrintingOrder> getOrderByMachine(Machine machine) {
        return repo.findByMachine(machine);
    }

    public List<PrintingOrder> getOrderByEmployee(Employee employee) {
        return repo.findByEmployee(employee);
    }

    public List<PrintingOrder> getOrderByMaterial(Material material) {
        return repo.findByMaterial(material);
    }

    public List<PrintingOrder> getOrderByFavour(Favour favour) {
        return repo.findByFavour(favour);
    }

    public List<PrintingOrder> getOrderByEndDate(Date date) {
        return repo.findByEndingDate(date);
    }

    private boolean isMachineFree(PrintingOrder order) {
        List<PrintingOrder> list = getOrderByMachine(order.getMachine());
        return list.stream().noneMatch(x -> (order.getBeginningDate().after(x.getBeginningDate()) && order.getBeginningDate()
                .before(x.getEndingDate())) ||
                (order.getEndingDate().after(x.getBeginningDate()) && order.getEndingDate()
                        .before(x.getEndingDate())));
    }

    public static class OrderMatchException extends Exception {

        public OrderMatchException() {
            super("Заказ не может быть сохранен");
        }
    }
}

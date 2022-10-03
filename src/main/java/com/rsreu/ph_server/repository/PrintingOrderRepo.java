package com.rsreu.ph_server.repository;

import com.rsreu.ph_server.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PrintingOrderRepo extends CrudRepository<PrintingOrder, Long> {
    List<PrintingOrder> findByCustomer(Customer customer);
    List<PrintingOrder> findByEmployee(Employee employee);
    List<PrintingOrder> findByMachine(Machine machine);
    List<PrintingOrder> findByMaterial(Material material);
    List<PrintingOrder> findByFavour(Favour favour);
    List<PrintingOrder> findByEndingDate(Date date);
}

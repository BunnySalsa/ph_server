package com.rsreu.ph_server.repository;

import com.rsreu.ph_server.entity.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepo extends CrudRepository<Machine, Long> {
}

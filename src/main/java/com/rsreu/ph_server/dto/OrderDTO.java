package com.rsreu.ph_server.dto;

import com.rsreu.ph_server.entity.*;
import com.rsreu.ph_server.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private long id;
    private Customer customer;
    private Machine machine;
    private EmployeeDTO employee;
    private Material material;
    private Favour favour;
    private Date beginningDate;
    private Date endingDate;
    private Date deadLine;
    private Long volume;
    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private CustomerRepo customerRepo;
    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private EmployeeRepo employeeRepo;
    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private MachineRepo machineRepo;
    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private MaterialRepo materialRepo;
    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private FavourRepo favourRepo;

    public static OrderDTO toDTO(PrintingOrder order) {
        return OrderDTO.builder()
                .id(order.getId())
                .customer(order.getCustomer())
                .machine(order.getMachine())
                .employee(EmployeeDTO.toModel(order.getEmployee()))
                .material(order.getMaterial())
                .favour(order.getFavour())
                .beginningDate(order.getBeginningDate())
                .endingDate(order.getEndingDate())
                .deadLine(order.getDeadLine())
                .volume(order.getVolume())
                .build();
    }
}

package com.FuelManagemen.OrderService.Controller;

import com.FuelManagemen.OrderService.Entity.OrderStatus;
import com.FuelManagemen.OrderService.Service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StatusController {

    StatusService statusService;

    public List<OrderStatus> getStatus(){
        log.info("Executing getStatus() from controller");
        return statusService.findAll();
    }

    public OrderStatus getStatusById(@RequestParam("id") int id){
        log.info("Executing getStatusById() from controller");
        return statusService.findById(id);
    }
}

package com.FuelManagemen.OrderService.Controller;

import com.FuelManagemen.OrderService.Entity.ScheduleOrders;
import com.FuelManagemen.OrderService.Service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ScheduleController {
    ScheduleService scheduleService;

    public ScheduleOrders getScheduleDate(@RequestParam int id){
       log.info("Executing getScheduleData() from controller");
       return scheduleService.findById(id);
    }
}

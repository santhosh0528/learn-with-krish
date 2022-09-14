package com.FuelManagemen.OrderService.Controller;

import com.FuelManagemen.OrderService.Entity.OrderStatus;
import com.FuelManagemen.OrderService.Service.StatusService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class DeliveryController {
    StatusService statusService;

    @RequestMapping(value = "/delivery",method = RequestMethod.GET)
    public OrderStatus deliverOrder(@RequestParam("id") int id){
        return statusService.updateDeliverStatus(id);
    }
}

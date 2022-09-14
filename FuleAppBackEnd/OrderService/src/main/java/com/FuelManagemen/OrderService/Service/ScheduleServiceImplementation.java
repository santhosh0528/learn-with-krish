package com.FuelManagemen.OrderService.Service;

import com.FuelManagemen.OrderService.Entity.ScheduleOrders;
import com.FuelManagemen.OrderService.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImplementation implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public ScheduleOrders save(ScheduleOrders scheduleOrders) {
        return scheduleRepository.save(scheduleOrders);
    }

    @Override
    public ScheduleOrders findById(int id) {
        List<ScheduleOrders> list=scheduleRepository.findAll();
        ScheduleOrders scheduleOrders=new ScheduleOrders();
        for (ScheduleOrders scheduleOrder:list){
            if(scheduleOrder.getOrderId()==id){
                scheduleOrder.setScheduleId(scheduleOrder.getScheduleId());
                scheduleOrder.setOrderId(scheduleOrder.getOrderId());
                scheduleOrder.setTime(scheduleOrder.getTime());
                scheduleOrder.setDate(scheduleOrder.getDate());
            }
        }

        return scheduleOrders;
    }
}

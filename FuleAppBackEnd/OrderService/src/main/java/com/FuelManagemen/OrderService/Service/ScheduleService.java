package com.FuelManagemen.OrderService.Service;

import com.FuelManagemen.OrderService.Entity.ScheduleOrders;

public interface ScheduleService {
    ScheduleOrders save(ScheduleOrders scheduleOrders);
    ScheduleOrders findById(int id);
}

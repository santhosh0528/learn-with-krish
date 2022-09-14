package com.FuelManagemen.OrderService.Service;

import com.FuelManagemen.OrderService.Entity.OrderStatus;

import java.util.List;

public interface StatusService {
    OrderStatus save(OrderStatus orderStatus);
    List<OrderStatus> findAll();
    OrderStatus findById(int id);
    OrderStatus updateDeliverStatus(int id);
}

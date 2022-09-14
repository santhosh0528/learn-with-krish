package com.FuelManagemen.OrderService.Service;

import com.FuelManagemen.OrderService.Entity.OrderStatus;
import com.FuelManagemen.OrderService.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImplementation implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        return statusRepository.save(orderStatus);
    }

    @Override
    public List<OrderStatus> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public OrderStatus findById(int id) {

        return null;
    }

    @Override
    public OrderStatus updateDeliverStatus(int id) {
        return null;
    }
}

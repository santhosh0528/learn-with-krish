package com.FuelManagemen.Allocation.Service.Service;

import com.FuelManagemen.Allocation.Service.Entity.AllocatedStock;

import java.util.List;

public interface AllocatedStockService {

    AllocatedStock save(AllocatedStock stock);
    double allocatedOrders();
    List<AllocatedStock> findAll();
    void delete(int id);
}

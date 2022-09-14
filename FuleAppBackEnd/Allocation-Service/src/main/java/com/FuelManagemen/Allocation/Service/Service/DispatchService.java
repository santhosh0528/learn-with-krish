package com.FuelManagemen.Allocation.Service.Service;

import com.FuelManagemen.Allocation.Service.Entity.Dispatch;

import java.util.List;

public interface DispatchService {

    List<Dispatch> findAll();
    Dispatch save(Dispatch dispatch);
}

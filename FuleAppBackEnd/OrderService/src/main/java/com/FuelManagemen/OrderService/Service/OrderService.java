package com.FuelManagemen.OrderService.Service;

import com.FuelManagemen.OrderService.Entity.FuelOrder;
import com.FuelManagemen.OrderService.OrderDomain.FuelOrderData;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    FuelOrder save(FuelOrder oder);
    List<FuelOrder> findAll();
    Optional<FuelOrder> findById(int id);
    List<FuelOrderData> findStatusSuccessData();
    List<FuelOrderData> findDispatchedOrders();
    List<FuelOrderData> findDeliveredOrders();
    List<FuelOrderData> findOrdersByGasStationId(String id);
}

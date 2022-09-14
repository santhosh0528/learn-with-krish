package com.FuelManagemen.Allocation.Service.Service;

import com.FuelManagemen.Allocation.Service.Entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock save(Stock stock);
    Optional<Stock> get(int id);
    List<Stock> findAll();
}

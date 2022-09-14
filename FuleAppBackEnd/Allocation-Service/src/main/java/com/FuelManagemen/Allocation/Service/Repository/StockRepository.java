package com.FuelManagemen.Allocation.Service.Repository;

import com.FuelManagemen.Allocation.Service.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {
}

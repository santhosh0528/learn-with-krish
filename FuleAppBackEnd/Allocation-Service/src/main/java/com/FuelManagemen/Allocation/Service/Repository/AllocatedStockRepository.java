package com.FuelManagemen.Allocation.Service.Repository;

import com.FuelManagemen.Allocation.Service.Entity.AllocatedStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocatedStockRepository extends JpaRepository<AllocatedStock,Integer> {

}

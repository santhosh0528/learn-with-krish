package com.FuelManagemen.OrderService.Repository;


import com.FuelManagemen.OrderService.Entity.FuelOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<FuelOrder,Integer> {
}

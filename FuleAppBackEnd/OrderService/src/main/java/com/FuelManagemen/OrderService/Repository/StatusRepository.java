package com.FuelManagemen.OrderService.Repository;

import com.FuelManagemen.OrderService.Entity.OrderStatus;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<OrderStatus,Integer> {
}

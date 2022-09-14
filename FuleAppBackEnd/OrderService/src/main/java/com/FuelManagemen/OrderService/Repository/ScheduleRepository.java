package com.FuelManagemen.OrderService.Repository;

import com.FuelManagemen.OrderService.Entity.ScheduleOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleOrders,Integer> {
}

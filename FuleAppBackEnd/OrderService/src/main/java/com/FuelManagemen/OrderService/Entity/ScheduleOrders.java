package com.FuelManagemen.OrderService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleOrders {
    @Id
    @GeneratedValue
    private int scheduleId;
    private int orderId;
    private String date;
    private String time;
}

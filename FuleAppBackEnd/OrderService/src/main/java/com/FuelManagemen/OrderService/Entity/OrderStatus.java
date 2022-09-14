package com.FuelManagemen.OrderService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderStatus {
    @Id
    @GeneratedValue
    private int orderStatusID;
    private int orderID;
    private String allocation;
    private String schedule;
    private String dispatch;
    private String deliver;
    private String deliverDate;

}

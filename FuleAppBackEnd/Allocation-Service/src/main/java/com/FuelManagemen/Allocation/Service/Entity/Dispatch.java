package com.FuelManagemen.Allocation.Service.Entity;

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
public class Dispatch {
    @Id
    @GeneratedValue
    private int id;
    private int orderId;
    private String gasStationId;
    private String status;
}

package com.FuelManagemen.Allocation.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stock {
    @Id
    private int stockId;
    private String type;
    private double availableStock;
}

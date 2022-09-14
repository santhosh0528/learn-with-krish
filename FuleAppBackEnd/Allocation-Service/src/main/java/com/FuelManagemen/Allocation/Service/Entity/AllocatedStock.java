package com.FuelManagemen.Allocation.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllocatedStock {
    @Id
    private int allocatedId;
    private int id;
    private double qty;
    private String stockId;

}

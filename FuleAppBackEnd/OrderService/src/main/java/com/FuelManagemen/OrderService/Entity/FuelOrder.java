package com.FuelManagemen.OrderService.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuelOrder {
    @Id
    private int id;
    private String fuelStationId;
    private String name;
    private String address;
    private String mobile;
    private String qty;
    private String stockId;
    private String date;
    private String scheduleDate;
    private String time;


}

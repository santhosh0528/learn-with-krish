package com.FuelManagemen.Allocation.Service.controller;

import com.FuelManagemen.Allocation.Service.Entity.Stock;
import com.FuelManagemen.Allocation.Service.ObjectModel.StockObject;
import com.FuelManagemen.Allocation.Service.Service.AllocatedStockService;
import com.FuelManagemen.Allocation.Service.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class StockController {
    @Autowired
    StockService stockService;
    @Autowired
    AllocatedStockService allocatedStockService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public double placeOrder(){
        System.out.println("Call rest API");
        return allocatedStockService.allocatedOrders();
    }

    public List<StockObject> getStock(){
        List<StockObject> stockObjectList=new ArrayList<>();
        List<Stock> stocks=stockService.findAll();

        for(Stock stock:stocks){
            StockObject stockObject=new StockObject();
            stockObject.setStockId(stock.getStockId());
            stockObject.setType(stock.getType());
            stockObject.setAvailableStock(stock.getAvailableStock());
            stockObject.setProgress(stock.getAvailableStock());
            stockObject.setProgress(stock.getAvailableStock()*100/50000);
            stockObjectList.add(stockObject);
        }
          return stockObjectList;
    }
}

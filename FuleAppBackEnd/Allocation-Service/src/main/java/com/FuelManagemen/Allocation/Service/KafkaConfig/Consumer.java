package com.FuelManagemen.Allocation.Service.KafkaConfig;

import com.FuelManagemen.Allocation.Service.Entity.AllocatedStock;
import com.FuelManagemen.Allocation.Service.Entity.Stock;
import com.FuelManagemen.Allocation.Service.Service.AllocatedStockService;
import com.FuelManagemen.Allocation.Service.Service.StockService;
import com.FuelManagemen.Allocation.Service.Types.Event;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ProducerPostProcessor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class Consumer {

    @Autowired
    StockService stockService;
    @Autowired
    AllocatedStockService allocatedStockService;
    @Autowired
    Producer producer;
    @Autowired
    private ProducerSchedule producerSchedule;


    public void readMsg(String msg){
        Event event=new Gson().fromJson(msg,Event.class);
        if(event.getType().equals("PlaceNewOrder")){
            Optional<Stock> stock=stockService.get(Integer.parseInt(event.getStockId()));

            if(stock.isPresent()){
                double orderQty = Double.parseDouble(event.getQty());
                double availableQty = stock.get().getAvailableStock();

                if(availableQty >= orderQty){
                    if(availableQty >= allocatedStockService.allocatedOrders()+orderQty){
                        AllocatedStock allocatedStock=new AllocatedStock();
                        allocatedStock.setId(Integer.parseInt(event.getOrderId()));
                        allocatedStock.setQty(Double.parseDouble(event.getQty()));
                        allocatedStock.setStockId(event.getStockId());
                        allocatedStockService.save(allocatedStock);
                        log.info("save allocated order");

                        producer.publishToTopic(new Event("AllocationService","CompleteAllcation",event.getKey(), event.getQty(), event.getOrderId(), event.getStockId(),"Success"));
                        producerSchedule.publishToTopic(new Event("AllocationService","CompleteAllocation",event.getKey(),event.getQty(), event.getOrderId(), event.getStockId(),"Success" ));

                    }else {
                        System.out.println("No Stock");
                        log.info("No Stock Available");
                    }
                }else {
                    System.out.println("No Stock");
                    log.info("No stocks for allocation");
                }
            }
        }
    }

}

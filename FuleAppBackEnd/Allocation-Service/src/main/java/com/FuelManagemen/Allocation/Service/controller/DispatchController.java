package com.FuelManagemen.Allocation.Service.controller;

import com.FuelManagemen.Allocation.Service.Entity.AllocatedStock;
import com.FuelManagemen.Allocation.Service.Entity.Dispatch;
import com.FuelManagemen.Allocation.Service.Entity.Stock;
import com.FuelManagemen.Allocation.Service.KafkaConfig.ProducerDispatch;
import com.FuelManagemen.Allocation.Service.Service.AllocatedStockService;
import com.FuelManagemen.Allocation.Service.Service.DispatchService;
import com.FuelManagemen.Allocation.Service.Service.StockService;
import com.FuelManagemen.Allocation.Service.Types.Event;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@Transactional
public class DispatchController {
    @Autowired
    DispatchService dispatchService;
    @Autowired
    AllocatedStockService allocatedStockService;
    @Autowired
    StockService stockService;
    @Autowired
    ProducerDispatch producerDispatch;

    @RequestMapping(value = "/dispatch",method = RequestMethod.POST)
    public Dispatch save(@RequestBody Dispatch dispatch){
        List<AllocatedStock> allocatedStocks=allocatedStockService.findAll();
        for(AllocatedStock stock:allocatedStocks){
            if (stock.getId()==dispatch.getOrderId()){
                System.out.println("Not Equal");

                Optional<Stock> stock1=stockService.get(Integer.parseInt((stock.getStockId())));
                double availableStock=stock1.get().getAvailableStock();
                double dispatchQty=stock.getQty();
                double finalStock=availableStock-dispatchQty;
                Stock updatedStock= new Stock();
                updatedStock.setStockId(stock1.get().getStockId());
                updatedStock.setAvailableStock(finalStock);
                updatedStock.setType(stock1.get().getType());

                stockService.save(updatedStock);
                allocatedStockService.delete(stock.getAllocatedId());
                producerDispatch.publishToTopic(new Event("Dispatch","CompleteDispatch", String.valueOf(dispatch.getOrderId())
                        ,"", String.valueOf(dispatch.getOrderId()),String.valueOf(stock1.get().getStockId()),"Success"));
            }
        }
        return dispatchService.save(dispatch);
    }

    @RequestMapping(value = "/dispatch",method = RequestMethod.PUT)
    public Dispatch updateReceived(@RequestBody Dispatch dispatch){
        List<Dispatch> list=dispatchService.findAll();
        Dispatch newOb =new Dispatch();
        for(Dispatch dispatch1:list){
            if (dispatch1.getOrderId()==dispatch.getOrderId()){
                newOb.setId(dispatch.getId());
                newOb.setOrderId(dispatch.getOrderId());
                newOb.setStatus("Received");
                newOb.setGasStationId(dispatch.getGasStationId());
            }
        }
      return dispatchService.save(newOb);
    }

}

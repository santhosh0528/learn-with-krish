package com.FuelManagemen.Allocation.Service.Service;

import com.FuelManagemen.Allocation.Service.Entity.AllocatedStock;
import com.FuelManagemen.Allocation.Service.Repository.AllocatedStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocatedStockServiceImpl implements AllocatedStockService {

    @Autowired
    private AllocatedStockRepository allocatedStockRepository;

    @Override
    public AllocatedStock save(AllocatedStock stock) {
        return allocatedStockRepository.save(stock);
    }

    @Override
    public double allocatedOrders() {
        double d=0;
        List<AllocatedStock> allocatedStocks=allocatedStockRepository.findAll();
        for(AllocatedStock allocatedStock:allocatedStocks){
            d+=allocatedStock.getQty();
        }
        System.out.println("Allocated total stock is :"+d);
        return d;
    }

    @Override
    public List<AllocatedStock> findAll() {
        return allocatedStockRepository.findAll();
    }

    @Override
    public void delete(int id) {
        allocatedStockRepository.deleteById(id);
    }
}

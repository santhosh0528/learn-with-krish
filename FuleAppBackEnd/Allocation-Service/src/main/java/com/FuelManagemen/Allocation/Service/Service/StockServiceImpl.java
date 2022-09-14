package com.FuelManagemen.Allocation.Service.Service;

import com.FuelManagemen.Allocation.Service.Entity.Stock;
import com.FuelManagemen.Allocation.Service.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> get(int id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}

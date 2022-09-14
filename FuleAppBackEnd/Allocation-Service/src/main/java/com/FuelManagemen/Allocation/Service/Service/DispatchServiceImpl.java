package com.FuelManagemen.Allocation.Service.Service;

import com.FuelManagemen.Allocation.Service.Entity.Dispatch;
import com.FuelManagemen.Allocation.Service.Repository.DispatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchServiceImpl implements DispatchService{

    private DispatchRepository dispatchRepository;
    @Override
    public List<Dispatch> findAll() {
        return dispatchRepository.findAll();
    }

    @Override
    public Dispatch save(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }
}

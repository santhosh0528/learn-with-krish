package com.FuelManagemen.OrderService.Service;

import com.FuelManagemen.OrderService.Entity.FuelOrder;
import com.FuelManagemen.OrderService.Entity.OrderStatus;
import com.FuelManagemen.OrderService.Entity.ScheduleOrders;
import com.FuelManagemen.OrderService.OrderDomain.FuelOrderData;
import com.FuelManagemen.OrderService.Repository.OrderRepository;
import com.FuelManagemen.OrderService.Repository.ScheduleRepository;
import com.FuelManagemen.OrderService.Repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImplementation  implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;




    @Override
    public FuelOrder save(FuelOrder oder) {
        return orderRepository.save(oder);
    }

    @Override
    public List<FuelOrder> findAll() {
        log.info("Return All Order Details");
        return orderRepository.findAll();
    }

    @Override
    public Optional<FuelOrder> findById(int id) {
        log.info("Return find by id");
        return orderRepository.findById(id);
    }

    @Override
    public List<FuelOrderData> findStatusSuccessData() {
        List<FuelOrder> orders =orderRepository.findAll();
        List<OrderStatus> orderStatuses=statusRepository.findAll();
        List<ScheduleOrders> scheduleOrders=scheduleRepository.findAll();
        List<FuelOrderData> orderData=new ArrayList<>();

        for(FuelOrder order:orders) {
            for (OrderStatus orderStatus : orderStatuses) {
                for (ScheduleOrders scheduleOrder : scheduleOrders) {
                    if (order.getId() == orderStatus.getOrderID() && order.getId() == scheduleOrder.getOrderId() &&
                            orderStatus.getDispatch().equals("Pending")) {
                        FuelOrderData fuelOrderData = new FuelOrderData();
                        fuelOrderData.setId(order.getId());
                        fuelOrderData.setFuelStationId(order.getFuelStationId());
                        fuelOrderData.setName(order.getName());
                        fuelOrderData.setAddress(order.getAddress());
                        fuelOrderData.setMobile(order.getMobile());
                        fuelOrderData.setQty(order.getQty());
                        fuelOrderData.setStockId(order.getStockId());
                        fuelOrderData.setDate(order.getDate());
                        fuelOrderData.setDispatch(orderStatus.getDispatch());
                        fuelOrderData.setAllocation(orderStatus.getAllocation());
                        fuelOrderData.setSchedule(orderStatus.getSchedule());
                        fuelOrderData.setScheduleDate(scheduleOrder.getDate());
                        fuelOrderData.setScheduleTime(scheduleOrder.getTime());

                        orderData.add(fuelOrderData);
                    }

                }
            }
        }

        return orderData;

    }

    @Override
    public List<FuelOrderData> findDispatchedOrders() {
        List<FuelOrder> orders=orderRepository.findAll();
        List<OrderStatus> orderStatuses=statusRepository.findAll();
        List<ScheduleOrders> scheduleOrders=scheduleRepository.findAll();
        List<FuelOrderData> orderData=new ArrayList<>();
        for(FuelOrder order:orders){
            for (OrderStatus orderStatus:orderStatuses){
                for(ScheduleOrders scheduleOrder:scheduleOrders){
                    if(order.getId()==orderStatus.getOrderID() && order.getId()==scheduleOrder.getOrderId() &&
                            orderStatus.getDispatch().equals("Success") && orderStatus.getDeliver().equals("Pending")){
                        FuelOrderData data =new FuelOrderData();
                        data.setId(order.getId());
                        data.setFuelStationId(order.getFuelStationId());
                        data.setName(order.getName());
                        data.setAddress(order.getAddress());
                        data.setMobile(order.getMobile());
                        data.setQty(order.getQty());
                        data.setStockId(order.getStockId());
                        data.setDate(order.getDate());
                        data.setDispatch(orderStatus.getDispatch());
                        data.setAllocation(orderStatus.getAllocation());
                        data.setSchedule(orderStatus.getSchedule());
                        data.setScheduleDate(scheduleOrder.getDate());
                        data.setScheduleDate(scheduleOrder.getTime());


                        orderData.add(data);
                    }
                }
            }
        }
        return orderData;
    }

    @Override
    public List<FuelOrderData> findDeliveredOrders() {
        List<FuelOrder> orders =orderRepository.findAll();
        List<OrderStatus> orderStatuses=statusRepository.findAll();
        List<ScheduleOrders> scheduleOrders=scheduleRepository.findAll();
        List<FuelOrderData> orderData=new ArrayList<>();

        for(FuelOrder order:orders){
              for(OrderStatus orderStatus:orderStatuses){
                  for (ScheduleOrders scheduleOrder:scheduleOrders){
                      FuelOrderData data=new FuelOrderData();
                      data.setId(order.getId());
                      data.setFuelStationId(order.getFuelStationId());
                      data.setName(order.getName());
                      data.setAddress(order.getAddress());
                      data.setMobile(order.getMobile());
                      data.setQty(order.getQty());
                      data.setStockId(order.getStockId());
                      data.setDate(order.getDate());
                      data.setDispatch(orderStatus.getDispatch());
                      data.setAllocation(orderStatus.getAllocation());
                      data.setSchedule(orderStatus.getSchedule());
                      data.setScheduleDate(scheduleOrder.getDate());
                      data.setScheduleTime(orderStatus.getDeliverDate());

                      orderData.add(data);
                  }
              }
        }

        return orderData;
    }

    @Override
    public List<FuelOrderData> findOrdersByGasStationId(String id) {

        List<FuelOrder> orders=orderRepository.findAll();
        List<OrderStatus> orderStatuses=statusRepository.findAll();
        List<ScheduleOrders> scheduleOrders=scheduleRepository.findAll();
        List<FuelOrderData> orderData =new ArrayList<>();

         for(FuelOrder order:orders){
             for(OrderStatus orderStatus:orderStatuses) {
                 for (ScheduleOrders scheduleOrder : scheduleOrders) {
                     if(order.getFuelStationId().equals(id)){
                         if(order.getId()==orderStatus.getOrderID() && order.getId()==scheduleOrder.getOrderId()){
                             FuelOrderData data =new FuelOrderData();
                             data.setId(order.getId());
                             data.setFuelStationId(order.getFuelStationId());
                             data.setName(order.getName());
                             data.setAddress(order.getAddress());
                             data.setMobile(order.getMobile());
                             data.setQty(order.getQty());
                             data.setStockId(order.getStockId());
                             data.setDate(order.getDate());
                             data.setDispatch(orderStatus.getDispatch());
                             data.setAllocation(orderStatus.getAllocation());
                             data.setSchedule(orderStatus.getSchedule());
                             data.setDeliver(orderStatus.getDeliverDate());
                             data.setDeliverDate(orderStatus.getDeliverDate());
                             data.setScheduleDate(scheduleOrder.getDate());
                             data.setScheduleTime(orderStatus.getDeliverDate());

                             orderData.add(data);

                         }
                     }
                 }
             }
         }
        return orderData;
    }
}

package com.FuelManagemen.OrderService.Controller;

import com.FuelManagemen.OrderService.Entity.FuelOrder;
import com.FuelManagemen.OrderService.Entity.OrderStatus;
import com.FuelManagemen.OrderService.KafkaConfig.Producer;
import com.FuelManagemen.OrderService.OrderDomain.FuelOrderData;
import com.FuelManagemen.OrderService.Service.OrderService;
import com.FuelManagemen.OrderService.Service.StatusService;
import com.FuelManagemen.OrderService.Types.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private Producer producer;
    @Autowired
    OrderService orderService;
    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/order",method= RequestMethod.GET)
    public List<FuelOrder> getOrders(){
        log.info("Executing getOrder() method");
        return orderService.findAll();
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public FuelOrder save(@RequestBody FuelOrder order){
        SimpleDateFormat format =new SimpleDateFormat("dd-mm-yyyy");
        Date date = new Date();
        order.setId((int) (System.currentTimeMillis()&0xfffff));
        log.info("new ID Created");
        producer.publishToTopic(new Event("orderService","PlaceNewOrder",
                String.valueOf(order.getId()),order.getQty(),String.valueOf(order.getId()),order.getStockId(),"Pending"));
        OrderStatus orderStatus=new OrderStatus();
        orderStatus.setOrderID(order.getId());
        orderStatus.setAllocation("Pending");
        orderStatus.setSchedule("Pending");
        orderStatus.setDispatch("pending");
        orderStatus.setDeliver("Pending");

        log.info("status save success");
        statusService.save(orderStatus);

        log.info("Order save success");
        return orderService.save(order);
    }
    @RequestMapping(value = "/orderData",method = RequestMethod.GET)
    public Optional<FuelOrder> getById(@RequestParam("id") int id){
        log.info("getById() method call in Controller");
        return orderService.findById(id);
    }

    @RequestMapping(value = "/orderData",method = RequestMethod.GET)
    public List<FuelOrderData> findOrderDetails(){
        log.info("findOrderDetails() method call in controller");
        return orderService.findStatusSuccessData();
    }

    @RequestMapping(value = "dispatchedOrders",method = RequestMethod.GET)
    public List<FuelOrderData> findDispatchOrders(){
        log.info("findOrderDetails() method call in controller");
        return orderService.findDispatchedOrders();
    }

    @RequestMapping(value = "/deliveredOrders",method = RequestMethod.GET)
    public List<FuelOrderData> findDeliveredOrders(){
        log.info("findDeliveredOrders() method call in Controller");
        return orderService.findDeliveredOrders();
    }

    public List<FuelOrderData> findOrderByGasStationID(@RequestParam("id") String id){
        log.info("findDeliveredOrders() method call in Controller");
        return orderService.findOrdersByGasStationId(id);
    }
}

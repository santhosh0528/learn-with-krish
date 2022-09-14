package com.FuelManagemen.Allocation.Service.KafkaConfig;

import com.FuelManagemen.Allocation.Service.Types.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String topic="newOrderResponse";


    private KafkaTemplate<String,String> kafkaTemplate;

    public void publishToTopic(Event message){
        System.out.println("publishing to"+topic);
        Gson gson=new Gson();
        String newMsg= gson.toJson(message);
        this.kafkaTemplate.send(topic,newMsg);
    }

}

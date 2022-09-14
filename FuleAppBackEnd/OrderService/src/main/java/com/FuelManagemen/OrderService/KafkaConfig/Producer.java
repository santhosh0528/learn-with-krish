package com.FuelManagemen.OrderService.KafkaConfig;

import com.FuelManagemen.OrderService.Types.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    public static final String topic="newOrder";


    private KafkaTemplate<String,String> kafkaTemplate;

    public void publishToTopic(Event msg){
        System.out.println("publishing to"+topic);

        Gson g=new Gson();
        String newMassage=g.toJson(msg);
        this.kafkaTemplate.send(topic,newMassage);

    }

}

package com.FuelManagemen.Allocation.Service.KafkaConfig;

import com.FuelManagemen.Allocation.Service.Types.Event;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerSchedule {
    public static final String topic="newOrder";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void publishToTopic(Event message){
        System.out.println("publishing to schedule"+ topic);
        Gson gson=new Gson();
        String newMsg=gson.toJson(message);
        this.kafkaTemplate.send(topic,newMsg);
    }
}

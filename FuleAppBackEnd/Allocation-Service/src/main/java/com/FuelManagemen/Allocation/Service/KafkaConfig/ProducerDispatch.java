package com.FuelManagemen.Allocation.Service.KafkaConfig;

import com.FuelManagemen.Allocation.Service.Types.Event;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerDispatch {
    public static final String topic="newConnection";


    private KafkaTemplate<String,String> kafkaTemplate;

    public void publishToTopic(Event msg){
        System.out.println("Publishing Dispatch from order" +topic);
        Gson gson=new Gson();
        String newMsg= gson.toJson(msg);
        this.kafkaTemplate.send(topic,newMsg);
    }
}

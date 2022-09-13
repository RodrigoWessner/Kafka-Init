package br.com.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
    @Autowired
    @Value("${topic.name}")
    private String topic ;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message){
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topic, message);
    }
}

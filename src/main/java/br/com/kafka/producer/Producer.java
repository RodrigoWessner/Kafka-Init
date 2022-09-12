package br.com.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
    private final String topic ;
    private KafkaTemplate<String, String> kafkaTemplate;

    public Producer(@Value("${topic.name}")String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message){
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topic, message);
    }
}

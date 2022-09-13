package br.com.kafka.controller;

import br.com.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensageria")
public class MensageriaController {
    @Autowired
    private Producer producer;

    @GetMapping("/send")
    public ResponseEntity send(){
        producer.send("Mensagem de teste enviada ao tópico");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*@GetMapping("/get")
    public ResponseEntity get(){
        producer.get("Mensagem de teste enviada ao tópico");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }*/
}

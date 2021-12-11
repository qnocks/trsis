package com.example.lab5.services;

import com.example.lab5.domain.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

    @Value("${app.kafka.topic}")
    private String TOPIC;

    private final KafkaTemplate<String, Doctor> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Doctor> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Doctor doctor) {
        log.info("--- KAFKA --- Sending some doctor: " + doctor);
        kafkaTemplate.send(TOPIC, doctor);
    }
}
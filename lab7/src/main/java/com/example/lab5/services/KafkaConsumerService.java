package com.example.lab5.services;

import com.example.lab5.domain.Doctor;
import com.example.lab5.repositories.DoctorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final DoctorsRepository doctorsRepository;

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${app.kafka.group}")
    public void listen(Doctor doctor) {
        System.out.println("Received Doctor information : " + doctor);
        doctorsRepository.save(doctor);
    }
}



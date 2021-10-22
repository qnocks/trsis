package com.example.lab5.services;

import com.example.lab5.domain.Doctor;
import com.example.lab5.repositories.DoctorsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {
    private final DoctorsRepository doctorsRepository;

    @Autowired
    public KafkaConsumerService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    @KafkaListener(topics = "${lab7.kafka.topic}", groupId = "${lab7.kafka.group}")
    public void listen(Doctor doctor) {
        System.out.println("Received Doctor information : " + doctor);
        doctorsRepository.save(doctor);
    }
}



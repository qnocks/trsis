package com.example.lab5.services;

import com.example.lab5.domain.Doctor;
import com.example.lab5.repositories.DoctorsRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {
    private final DoctorsRepository doctorsRepository;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public DoctorsService(DoctorsRepository doctorsRepository, KafkaProducerService kafkaProducerService) {
        this.doctorsRepository = doctorsRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public List<Doctor> getAll() {
        return (List<Doctor>) doctorsRepository.findAll();
    }

    public Doctor get(Long id) {
        return doctorsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Doctor id: " + id));
    }

    public void save(Doctor doctor) {
        kafkaProducerService.sendMessage(doctor);
    }

    @SneakyThrows
    public Doctor update(Long id, Doctor doctor) {
        throw new NoSuchMethodException();
    }

    public void delete(Long id) {
        doctorsRepository.deleteById(id);
    }
}

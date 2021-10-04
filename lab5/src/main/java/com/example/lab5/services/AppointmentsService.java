package com.example.lab5.services;

import com.example.lab5.domain.Appointment;
import com.example.lab5.repositories.AppointmentsRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;

    @Autowired
    public AppointmentsService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    public List<Appointment> getAll() {
        return (List<Appointment>) appointmentsRepository.findAll();
    }

    public Appointment get(Long id) {
        return appointmentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Appointment id: " + id));
    }

    public Appointment save(Appointment appointment) {
        return appointmentsRepository.save(appointment);
    }

    @SneakyThrows
    public Appointment update(String id, Appointment appointment) {
        throw new NoSuchMethodException();
    }

    public void delete(Long id) {
        appointmentsRepository.deleteById(id);
    }

    public void deleteByDoctorId(Long id) {
        getAll().stream()
                .filter(a -> a.getDoctor().getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot delete doctor with id " + id));
    }

    public void deleteByPatientId(Long id) {
        getAll().stream()
                .filter(a -> a.getPatient().getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot delete patient with id " + id));
    }

}

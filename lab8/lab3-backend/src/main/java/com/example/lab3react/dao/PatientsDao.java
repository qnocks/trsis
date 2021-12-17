package com.example.lab3react.dao;

import com.example.lab3react.domain.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class PatientsDao implements CrudDao<Patient, Long> {
    private long id = 0L;
    private final Map<Long, Patient> patients = new HashMap<>();

    {
        Patient patient1 = new Patient(1L, "Пациент1", LocalDate.parse("1997-02-02"), "Казань");
        Patient patient2 = new Patient(2L, "Пациент2", LocalDate.parse("1998-03-03"), "Москва");
        Patient patient3 = new Patient(3L, "Пациент3", LocalDate.parse("1999-04-04"), "Санкт-Петербург");
        patients.put(patient1.getId(), patient1);
        patients.put(patient2.getId(), patient2);
        patients.put(patient3.getId(), patient3);
    }

    @Override
    public Patient save(Patient entity) {
        entity.setId(id++);
        patients.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        patients.remove(id);
    }

    @Override
    public Patient findById(Long id) {
        return patients.get(id);
    }

    @Override
    public List<Patient> findALl() {
        return new LinkedList<>(patients.values());
    }
}

package com.example.lab3react.dao;

import com.example.lab3react.domain.Patient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class PatientsDao implements CrudDao<Patient, Long> {
    private long id = 0L;
    private final Map<Long, Patient> patients = new HashMap<>();

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

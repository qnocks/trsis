package ru.qnocks.shared.dao;

import ru.qnocks.shared.domain.Patient;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PatientsDao implements CrudDao<Patient, Long> {
    private static PatientsDao instance;

    private long id = 0L;
    private final Map<Long, Patient> patients = new HashMap<>();

    public static PatientsDao getInstance() {
        if (instance == null) {
            instance = new PatientsDao();
        }
        return instance;
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

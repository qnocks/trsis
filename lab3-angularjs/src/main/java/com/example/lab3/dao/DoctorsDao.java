package com.example.lab3.dao;

import com.example.lab3.domain.Doctor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class DoctorsDao implements CrudDao<Doctor, Long> {
    private long id = 0L;
    private final Map<Long, Doctor> doctors = new HashMap<>();

    @Override
    public Doctor save(Doctor entity) {
        entity.setId(id++);
        doctors.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        doctors.remove(id);
    }

    @Override
    public Doctor findById(Long id) {
        return doctors.get(id);
    }

    @Override
    public List<Doctor> findALl() {
        return new LinkedList<>(doctors.values());
    }
}

package com.example.lab4.dao;

import com.example.lab4.domain.Appointment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class AppointmentsDao implements CrudDao<Appointment, Long> {
    private long id = 0L;
    private final Map<Long, Appointment> appointments = new HashMap<>();

    @Override
    public Appointment save(Appointment entity) {
        entity.setId(id++);
        appointments.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        appointments.remove(id);
    }

    @Override
    public Appointment findById(Long id) {
        return appointments.get(id);
    }

    @Override
    public List<Appointment> findALl() {
        return new LinkedList<>(appointments.values());
    }
}

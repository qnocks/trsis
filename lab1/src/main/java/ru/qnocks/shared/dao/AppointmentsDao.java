package ru.qnocks.shared.dao;

import ru.qnocks.shared.domain.Appointment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppointmentsDao implements CrudDao<Appointment, Long> {
    private static AppointmentsDao instance;

    private long id = 0L;
    Map<Long, Appointment> appointments = new HashMap<>();

    public static AppointmentsDao getInstance() {
        if (instance == null) {
            instance = new AppointmentsDao();
        }
        return instance;
    }

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

    public void deleteByDoctorId(Long doctorId) {
        for (Appointment a : appointments.values()) {
            if (a.getDoctorId().equals(doctorId)) {
                appointments.remove(a.getId(), a);
            }
        }
    }

    public void deleteByPatientId(Long patientId) {
        for (Appointment a : appointments.values()) {
            if (a.getPatientId().equals(patientId)) {
                appointments.remove(a.getId(), a);
            }
        }
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

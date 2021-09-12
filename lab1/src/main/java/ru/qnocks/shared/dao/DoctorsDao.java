package ru.qnocks.shared.dao;

import ru.qnocks.shared.domain.Doctor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DoctorsDao implements CrudDao<Doctor, Long> {
    private static DoctorsDao instance;

    private long id = 0L;
    private static final Map<Long, Doctor> doctors = new HashMap<>();

    public static DoctorsDao getInstance() {
        if (instance == null) {
            instance = new DoctorsDao();
        }
        return instance;
    }

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

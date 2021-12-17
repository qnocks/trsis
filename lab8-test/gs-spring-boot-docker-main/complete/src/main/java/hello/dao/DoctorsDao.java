package hello.dao;

import hello.domain.Doctor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class DoctorsDao implements CrudDao<Doctor, Long> {
    private long id = 0L;
    private final Map<Long, Doctor> doctors = new HashMap<>();

    {
        Doctor doctor1 = new Doctor(1L, "Доктор1", "Специальность1", "14:00-16:23");
        Doctor doctor2 = new Doctor(2L, "Доктор2", "Специальность2", "15:00-16:23");
        Doctor doctor3 = new Doctor(3L, "Доктор3", "Специальность3", "16:00-16:23");
        doctors.put(doctor1.getId(), doctor1);
        doctors.put(doctor2.getId(), doctor2);
        doctors.put(doctor3.getId(), doctor3);
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

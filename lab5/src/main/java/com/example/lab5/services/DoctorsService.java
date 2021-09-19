package com.example.lab5.services;

import com.example.lab5.domain.Doctor;
import com.example.lab5.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {
    private final DoctorsRepository doctorsRepository;

    @Autowired
    public DoctorsService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
        receiveDataFromDb();
    }

    public List<Doctor> getAll() {
        return (List<Doctor>) doctorsRepository.findAll();
    }

    public Doctor get(Long id) {
        return doctorsRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorsCrudDao.save(doctor);
    }

    public Doctor update(String id, Doctor doctor) {
        return doctorsCrudDao.update(id, doctor);
    }

    public void delete(String id) {
        doctorsCrudDao.delete(id);
    }

    public void deleteAll() {
        DoctorsDao doctorsDao = (DoctorsDao) this.doctorsCrudDao;
        doctorsDao.deleteAll();
    }

    public Doctor findByFullName(String fullName) {
        DoctorsDao doctorsDao = (DoctorsDao) this.doctorsCrudDao;
        return doctorsDao.findByFullName(fullName);
    }

    public List<Doctor> findBySpecialty(String specialty) {
        DoctorsDao doctorsDao = (DoctorsDao) this.doctorsCrudDao;
        return doctorsDao.findBySpecialty(specialty);
    }

    public void receiveDataFromDb() {
        List<Doctor> doctors = (List<Doctor>) doctorsRepository.findAll();
        for (var d : doctors) doctorsCrudDao.save(d);
    }

    public void persist() {
        doctorsRepository.deleteAll();
        getAll().forEach(doctorsRepository::save);
    }

}

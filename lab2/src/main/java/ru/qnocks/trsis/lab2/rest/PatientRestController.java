package ru.qnocks.trsis.lab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qnocks.trsis.lab2.dao.AppointmentsDao;
import ru.qnocks.trsis.lab2.dao.PatientsDao;
import ru.qnocks.trsis.lab2.domain.Appointment;
import ru.qnocks.trsis.lab2.domain.Patient;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientRestController {
    private final PatientsDao patientsDao;

    @Autowired
    public PatientRestController(PatientsDao patientsDao) {
        this.patientsDao = patientsDao;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> list() {
        return new ResponseEntity<>(patientsDao.findALl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(patientsDao.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientsDao.save(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        patientsDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

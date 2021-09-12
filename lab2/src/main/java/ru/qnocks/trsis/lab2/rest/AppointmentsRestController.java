package ru.qnocks.trsis.lab2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qnocks.trsis.lab2.dao.AppointmentsDao;
import ru.qnocks.trsis.lab2.domain.Appointment;
import ru.qnocks.trsis.lab2.domain.Doctor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentsRestController {
    private final AppointmentsDao appointmentsDao;

    @Autowired
    public AppointmentsRestController(AppointmentsDao appointmentsDao) {
        this.appointmentsDao = appointmentsDao;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> list() {
        return new ResponseEntity<>(appointmentsDao.findALl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Appointment> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(appointmentsDao.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentsDao.save(appointment), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        appointmentsDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
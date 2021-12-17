package hello.rest;

import hello.dao.AppointmentsDao;
import hello.dao.DoctorsDao;
import hello.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsRestController {

    private final DoctorsDao doctorsDao;

    private final AppointmentsDao appointmentsDao;

    @Autowired
    public DoctorsRestController(DoctorsDao doctorsDao, AppointmentsDao appointmentsDao) {
        this.doctorsDao = doctorsDao;
        this.appointmentsDao = appointmentsDao;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> list() {
        return new ResponseEntity<>(doctorsDao.findALl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Doctor> show(@PathVariable("id") Long id) {
        Doctor doctor = doctorsDao.findById(id);
        if (doctor == null) {
            throw new IllegalArgumentException("Cannot find doctor with id " + id);
        }
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorsDao.save(doctor), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        doctorsDao.delete(id);
        appointmentsDao.deleteByDoctorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.lab3.controller;

import com.example.lab3.dao.AppointmentsDao;
import com.example.lab3.dao.PatientsDao;
import com.example.lab3.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/patients")
public class PatientsController {
    private final PatientsDao patientsDao;
    private final AppointmentsDao appointmentsDao;

    @Autowired
    public PatientsController(PatientsDao patientsDao, AppointmentsDao appointmentsDao) {
        this.patientsDao = patientsDao;
        this.appointmentsDao = appointmentsDao;
    }

    @GetMapping
    public String list() {
        return "patients/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("patients") Patient patient) {
        return "patients/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "patients/new";
        }
        patientsDao.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        patientsDao.delete(id);
        appointmentsDao.deleteByPatientId(id);
        return "redirect:/doctors";
    }
}

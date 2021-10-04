package com.example.lab3.controller;

import com.example.lab3.dao.AppointmentsDao;
import com.example.lab3.dao.DoctorsDao;
import com.example.lab3.domain.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
    private final DoctorsDao doctorsDao;
    private final AppointmentsDao appointmentsDao;

    @Autowired
    public AppointmentsController(DoctorsDao doctorsDao, AppointmentsDao appointmentsDao) {
        this.doctorsDao = doctorsDao;
        this.appointmentsDao = appointmentsDao;
    }

    @GetMapping
    public String list() {
        return "appointments/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("appointments") Appointment appointment) {
        return "appointments/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Appointment appointment, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "appointments/new";
        }
        appointmentsDao.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        doctorsDao.delete(id);
        appointmentsDao.deleteByDoctorId(id);
        return "redirect:/doctors";
    }
}

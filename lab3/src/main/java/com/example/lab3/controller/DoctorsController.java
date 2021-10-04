package com.example.lab3.controller;

import com.example.lab3.dao.AppointmentsDao;
import com.example.lab3.dao.DoctorsDao;
import com.example.lab3.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/doctors")
public class DoctorsController {
    private final DoctorsDao doctorsDao;

    @Autowired
    public DoctorsController(DoctorsDao doctorsDao, AppointmentsDao appointmentsDao) {
        this.doctorsDao = doctorsDao;
        this.appointmentsDao = appointmentsDao;
    }

    @GetMapping
    public String list() {
        return "doctors/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("doctor") Doctor doctor) {
        return "doctors/new";
    }
}

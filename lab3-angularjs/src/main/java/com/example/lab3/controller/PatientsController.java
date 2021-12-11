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
    @GetMapping
    public String list() {
        return "patients/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("patients") Patient patient) {
        return "patients/new";
    }
}

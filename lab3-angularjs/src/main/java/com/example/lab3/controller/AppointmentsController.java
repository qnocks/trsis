package com.example.lab3.controller;

import com.example.lab3.domain.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {

    @GetMapping
    public String list() {
        return "appointments/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("appointments") Appointment appointment) {
        return "appointments/new";
    }

}

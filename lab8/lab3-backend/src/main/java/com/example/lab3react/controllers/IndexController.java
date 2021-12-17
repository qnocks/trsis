package com.example.lab3react.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String homepage() {
        return "index";
    }

    @GetMapping("/doctors")
    public String doctors() {
        return "doctors/list";
    }

    @GetMapping("/patients")
    public String patients() {
        return "patients/list";
    }

    @GetMapping("/appointments")
    public String appointments() {
        return "appointments/list";
    }
}

package com.example.lab3.controller;

import com.example.lab3.domain.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctors")
public class DoctorsController {

    @GetMapping
    public String list() {
        return "doctors/list";
    }

    @GetMapping("/new")
    public String createForm() {
        return "doctors/new";
    }
}

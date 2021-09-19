package com.example.lab3.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDate date;
    private LocalTime time;

    public Appointment(Long doctorId, Long patientId, LocalDate date, LocalTime time) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
    }

    public Appointment(Long id, Long doctorId, Long patientId, LocalDate date, LocalTime time) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}

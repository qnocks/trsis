package com.example.lab3.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private Long id;
    private String fullName;
    private String specialty;
    private String schedule;
}

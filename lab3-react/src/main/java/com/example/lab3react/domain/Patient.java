package com.example.lab3react.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class Patient {
    private Long id;
    @NonNull
    private String fullName;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String address;
}

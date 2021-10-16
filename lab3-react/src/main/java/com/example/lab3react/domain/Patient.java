package com.example.lab3react.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

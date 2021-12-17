package hello.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
public class Appointment {
    private Long id;
    @NonNull
    private Long doctorId;
    @NonNull
    private Long patientId;
    @NonNull
    private LocalDate date;
    @NonNull
    private LocalTime time;
}

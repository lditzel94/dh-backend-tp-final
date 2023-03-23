package com.digitalhouse.tpfinal.shared.model.domain;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Appointment(
        Long id,
        Patient patient,
        Dentist dentist,
        LocalDateTime dateTime
) {
}

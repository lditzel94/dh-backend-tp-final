package com.digitalhouse.tpfinal.shared.model.dto;

import com.digitalhouse.tpfinal.dentist.model.domain.Dentist;
import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import com.digitalhouse.tpfinal.shared.model.domain.Appointment;

import java.time.LocalDateTime;

public record AppointmentRequest(
        Long patientId,
        Long dentistId,
        LocalDateTime appointmentDateTime
) {

    public Appointment toDomain( Dentist dentist, Patient patient ) {
        return Appointment.builder()
                          .dentist( dentist )
                          .patient( patient )
                          .dateTime( appointmentDateTime )
                          .build();
    }
}

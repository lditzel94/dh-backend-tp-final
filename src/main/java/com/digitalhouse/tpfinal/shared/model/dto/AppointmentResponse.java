package com.digitalhouse.tpfinal.shared.model.dto;

import com.digitalhouse.tpfinal.shared.model.domain.Appointment;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AppointmentResponse(
        Long id,
        Long dentistId,
        Long patientId,
        LocalDateTime appointmentDateTime
) {

    public static AppointmentResponse from( Appointment appointment ) {
        return AppointmentResponse.builder()
                                  .id( appointment.id() )
                                  .dentistId( appointment.dentist().id() )
                                  .patientId( appointment.patient().id() )
                                  .appointmentDateTime( appointment.dateTime() )
                                  .build();
    }
}

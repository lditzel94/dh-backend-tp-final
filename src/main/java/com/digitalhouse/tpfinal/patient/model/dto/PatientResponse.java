package com.digitalhouse.tpfinal.patient.model.dto;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@Deprecated(forRemoval = true)
public record PatientResponse(
        Long id,
        String lastName,
        String firstName,
        String address,
        String dni,
        LocalDate createdDate
) {

    public static PatientResponse from( Patient patient ) {
        var address = String.format( "%s, %d", patient.address().street(), patient.address().number() );
        return PatientResponse.builder()
                              .id( patient.id() )
                              .lastName( patient.lastName() )
                              .firstName( patient.firstName() )
                              .address( address )
                              .dni( patient.dni() )
                              .createdDate( patient.createdDate() )
                              .build();
    }
}

package com.digitalhouse.tpfinal.patient.model.dto;

import com.digitalhouse.tpfinal.patient.model.domain.Patient;
import lombok.Builder;

@Builder
public record PatientResponse(
        Long id,
        String lastName,
        String firstName,
        String address, //TODO: refactor to Address object
        String dni,
        String createdDate //TODO: refactor to some timestamp type
) {

    public static PatientResponse from( Patient patient ) {
        return PatientResponse.builder()
                              .id( patient.id() )
                              .lastName( patient.lastName() )
                              .firstName( patient.firstName() )
                              .address( patient.address() )
                              .dni( patient.dni() )
                              .createdDate( patient.createdDate() )
                              .build();
    }
}